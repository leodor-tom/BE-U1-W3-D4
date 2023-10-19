package TommasoEleodori.dao;

import TommasoEleodori.entities.Evento;
import TommasoEleodori.entities.GaraDiAtletica;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class GaraDiAtleticaDao {
    private final EntityManager em;

    public GaraDiAtleticaDao(EntityManager em) {
        this.em = em;
    }

    public void save(GaraDiAtletica gara) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(gara);
        transaction.commit();
        System.out.println("nuova gara salvata");
    }

    public GaraDiAtletica getById(long id) {
        return em.find(GaraDiAtletica.class, id);
    }

    public void delete(GaraDiAtletica gara) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.remove(gara);
        transaction.commit();
        System.out.println("gara cancellata");
    }

    public GaraDiAtletica refresh(GaraDiAtletica gara) {
        em.refresh(gara);
        return gara;
    }
}
