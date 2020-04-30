/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repo;

import entity.Albums;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import util.PersistenceUtil;



public class AlbumRepository {
    public void create(Albums album) {
        EntityManagerFactory emf = PersistenceUtil.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(album);
        em.getTransaction().commit();

    }

    public Albums findById(int Id)
    {
        EntityManagerFactory emf = PersistenceUtil.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Albums album = (Albums) em.createNamedQuery("Albums.findById")
                .setParameter(Id, "album")
                .getSingleResult();

        em.getTransaction().commit();
        PersistenceUtil.closeEntityManagerFactory();




        return album;
    }

    public Albums findByName(String name){
        EntityManagerFactory emf = PersistenceUtil.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Albums album = (Albums) em.createNamedQuery("Albums.findByName")
                        .setParameter(name, "album")
                        .getSingleResult();

        em.getTransaction().commit();

        PersistenceUtil.closeEntityManagerFactory();


        return album;
    }

    public List<Albums> findByArtist(int artistId){
        EntityManagerFactory emf = PersistenceUtil.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();

        List<Albums> listaAlbum = em.createNamedQuery("Albums.findByArtist")
                .setParameter("artistId", artistId)
                .getResultList();

        em.close();
        emf.close();
        PersistenceUtil.closeEntityManagerFactory();

        return listaAlbum;
    }

}
