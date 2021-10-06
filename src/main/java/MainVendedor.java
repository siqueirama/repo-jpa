import dao.VendedorPersistence;
import enity.Vendedor;
import services.VendedorServices;

public class MainVendedor {


    public static void main(String[] args) {
        //insercao();
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
        VendedorPersistence vendedorPersistence = new VendedorPersistence(); //like a mock :)
        VendedorServices service = new VendedorServices(vendedorPersistence);
        Vendedor vendedor = new Vendedor("MLB320", "000.654.123-90", "ana Ferreira", "rua ZZZ", "MG", "ouro fino");
        service.salva(vendedor);
    }

    private static void insercao() {
        VendedorPersistence vendedorPersistence = new VendedorPersistence(); //like a mock :)
        VendedorServices service = new VendedorServices(vendedorPersistence);
        Vendedor vendedor = new Vendedor("741.852.963-25", "Edenilson", "rua qazw", "SP", "São Paulo");
        service.salva(vendedor);
    }
}
