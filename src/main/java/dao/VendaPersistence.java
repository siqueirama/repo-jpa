package dao;

import entity.Venda;
import util.JPAUtil;

import javax.persistence.*;

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
        TypedQuery<Venda> qry = em.createQuery("SELECT * FROM Venda  WHERE vendedor.codigo =: codigo1  AND anuncio.codigo =:codigo2",Venda.class);
        qry.setParameter(1, codigoVen);
        qry.setParameter(2, codigoAnun);
        Venda venda = qry.getSingleResult();
        return venda;
    }
}
