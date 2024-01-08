package htwberlin.Webtech_Trainingsplan;

import htwberlin.Webtech_Trainingsplan.Workout.Workout;
import htwberlin.Webtech_Trainingsplan.Workout.WorkoutController;
import htwberlin.Webtech_Trainingsplan.Workout.WorkoutService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(WorkoutController.class)
class getWorkoutsTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WorkoutService service;

    @Test
    void getWorkouts_ReturnsListOfWorkouts() throws Exception {
        // Mock data
        Workout workout1 = new Workout(1L, "Workout 1", "Description 1");
        Workout workout2 = new Workout(2L, "Workout 2", "Description 2");
        List<Workout> workoutList = Arrays.asList(workout1, workout2);

        // Mock the service to return the list of workouts
        when(service.getAll()).thenReturn(workoutList);

        // Perform GET request to /workouts
        mockMvc.perform(get("/workouts"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].name").value("Workout 1"))
                .andExpect(jsonPath("$[0].description").value("Description 1"))
                .andExpect(jsonPath("$[1].id").value(2L))
                .andExpect(jsonPath("$[1].name").value("Workout 2"))
                .andExpect(jsonPath("$[1].description").value("Description 2"));

        // Verify that the service method was called once
        verify(service, times(1)).getAll();
    }
}