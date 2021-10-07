package services;

import dao.VendaPersistence;
import dao.VendedorPersistence;
import enity.Venda;
import enity.Vendedor;

public class VendaServices {

    VendaPersistence vendaPersistence;

    public VendaServices(VendaPersistence vendaPersistence) {
        this.vendaPersistence = vendaPersistence;
    }

    public VendaServices() {

    }

    public void insere(Venda venda) {
      Venda vendaExiste =  vendaPersistence.buscaVenda(venda.getAnuncio().getCodigo(), venda.getVendedor().getCodigo());
        if(vendaExiste == null){
            vendaPersistence.insere(venda);
        }else{
            throw new RuntimeException("Venda já Cadastrado!");
        }

    }
}
