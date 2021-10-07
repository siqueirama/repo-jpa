package dao;

import enity.FormaPagamento;
import enity.Venda;
import enity.Vendedor;
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

    public Venda get(Long id) {
        return em.find(Venda.class, id);
    }

   // public List<Venda> lista() {
   //     TypedQuery<Venda> qry = em.createQuery("from Venda", Venda.class);
   //     return qry.getResultList();
   // }

    public void atualiza(Venda venda) {
        em.getTransaction().begin();
        Venda vendaParaSerAtualizada = em.find(Venda.class, venda.getId());
        vendaParaSerAtualizada.setFormaPagamento(venda.getFormaPagamento());
        em.getTransaction().commit();
    }

    public void deleta(Long id) {
        em.getTransaction().begin();
        Venda v = em.find(Venda.class, id); //garantindo que o objeto v esteja no estado managed
        em.remove(v);
        em.getTransaction().commit();
    }

    public Venda buscaVenda(String codigoVen, String codigoAnun) {
        TypedQuery<Venda> qry = em.createQuery("SELECT * FROM Venda v WHERE v.vendedor.codigo =: codigo1  AND v.anuncio_codigo =codigo2",Venda.class);
        qry.setParameter(1, codigoVen);
        qry.setParameter(2, codigoAnun);
        Venda venda = qry.getSingleResult();
        return venda;
    }
}
