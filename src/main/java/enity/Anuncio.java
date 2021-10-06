package enity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
public class Anuncio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String codigo;
    
    private String titulo;
    private String vendedorCodigo;
    private BigDecimal preco;
    private String dataAnuncio;
    private String numVendas;

    public Anuncio(String codigo, String titulo, String vendedorCodigo, BigDecimal preco, String dataAnuncio, String numVendas) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.vendedorCodigo = vendedorCodigo;
        this.preco = preco;
        this.dataAnuncio = dataAnuncio;
        this.numVendas = numVendas;
    }

    public Anuncio(String titulo, String vendedorCodigo, BigDecimal preco, String dataAnuncio, String numVendas) {
        this.titulo = titulo;
        this.vendedorCodigo = vendedorCodigo;
        this.preco = preco;
        this.dataAnuncio = dataAnuncio;
        this.numVendas = numVendas;
    }

    public Anuncio() {
    }
}
