public class Item {
    
    private int codProduto;
    private int qtdProduto;

    public Item(int codProduto, int qtdProduto) {
        this.codProduto = codProduto;
        this.qtdProduto = qtdProduto;
    }

    public int getCodProduto() {
        return this.codProduto;
    }

    public int getQtdProduto() {
        return this.qtdProduto;
    }

}