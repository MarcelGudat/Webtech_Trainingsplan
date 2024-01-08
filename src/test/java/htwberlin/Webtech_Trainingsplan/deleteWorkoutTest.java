package htwberlin.Webtech_Trainingsplan;

import htwberlin.Webtech_Trainingsplan.Workout.WorkoutController;
import htwberlin.Webtech_Trainingsplan.Workout.WorkoutService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.verify;

@WebMvcTest(WorkoutController.class)
public class deleteWorkoutTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WorkoutService service;

    @Test
    public void testDeleteWorkout() throws Exception {
        // Annahmen
        Long workoutIdToDelete = 1L;

        // Testausführung und Verifikation
        mockMvc.perform(delete("/workout/{id}", workoutIdToDelete))
                .andExpect(status().isOk());

        // Überprüfen, ob der Service-Methode mit der erwarteten ID aufgerufen wurde
        verify(service).delete(workoutIdToDelete);
    }
}