package htwberlin.Webtech_Trainingsplan;

import htwberlin.Webtech_Trainingsplan.Workout.Workout;
import htwberlin.Webtech_Trainingsplan.Workout.WorkoutRepository;
import htwberlin.Webtech_Trainingsplan.Workout.WorkoutService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
public class WorkoutServiceTest {
    @Autowired
    private WorkoutService service;

    @MockBean
    private WorkoutRepository repository;

    @Test
    @DisplayName("Test findById Success")
    void testFindById() {
        // Setup our mock repository
        Workout workout = new Workout("Brust/Trizeps","Bankdrücken", "Schrägbankdrücken", "Flys", "Seitheben", "Trizepsdrücken", "Dips");
        workout.setId(1L);
        doReturn(Optional.of(workout)).when(repository).findById(1L);

        // Execute the service call
        Workout returnedWorkout = service.get(1L);

        // Assert the response
        assertEquals("Brust/Trizeps", returnedWorkout.getWorkoutname(), "Der Workoutname sollte gleich sein");
    }

    @Test
    @DisplayName("Test findById")
    void testFindByIdTwo(){
        Workout workout = new Workout("Brust/Trizeps","Bankdrücken", "Schrägbankdrücken", "Flys", "Seitheben", "Trizepsdrücken", "Dips");
        workout.setId(1L);
        Workout workout2 = new Workout("Brust/Trizeps","Bankdrücken", "Schrägbankdrücken", "Flys", "Seitheben", "Trizepsdrücken", "Dips");
        workout2.setId(2L);

        doReturn(Optional.of(workout)).when(repository).findById(1L);
        doReturn(Optional.of(workout2)).when(repository).findById(2L);

        Workout returnedWorkout = service.get(1L);

        assertEquals("Brust/Trizeps", returnedWorkout.getWorkoutname(), "Der Workoutname sollte gleich sein");
    }
}