package TommasoEleodori.dao;

import TommasoEleodori.entities.Evento;
import TommasoEleodori.entities.GaraDiAtletica;
import TommasoEleodori.entities.PartitaDiCalcio;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PartitaDiCalcioDAO {
    private final EntityManager em;

    public PartitaDiCalcioDAO(EntityManager em) {
        this.em = em;
    }

    public void save(PartitaDiCalcio partita) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(partita);
        transaction.commit();
        System.out.println("nuova partita salvata");
    }

    public PartitaDiCalcio getById(long id) {
        return em.find(PartitaDiCalcio.class, id);
    }

    public void delete(PartitaDiCalcio partita) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.remove(partita);
        transaction.commit();
        System.out.println("partita cancellata");
    }

    public PartitaDiCalcio refresh(PartitaDiCalcio partita) {
        em.refresh(partita);
        return partita;
    }
}
