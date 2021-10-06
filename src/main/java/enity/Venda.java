package enity;

import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private LocalDate data;
    private BigDecimal valorTotal;
    private String formaPagamento;

    public Venda(Long id, LocalDate data, BigDecimal valorTotal, String formaPagamento) {
        this.id = id;
        this.data = data;
        this.valorTotal = valorTotal;
        this.formaPagamento = formaPagamento;
    }

    public Venda() {
    }

    public Venda(LocalDate data, BigDecimal valorTotal, String formaPagamento) {
        this.data = data;
        this.valorTotal = valorTotal;
        this.formaPagamento = formaPagamento;
    }
}
