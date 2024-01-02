package htwberlin.Webtech_Trainingsplan.Workout;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*", allowCredentials = "true")
public class WorkoutController {

    @Autowired
    WorkoutService service;

    Logger logger = LoggerFactory.getLogger(WorkoutController.class);

    @PostMapping("/workout")
    public Workout createWorkout(@RequestBody Workout workout) {
        return service.save(workout);
    }
    

    @GetMapping("/workout/{id}")
    public Workout getWorkout(@PathVariable Long id) {
        return service.get(id);
    }

    @GetMapping("/workouts")
    public Iterable<Workout> getWorkouts() { return service.getAll();}

    @DeleteMapping ("/workout/{id}")
    public void deleteWorkout(@PathVariable String id) {
        Long workoutid = Long.parseLong(id);
        service.delete(workoutid);
    }
}