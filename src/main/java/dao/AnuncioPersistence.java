package dao;

import enity.Anuncio;
import enity.Venda;
import enity.Vendedor;
import util.BancoDeDados;
import util.JPAUtil;

import javax.persistence.EntityManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


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
