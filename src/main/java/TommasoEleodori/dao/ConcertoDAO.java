package TommasoEleodori.dao;

import TommasoEleodori.entities.Concerto;
import TommasoEleodori.entities.Evento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class ConcertoDAO {
    private final EntityManager em;

    public ConcertoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Concerto concerto) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(concerto);
        transaction.commit();
        System.out.println("nuovo concerto salvato");
    }

    public Concerto getById(long id) {
        return em.find(Concerto.class, id);
    }

    public void delete(Concerto concerto) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.remove(concerto);
        transaction.commit();
        System.out.println("concerto cancellato");
    }

    public Concerto refresh(Concerto concerto) {
        em.refresh(concerto);
        return concerto;
    }

    public List<Concerto> inStreaming() {
        TypedQuery<Concerto> getInStreaming = em.createQuery("SELECT c FROM Concerto c WHERE c.inStreaming = true");
        return getInStreaming.getResultList();
    }

}
