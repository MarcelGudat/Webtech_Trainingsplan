package htwberlin.Webtech_Trainingsplan.Uebung;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UebungRepository extends CrudRepository<Uebung, Long> { }