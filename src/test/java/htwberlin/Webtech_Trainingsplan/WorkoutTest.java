package htwberlin.Webtech_Trainingsplan;

import htwberlin.Webtech_Trainingsplan.Workout.Workout;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class WorkoutTest {

    @Test
    void testToString() {
        //Eingabedaten
        String workoutname = "Brust/Trizeps";
        String uebung1 = "Bankdrücken";
        String uebung2 = "Schrägbankdrücken";
        String uebung3 = "Flys";
        String uebung4 = "Seitheben";
        String uebung5 = "Trizepsdrücken";
        String uebung6 = "Dips";


        //"System under test" aufsetzen
        Workout workout = new Workout(workoutname, uebung1, uebung2, uebung3, uebung4, uebung5, uebung6);
        workout.setId(42L);

        //Erwartetes Ergebnis
        String expected = "Workout{id=42, Workoutname='Brust/Trizeps', Übung1='Bankdrücken', Übung2='Schrägbankdrücken', Übung3='Flys', Übung4='Seitheben', Übung5='Trizepsdrücken', Übung6='Dips'}";

        //Tatsächliches Ergebnis
        String actual = workout.toString();

        //Vergleich
        assertEquals(expected, actual);
    }

    @Test
    void testHashCode() {
        // Eingabedaten
        String workoutname = "Brust/Trizeps";
        String uebung1 = "Bankdrücken";
        String uebung2 = "Schrägbankdrücken";
        String uebung3 = "Flys";
        String uebung4 = "Seitheben";
        String uebung5 = "Trizepsdrücken";
        String uebung6 = "Dips";

        // "System under test" aufsetzen
        Workout workout1 = new Workout(workoutname, uebung1, uebung2, uebung3, uebung4, uebung5, uebung6);
        workout1.setId(42L);

        Workout workout2 = new Workout(workoutname, uebung1, uebung2, uebung3, uebung4, uebung5, uebung6);
        workout2.setId(42L);

        // Erwartetes Ergebnis: Beide Objekte haben denselben Hashcode, da sie identisch sind
        assertEquals(workout1.hashCode(), workout2.hashCode());

        // Änderung des workoutname für workout2
        workout2.setWorkoutname("Beine");

        // Erwartetes Ergebnis: Da workoutname unterschiedlich ist, sollten die Hashcodes unterschiedlich sein
        assertNotEquals(workout1.hashCode(), workout2.hashCode());
    }

    @Test
    void testEquals() {
        // Eingabedaten
        String workoutname = "Brust/Trizeps";
        String uebung1 = "Bankdrücken";
        String uebung2 = "Schrägbankdrücken";
        String uebung3 = "Flys";
        String uebung4 = "Seitheben";
        String uebung5 = "Trizepsdrücken";
        String uebung6 = "Dips";

        // "System under test" aufsetzen
        Workout workout1 = new Workout(workoutname, uebung1, uebung2, uebung3, uebung4, uebung5, uebung6);
        workout1.setId(42L);

        Workout workout2 = new Workout(workoutname, uebung1, uebung2, uebung3, uebung4, uebung5, uebung6);
        workout2.setId(42L);

        Workout workout3 = new Workout("Beine", uebung1, uebung2, uebung3, uebung4, uebung5, uebung6);
        workout3.setId(43L);

        // Testen, ob zwei identische Objekte als gleich erkannt werden
        assertTrue(workout1.equals(workout2));

        // Testen, ob zwei verschiedene Objekte als ungleich erkannt werden
        assertFalse(workout1.equals(workout3));

        // Testen, ob das Objekt mit sich selbst als gleich erkannt wird
        assertTrue(workout1.equals(workout1));

        // Testen, ob das Objekt mit einem anderen Typ als ungleich erkannt wird
        assertFalse(workout1.equals("String"));
    }
}
