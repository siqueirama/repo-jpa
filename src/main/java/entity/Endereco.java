package entity;

import lombok.Data;


import javax.persistence.*;


@Data
@Entity
@Table(name = "Endereco")
public class Endereco {

    @Id
  //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vendedor_codigo")
    private Vendedor vendedor;

    private String cep;
    private String logradouro;
    private String complemento;
    private int numero;
    private String uf;
    private String cidade;

    public Endereco() {
    }

        public Endereco(Long id, String cep, String logradouro, String complemento, int numero, String uf, String cidade, Vendedor vendedor) {
            super();
            this.id = id;
            this.cep = cep;
            this.logradouro = logradouro;
            this.complemento = complemento;
            this.numero = numero;
            this.uf = uf;
            this.cidade = cidade;
            this.vendedor = vendedor;
        }


        public Endereco(String cep, String logradouro, String complemento, int numero, String uf, String cidade, Vendedor vendedor) {
            super();
            this.cep = cep;
            this.logradouro = logradouro;
            this.complemento = complemento;
            this.numero = numero;
            this.uf = uf;
            this.cidade = cidade;
            this.vendedor = vendedor;
        }

        public Endereco(Long id, String cep, String logradouro, String complemento, int numero, String uf, String cidade) {
            super();
            this.id = id;
            this.cep = cep;
            this.logradouro = logradouro;
            this.complemento = complemento;
            this.numero = numero;
            this.uf = uf;
            this.cidade = cidade;
            this.vendedor = vendedor;
        }

        public Endereco(String cep, String logradouro, String complemento, int numero, String uf, String cidade) {
            super();
            this.cep = cep;
            this.logradouro = logradouro;
            this.complemento = complemento;
            this.numero = numero;
            this.uf = uf;
            this.cidade = cidade;
            this.vendedor = vendedor;
        }

}

