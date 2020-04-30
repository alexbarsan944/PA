/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author School
 */
public class PersistenceUtil {
    protected static EntityManagerFactory emf;

    private PersistenceUtil() {
    }

    /*
     *creating and returning an EntityManagerFactory
     */
    public static EntityManagerFactory createEntityManagerFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("MusicAlbumsPU");
        }
        System.out.println("Entity Manager Factory created");
        return emf;
    }

    public static void closeEntityManagerFactory() {
        if (emf != null) {
            emf.close();
            emf = null;
            System.out.println("Entity Manager Factory closed");
        }
    }
}
