import dao.VendedorPersistence;
import entity.Endereco;
import entity.Vendedor;
import services.VendedorServices;

import java.util.Arrays;
import java.util.List;

public class MainVendedor {


    public static void main(String[] args) {
        insercao();
        //atualizacao();
        //listagem();
        //exclusao();
    }

    private static void exclusao() {
        VendedorPersistence vendedorPersistence = new VendedorPersistence(); //like a mock :)
        VendedorServices service = new VendedorServices(vendedorPersistence);
        String codigo = "MLB184";
        service.deleta(codigo);
    }

    private static void listagem() {
        VendedorPersistence vendedorPersistence = new VendedorPersistence(); //like a mock :)
        VendedorServices service = new VendedorServices(vendedorPersistence);
        service.listagem().forEach(v -> System.out.println(v));
    }

    private static void atualizacao() {
        VendedorPersistence vendedorPersistence = new VendedorPersistence();
 //       VendedorServices service = new VendedorServices(vendedorPersistence);
        Vendedor vendedor = new Vendedor("MLB320", "000.654.123-90", "ana Ferreira");
        vendedorPersistence.atualiza(vendedor);
    }

    private static void insercao() {
        VendedorPersistence vendedorPersistence = new VendedorPersistence();
        Vendedor vendedor = new Vendedor("000.654.123-90", "Cafu");
        //não gera o ID do endereço automaticoo
        List<Endereco> endereco = Arrays.asList(new Endereco(2l,"01118-888", "logradouro do wagner", "ap 3", 4005, "ES", "Vitória", vendedor));

        VendedorServices vendedorServices = new VendedorServices(vendedorPersistence, endereco);

        vendedor.setEndereco(endereco);
        vendedorServices.insere(vendedor);
    }
}
