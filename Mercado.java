//import java.util.Scanner;

public class Mercado {

    public static void main(String[] args) {

//        Scanner input = new Scanner(System.in);
        GerenciadorMercado gerenciador = new GerenciadorMercado();

        gerenciador.adicionaProduto("Arroz", 3.50, 10);
        gerenciador.adicionaProduto("Feijao", 1, 2);
        gerenciador.adicionaProduto("Macarrao", 2.30, 8);
        gerenciador.produtosCadastrados();


        gerenciador.novoPedido();
        gerenciador.adicionaItemPedido(1, 4);
        gerenciador.adicionaItemPedido(2, 1);
        gerenciador.adicionaItemPedido(3, 5);
        // gerenciador.mostraPedido();
        // gerenciador.removeItemPedido(3);
        // gerenciador.removeItemPedido(2);
        // gerenciador.removeItemPedido(2);
        // gerenciador.removeItemPedido(1);
        // gerenciador.removeItemPedido(2);
        // gerenciador.mostraPedido();
        gerenciador.finalizarPedido(1);
        gerenciador.produtosCadastrados();

        
        gerenciador.apagaProduto(2);
        gerenciador.produtosCadastrados();

    }

}