package htwberlin.Webtech_Trainingsplan.Workout;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutRepository extends CrudRepository<Workout, Long> { }