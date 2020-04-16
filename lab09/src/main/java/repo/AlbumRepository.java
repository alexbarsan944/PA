package repo;

import entity.Album;
import util.PersistenceUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class AlbumRepository {
    public void create(Album album) {
        EntityManagerFactory emf = PersistenceUtil.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(album);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    public Album findById(int Id)
    {
        EntityManagerFactory emf = PersistenceUtil.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Album album = (Album) em.createNamedQuery("Album.findById")
                .setParameter(Id, "album")
                .getSingleResult();

        em.getTransaction().commit();
        em.close();
        emf.close();

        return album;
    }

    public Album findByName(String name){
        EntityManagerFactory emf = PersistenceUtil.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Album album = (Album) em.createNamedQuery("Album.findByName")
                        .setParameter(name, "album")
                        .getSingleResult();

        em.getTransaction().commit();
        em.close();
        emf.close();

        return album;
    }

    public List<Album> findByArtist(int artistId){
        EntityManagerFactory emf = PersistenceUtil.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        List<Album> listaAlbum = em.createNamedQuery("Album.findByArtist")
                .setParameter("artistId", artistId)
                .getResultList();
        PersistenceUtil.closeEntityManagerFactory();
        return listaAlbum;
    }

}
