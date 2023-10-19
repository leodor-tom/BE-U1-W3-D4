package TommasoEleodori.entities;

import TommasoEleodori.enums.Tipologia;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = " eventi")
public abstract class Evento {
    @Id
    @GeneratedValue
    private long id;
    private String titolo;
    private LocalDate dataEvento;
    private String descrizione;
    @Enumerated(EnumType.STRING)
    private Tipologia tipoEvento;
    private long numeroMassimoPartecipanti;

    @ManyToMany
    @JoinTable(name = "locations_eventi",
            joinColumns = @JoinColumn(name = "evento_id"),
            inverseJoinColumns = @JoinColumn(name = "location_id"))
    private Set<Location> locations;

    public Evento() {
    }

    public Evento(String titolo, LocalDate dataEvento, String descrizione, Tipologia tipoEvento, long numeroMassimoPartecipanti) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public Set<Location> getLocations() {
        return locations;
    }

    public void setLocations(Set<Location> locations) {
        this.locations = locations;
    }

    public long get_id() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Tipologia getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(Tipologia tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public long getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setNumeroMassimoPartecipanti(long numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "_id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                '}';
    }
}

