package TommasoEleodori.dao;

import TommasoEleodori.entities.Partecipazione;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PartecipazioneDAO {
    private final EntityManager em;

    public PartecipazioneDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Partecipazione partecipazione) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(partecipazione);
        transaction.commit();
        System.out.println("nuova partecipazione salvata");
    }

    public Partecipazione getById(long id) {
        return em.find(Partecipazione.class, id);
    }

    public void delete(Partecipazione partecipazione) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.remove(partecipazione);
        transaction.commit();
        System.out.println("partecipazione cancellata");
    }

    public Partecipazione refresh(Partecipazione partecipazione) {
        em.refresh(partecipazione);
        return partecipazione;
    }
}
