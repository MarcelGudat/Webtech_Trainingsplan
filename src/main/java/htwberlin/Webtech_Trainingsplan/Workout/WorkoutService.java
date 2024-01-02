package htwberlin.Webtech_Trainingsplan.Workout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class WorkoutService {

    @Autowired
    WorkoutRepository repo;

    public Workout save(Workout file) {
        return repo.save(file);
    }

    public Workout get(Long id) {
        return repo.findById(id).get();
    }

    public Iterable<Workout> getAll() {
        return repo.findAll();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}