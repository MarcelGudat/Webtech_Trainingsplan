package htwberlin.Webtech_Trainingsplan;

import jakarta.persistence.*;

@Entity
public class Uebung {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String beschreibung;

    public Uebung() {}

    public Uebung(String name, int price) {
        this.name = name;
        this.beschreibung = beschreibung;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Uebung)) return false;

        Uebung uebung = (Uebung) o;

        if (getBeschreibung() != uebung.getBeschreibung()) return false;
        if (getId() != null ? !getId().equals(uebung.getId()) : uebung.getId() != null) return false;
        return getName() != null ? getName().equals(uebung.getName()) : uebung.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getBeschreibung() != null ? getBeschreibung().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Uebung{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", beschreibung=" + beschreibung +
                '}';
    }
}
