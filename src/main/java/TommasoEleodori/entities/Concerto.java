package TommasoEleodori.entities;

import TommasoEleodori.enums.Genere;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "concerti")
public class Concerto extends Evento{
private Genere genere;
private Boolean inStreaming;

public Concerto(){}
    public Concerto(Genere genere, Boolean inStreaming){
    super();
    if (genere != null || inStreaming != null){
        this.genere = genere;
        this.inStreaming = inStreaming;
    }throw new IllegalArgumentException("i dati non possono essere null o vuoti");
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public Boolean getInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(Boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "genere=" + genere +
                ", inStreaming=" + inStreaming +
                '}' + super.toString();
    }
}
