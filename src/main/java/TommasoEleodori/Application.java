package TommasoEleodori;

import javax.persistence.EntityManager;

import static TommasoEleodori.utils.JpaUtil.emf;

public class Application {

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
    }
}
