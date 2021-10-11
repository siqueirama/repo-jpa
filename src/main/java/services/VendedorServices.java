package services;

import dao.VendedorPersistence;
import entity.Endereco;
import entity.Vendedor;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class VendedorServices {


    private VendedorPersistence vendedorPersistence;
    private List<Endereco> endereco;


    public VendedorServices(VendedorPersistence vendedorPersistence) {
        this.vendedorPersistence = vendedorPersistence;
    }

    public VendedorServices(VendedorPersistence vendedorPersistence, List<Endereco> endereco) {
        this.vendedorPersistence = vendedorPersistence;
        this.endereco = endereco;
    }


    private String codigoUnico() {
        return "MLB" + ThreadLocalRandom.current().nextInt(100, 999);
    }

    public void insere(Vendedor vendedor) {
        if(vendedor.getCodigo()==null || vendedor.getCodigo().isEmpty()) {
            vendedor.setCodigo(codigoUnico());
            vendedorPersistence.insere(vendedor);
        }else{
            Vendedor vendedorExistente = vendedorPersistence.get(vendedor.getCodigo());
                if(vendedorExistente == null){
                    vendedorPersistence.insere(vendedor);
                }else{
                throw new RuntimeException("Vendedor já Cadastrado!");
             }
        }
    }


    public List<Vendedor> listagem(){
        List<Vendedor> lista = vendedorPersistence.lista();
        lista.sort((Vendedor v1, Vendedor v2) -> v1.getNome().compareToIgnoreCase(v2.getNome()));
        return lista;
    }

    public Vendedor obtem(String codigo) {
        return vendedorPersistence.get(codigo);
    }


    public void deleta(String codigo) {
        vendedorPersistence.exclui(codigo);
    }
}
