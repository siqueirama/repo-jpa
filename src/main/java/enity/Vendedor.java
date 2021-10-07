package enity;


import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@Table(name = "vendedores")
public class Vendedor {

    @Id
    private String codigo;
    private String cpf;
    private String nome;

    @OneToMany(mappedBy = "vendedor", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Endereco> endereco;

    public Vendedor() {
    }

    public Vendedor(String codigo, String cpf, String nome, List<Endereco> endereco) {
        super();
        this.codigo = codigo;
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
    }

    public Vendedor(String codigo, String cpf, String nome) {
        this.codigo = codigo;
        this.cpf = cpf;
        this.nome = nome;
    }

    public Vendedor(String cpf, String nome, List<Endereco> endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
    }

    public Vendedor(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

}