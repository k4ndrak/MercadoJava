//import java.util.Scanner;

public class TestaPedido {

    public static void main(String[] args) {

//        Scanner input = new Scanner(System.in);

        ListaProdutos listaProdutos = new ListaProdutos();
        Pedido[] pedidos = new Pedido[1];

        System.out.println(listaProdutos.novoProduto("Arroz", 3.50, 10) ? "Produto cadastrado" : "Falha ao cadastrar produto");
        System.out.println(listaProdutos.novoProduto("Feijao", 1, -2) ? "Produto cadastrado" : "Falha ao cadastrar produto");
        System.out.println(listaProdutos.novoProduto("Macarrao", 2.30, 8) ? "Produto cadastrado" : "Falha ao cadastrar produto");

        
        listaProdutos.mostraProdutos();

        

    }

}