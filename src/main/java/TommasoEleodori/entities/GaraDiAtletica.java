package TommasoEleodori.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "gare_di_atletica")
public class GaraDiAtletica extends Evento{
    @ManyToMany
    @JoinTable(name = "persone_gare",
    joinColumns = @JoinColumn(name = "gara_id"),
    inverseJoinColumns = @JoinColumn(name = "persona_id"))
    private Set<Persona> atleti;
    @ManyToOne
    @JoinColumn(name = "vincitore_id")
    private Persona vincitore;

    public GaraDiAtletica(){}

    public GaraDiAtletica(Set<Persona> atleti, Persona vincitore) {
        super();
    if (atleti != null || atleti.isEmpty() || vincitore != null ) {
        this.atleti = atleti;
        this.vincitore = vincitore;
    } throw new IllegalArgumentException("i dati inseriti non possono essere vuoti o null");
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }
    public Persona getVincitore() {
        return vincitore;
    }

    public Set<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Persona> atleti) {
        this.atleti = atleti;
    }

    @Override
    public String toString() {
        return "GaraDiAtletica{" +
                "atleti=" + atleti +
                ", vincitore=" + vincitore +
                '}' + super.toString();
    }
}






