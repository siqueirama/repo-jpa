package services;

import dao.AnuncioPersistence;
import entity.Anuncio;

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

        if(anuncio.getVendedor() == null){
            throw new RuntimeException("Anuncio precisa de um Vendedor cadastrado");
        }else{
            anuncio.setCodigo(codigoUnico());
            anuncioPersistence.insere(anuncio);
        }
    }
}
