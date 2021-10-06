package services;

import dao.VendedorPersistence;
import enity.Vendedor;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class VendedorServices {


    private VendedorPersistence vendedorPersistence;

    public VendedorServices(VendedorPersistence vendedorPersistence) {
        this.vendedorPersistence = vendedorPersistence;
    }

    public VendedorServices() {
    }


    private String codigoUnico() {
        return "MLB" + ThreadLocalRandom.current().nextInt(100, 999);
    }

    public void salva(Vendedor vendedor) {
        if(vendedor.getCodigo()==null || vendedor.getCodigo().isEmpty()) {
            vendedor.setCodigo(codigoUnico());
            vendedorPersistence.insere(vendedor);
        }else{
            Vendedor vendedorExistente = vendedorPersistence.get(vendedor.getCodigo());
            if(vendedorExistente == null){
                throw new RuntimeException("Algo de muito errado aconteceu");
            }
            vendedorExistente.setCidade(vendedor.getCidade());
            vendedorExistente.setCpf(vendedor.getCpf());
            vendedorExistente.setEndereco(vendedor.getEndereco());
            vendedorExistente.setNome(vendedor.getNome());
            vendedorExistente.setUf(vendedor.getUf());
            vendedorPersistence.atualiza(vendedorExistente);
        }
    }

    /**
     *
     * @return uma lista de vendedores ordenada (em ordem crescente) pelo nome
     */
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
