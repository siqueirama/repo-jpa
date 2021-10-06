import dao.AnuncioPersistence;
import dao.VendaPersistence;
import dao.VendedorPersistence;
import enity.Anuncio;
import enity.Vendedor;
import services.AnuncioServices;
import services.VendedorServices;

import java.math.BigDecimal;

public class MainAnuncio {
    public static void main(String[] args) {
        VendedorPersistence vendedorPersistence = new VendedorPersistence();
        VendedorServices vendedorServices = new VendedorServices(vendedorPersistence);
        AnuncioPersistence anuncioPersistence = new AnuncioPersistence();
        AnuncioServices anuncioServices = new AnuncioServices(vendedorServices, anuncioPersistence);
        anuncioServices.insere(new Anuncio("Livro", "MLB365", new BigDecimal(1000), "2021-05-06","10"));
    }
}
