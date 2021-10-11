package dao;

import entity.Vendedor;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.Connection;
import java.util.List;


public class VendedorPersistence {

    private EntityManager em;

    public VendedorPersistence(){
        em = JPAUtil.getEntityManager();
    }


    public void atualiza(Vendedor vendedor) {
        em.getTransaction().begin();
        vendedor.setCpf(vendedor.getCpf());
        vendedor.setNome(vendedor.getNome());
        em.getTransaction().commit();
    }

    public List<Vendedor> lista(){
        TypedQuery<Vendedor> qry = em.createQuery("From Vendedor", Vendedor.class);
        return qry.getResultList();
    }


    public Vendedor get(String codigo) {
        return em.find(Vendedor.class, codigo);
    }

    public void insere(Vendedor vendedor) {
        try {
            em.getTransaction().begin();
         //   em.persist(vendedor);
            em.merge(vendedor);
            em.getTransaction().commit();
        } catch (RuntimeException e) {
            em.getTransaction().rollback();
        }
    }

    public void exclui(String codigo) {
        try {
            em.getTransaction().begin();
            Vendedor vendedorDeletado = em.find(Vendedor.class, codigo);
            em.remove(vendedorDeletado);
            em.getTransaction().commit();
        }catch (RuntimeException e){
            em.getTransaction().rollback();
        }


    }
}