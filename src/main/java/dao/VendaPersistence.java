package dao;

import enity.Venda;
import util.JPAUtil;

import javax.persistence.*;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class VendaPersistence {

    private EntityManager em;

    public VendaPersistence() {
        em = JPAUtil.getEntityManager();
    }

    public void insere(Venda venda) {
        try {
            em.getTransaction().begin();
            em.persist(venda);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
        }
    }

}
