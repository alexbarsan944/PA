package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {

    protected static EntityManagerFactory emf;

    private PersistenceUtil() {
    }

    public static EntityManagerFactory createEntityManagerFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("MusicAlbumsPU");
        }
        System.out.println("Entity Manager Factory created");
        return emf;
    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    public static void closeEntityManagerFactory() {
        if (emf != null) {
            emf.close();
            emf = null;
            System.out.println("Entity Manager Factory closed");
        }
    }
}



