import dao.AnuncioPersistence;
import dao.VendaPersistence;
import dao.VendedorPersistence;
import enity.Anuncio;
import enity.Vendedor;
import services.AnuncioServices;
import services.VendedorServices;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MainAnuncio {
    public static void main(String[] args) {
        VendedorPersistence vendedorPersistence = new VendedorPersistence();
        VendedorServices vendedorServices = new VendedorServices(vendedorPersistence);

        AnuncioPersistence anuncioPersistence = new AnuncioPersistence();
        AnuncioServices anuncioServices = new AnuncioServices(vendedorServices, anuncioPersistence);

        Vendedor vendedor = vendedorPersistence.get("MLB325");
        anuncioServices.insere(new Anuncio("Bola", new BigDecimal(800), LocalDate.now(),"10", vendedor));
    }
}
