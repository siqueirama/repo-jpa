package entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
public class Venda {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private LocalDate data;
        private BigDecimal valorTotal;
        @Enumerated(EnumType.STRING)
        private FormaPagamento formaPagamento;

        @ManyToOne
        private Vendedor vendedor;

        @ManyToOne
        @JoinColumn(name = "anuncio_codigo")
        private Anuncio anuncio;


        public Venda() {
        }

        public Venda(Long id, LocalDate data, BigDecimal valorTotal, FormaPagamento formaPagamento, Vendedor vendedor, Anuncio anuncio) {
            super();
            this.id = id;
            this.data = data;
            this.valorTotal = valorTotal;
            this.formaPagamento = formaPagamento;
            this.vendedor = vendedor;
            this.anuncio = anuncio;
        }
        public Venda(LocalDate data, BigDecimal valorTotal, FormaPagamento formaPagamento, Vendedor vendedor, Anuncio anuncio) {
            super();
            this.data = data;
            this.valorTotal = valorTotal;
            this.formaPagamento = formaPagamento;
            this.vendedor = vendedor;
            this.anuncio = anuncio;
        }

    }
