import dao.AnuncioPersistence;
import dao.VendedorPersistence;
import entity.Anuncio;
import entity.Vendedor;
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
        anuncioServices.insere(new Anuncio("Bola", new BigDecimal(50), LocalDate.now(),"520", vendedor));
    }
}
