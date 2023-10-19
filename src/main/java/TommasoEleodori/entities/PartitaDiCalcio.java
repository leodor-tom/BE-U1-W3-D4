package TommasoEleodori.entities;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "partite_di_calcio")
@NamedQuery(name = "partiteVinteInCasa",
query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente = p.squadraCasa")
@NamedQuery(name = "partiteVinteInTrasferta",
        query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente = p.squadraOspite")
@NamedQuery(name = "partitePareggiate",
        query = "SELECT p FROM PartitaDiCalcio p WHERE p.squadraVincente = null")
public class PartitaDiCalcio  extends Evento{
    private String squadraCasa;
    private String squadraOspite;
    private String squadraVincente;
    private int golCasa;
    private int golOspite;

    public PartitaDiCalcio(){}

    public PartitaDiCalcio(String squadraCasa, String squadraOspite, String squadraVincente,
                           int golCasa, int golOspite){
        super();
        if (squadraCasa != null || squadraCasa.trim().isEmpty() || squadraOspite != null ||
        squadraOspite.trim().isEmpty() || golCasa  >= 0 || golOspite >= 0) {
            this.squadraCasa = squadraCasa;
            this.squadraOspite = squadraOspite;
            this.golCasa = golCasa;
            this.golOspite = golOspite;
            if(squadraVincente != null || squadraVincente.trim().isEmpty()) {
                this.squadraVincente = squadraVincente;
            } else this.squadraVincente = null;
        } else throw new IllegalArgumentException("i dati inseriti, fatta eccezione della squadra vincente, non possono essere null o vuoti, nè minori di 0 nel caso dei gol segnati");

    }

    public String getSquadraCasa() {
        return squadraCasa;
    }

    public void setSquadraCasa(String squadraCasa) {
        this.squadraCasa = squadraCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public int getGolCasa() {
        return golCasa;
    }

    public void setGolCasa(int golCasa) {
        this.golCasa = golCasa;
    }

    public int getGolOspite() {
        return golOspite;
    }

    public void setGolOspite(int golOspite) {
        this.golOspite = golOspite;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "squadraCasa='" + squadraCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", squadraVincente='" + squadraVincente + '\'' +
                ", golCasa=" + golCasa +
                ", golOspite=" + golOspite +
                '}' + super.toString();
    }
}
