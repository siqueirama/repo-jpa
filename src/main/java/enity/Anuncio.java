package enity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@Entity
@Table(name = "anuncios")
public class Anuncio {

    @Id
 //   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String codigo;

    private String titulo;
    private BigDecimal preco;
    private LocalDate dataAnuncio;
    private String numVendas;

    @ManyToOne
    private Vendedor vendedor;

    public Anuncio() {
    }

    public Anuncio(String titulo, BigDecimal preco, LocalDate dataAnuncio, String numVendas, Vendedor vendedor) {
        this.titulo = titulo;
        this.preco = preco;
        this.dataAnuncio = dataAnuncio;
        this.numVendas = numVendas;
        this.vendedor = vendedor;
    }

}
