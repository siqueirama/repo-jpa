package services;

import dao.AnuncioPersistence;
import dao.VendaPersistence;
import dao.VendedorPersistence;
import enity.Anuncio;
import enity.Vendedor;

import java.util.concurrent.ThreadLocalRandom;

public class AnuncioServices {

     AnuncioPersistence anuncioPersistence;
     VendedorServices vendedorServices;

    public AnuncioServices() {
    }

    public AnuncioServices(VendedorServices vendedorServices, AnuncioPersistence anuncioPersistence) {
    this.vendedorServices = vendedorServices;
    this.anuncioPersistence = anuncioPersistence;
    }

    private String codigoUnico() {
        return "MLB" + ThreadLocalRandom.current().nextInt(100, 999);
    }

    public void insere(Anuncio anuncio){
      Vendedor vendedor = vendedorServices.obtem(anuncio.getVendedorCodigo());
        if(vendedor == null){
            throw new RuntimeException("Anuncio precisa ter um vendedor cadastrado");
        }else{
            anuncio.setCodigo(codigoUnico());
            anuncioPersistence.insere(anuncio);
        }
    }
}
