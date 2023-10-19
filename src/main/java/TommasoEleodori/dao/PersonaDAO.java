package TommasoEleodori.dao;

import TommasoEleodori.entities.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersonaDAO {
    private final EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Persona persona) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(persona);
        transaction.commit();
        System.out.println("nuova persona salvata");
    }

    public Persona getById(long id) {
        return em.find(Persona.class, id);
    }

    public void delete(Persona persona) {
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        em.remove(persona);
        transaction.commit();
        System.out.println("persona cancellata");
    }

    public Persona refresh(Persona persona) {
        em.refresh(persona);
        return persona;
    }
}
