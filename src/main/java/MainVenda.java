import dao.AnuncioPersistence;
import dao.VendaPersistence;
import dao.VendedorPersistence;
import enity.Anuncio;
import enity.FormaPagamento;
import enity.Venda;
import enity.Vendedor;
import services.VendaServices;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MainVenda {

    public static void main(String[] args) {
        VendedorPersistence vendedorPersistence = new VendedorPersistence();
        AnuncioPersistence anuncioPersistence = new AnuncioPersistence();
        VendaPersistence vendaPersistence =new VendaPersistence();

        Vendedor vendedor = vendedorPersistence.get("MLB365");
        Anuncio anuncio = anuncioPersistence.getAnuncio("MLB641");

        VendaServices vendaServices = new VendaServices(vendaPersistence);
        vendaPersistence.insere(new Venda(LocalDate.now(), new BigDecimal(1200), FormaPagamento.A_PRAZO, vendedor, anuncio));
     //   vendaServices.insere(new Venda(LocalDate.now(), new BigDecimal(1200), FormaPagamento.A_PRAZO, vendedor, anuncio));


    }
}
