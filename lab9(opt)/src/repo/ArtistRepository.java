/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repo;

import entity.Artists;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import util.PersistenceUtil;

public class ArtistRepository {
    public void create(Artists artist) {
        EntityManagerFactory emf = PersistenceUtil.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(artist);
        em.getTransaction().commit();

    }

    public Artists findById(int Id) {
        EntityManagerFactory emf = PersistenceUtil.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Artists artist = em.find(Artists.class, Id);
            em.flush();
            em.close();
            PersistenceUtil.closeEntityManagerFactory();
            return artist;
        } catch (Exception e) {
            em.flush();
            em.close();
            PersistenceUtil.closeEntityManagerFactory();
        }
        return null;
    }

    public Artists findByName(String name){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MusicAlbumsPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Artists Artist = (entity.Artists) em.createNamedQuery("Artists.findByName")
                .setParameter(name, "artist")
                .getSingleResult();

        em.getTransaction().commit();
        em.close();
        emf.close();

        return Artist;
    }
}
