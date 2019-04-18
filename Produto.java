import java.text.DecimalFormat;

public class Produto {

    private DecimalFormat df = new DecimalFormat("0.00");
    
    private int codigoProduto;
    private String nomeProduto;
    private double precoProduto;
    private int qtdEstoque;

    public Produto (int codigoProduto, String nomeProduto, double precoProduto, int qtdEstoque) {
        this.codigoProduto = codigoProduto;
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.qtdEstoque = qtdEstoque;
    }

    public int getCodigo() {
        return this.codigoProduto;
    }

    public boolean adicionaEstoque(int qtd) {
        if (qtd > 0) {
            this.qtdEstoque += qtd;
            return true;
        } else {
            System.out.println("Quantidade invalida, operacao cancelada");
            return false;
        }
    }

    public int removeEstoque(int qtd) {
        if (qtd <= 0) {
            System.out.println("Quantidade invalida, operacao cancelada");
            return 2;
        } else if (qtd > qtdEstoque) {
            System.out.println("Quantidade maior do que a disponivel em estoque!");
            return 1;
        } else {
            return  0;
        }
    }

    public boolean alteraPreco(double novoPreco) {
        if (novoPreco < 0) {
            System.out.println("Preco invalido, operacao cancelada");
            return false;
        } else {
            return true;
        }
    }

    public String mostra() {
        return "\nCod:\t\t" + this.codigoProduto + "\nNome:\t\t" + this.nomeProduto + "\nPreco:\t\tR$ " + df.format(this.precoProduto) + "\nEstoque:\t" + qtdEstoque;
    }
}