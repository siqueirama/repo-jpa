package enity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String cep;
    private String logra;
    private String coomplemento;
    private int numero;
    private String uf;
    private String cidade;

    public Endereco() {
    }

    public Endereco(Long id, String cep, String logra, String coomplemento, int numero, String uf, String cidade) {
        Id = id;
        this.cep = cep;
        this.logra = logra;
        this.coomplemento = coomplemento;
        this.numero = numero;
        this.uf = uf;
        this.cidade = cidade;
    }
}
