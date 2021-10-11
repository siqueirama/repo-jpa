package dao;

import entity.Anuncio;
import util.JPAUtil;

import javax.persistence.EntityManager;


public class AnuncioPersistence {

    private EntityManager em;

    public AnuncioPersistence() {
        em = JPAUtil.getEntityManager();
    }

    public void insere(Anuncio anuncio) {
        try {
            em.getTransaction().begin();
            em.persist(anuncio);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
        }
    }

    public Anuncio getAnuncio(String codAnuncio) {
        return em.find(Anuncio.class, codAnuncio);
    }
}
