package dao;

import enity.Vendedor;
import util.BancoDeDados;
import util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class VendedorPersistence {

    private Connection cnx;
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
            em.persist(vendedor);
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