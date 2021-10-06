import dao.VendaPersistence;
import enity.Venda;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MainVenda {

    public static void main(String[] args) {
        VendaPersistence vendaPersistence = new VendaPersistence();
        vendaPersistence.insere(new Venda(LocalDate.now(), new BigDecimal(1000), "A VISTA"));
    }
}
