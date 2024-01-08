package htwberlin.Webtech_Trainingsplan.Workout;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String workoutname;
    private String uebung1;
    private String uebung2;
    private String uebung3;
    private String uebung4;
    private String uebung5;
    private String uebung6;

    public Workout(long l, String s, String s1) {}

    public Workout(String workoutname, String uebung1, String uebung2, String uebung3, String uebung4, String uebung5, String uebung6) {
        this.workoutname = workoutname;
        this.uebung1 = uebung1;
        this.uebung2 = uebung2;
        this.uebung3 = uebung3;
        this.uebung4 = uebung4;
        this.uebung5 = uebung5;
        this.uebung6 = uebung6;
    }

    public Workout() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWorkoutname() {
        return workoutname;
    }

    public void setWorkoutname(String workoutname) {
        this.workoutname = workoutname;
    }

    public String getUebung1() { return uebung1; }
    public String getUebung2() {
        return uebung2;
    }

    public String getUebung3() {
        return uebung3;
    }

    public String getUebung4() {
        return uebung4;
    }

    public String getUebung5() {
        return uebung5;
    }

    public String getUebung6() {
        return uebung6;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Workout)) return false;

        Workout workout = (Workout) o;

        if (getUebung1() != workout.getUebung1()) return false;
        if (getUebung2() != workout.getUebung2()) return false;
        if (getUebung3() != workout.getUebung3()) return false;
        if (getUebung4() != workout.getUebung4()) return false;
        if (getUebung5() != workout.getUebung5()) return false;
        if (getUebung6() != workout.getUebung6()) return false;
        if (getId() != null ? !getId().equals(workout.getId()) : workout.getId() != null) return false;
        return getWorkoutname() != null ? getWorkoutname().equals(workout.getWorkoutname()) : workout.getWorkoutname() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getWorkoutname() != null ? getWorkoutname().hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "Workout{" +
                "id=" + id +
                ", Workoutname='" + workoutname + '\'' +
                ", Übung1='" + uebung1 + '\'' +
                ", Übung2='" + uebung2 + '\'' +
                ", Übung3='" + uebung3 + '\'' +
                ", Übung4='" + uebung4 + '\'' +
                ", Übung5='" + uebung5 + '\'' +
                ", Übung6='" + uebung6 + '\'' +
                '}';
    }
}
