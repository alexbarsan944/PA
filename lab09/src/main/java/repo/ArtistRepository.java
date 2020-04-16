package repo;

import entity.Artist;
import util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ArtistRepository {
    public void create(Artist artist) {
        EntityManagerFactory emf = PersistenceUtil.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(artist);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public Artist findById(int Id)
    {
        EntityManagerFactory emf = PersistenceUtil.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Artist artist = em.find(Artist.class, Id);



        return artist;
    }

    public Artist findByName(String name){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MusicAlbumsPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Artist Artist = (entity.Artist) em.createNamedQuery("artist.findByName")
                .setParameter(name, "artist")
                .getSingleResult();

        em.getTransaction().commit();
        em.close();
        emf.close();

        return Artist;
    }


    
}
