public class ListaProdutos {

    private Produto[] produtos;
    private int controle;

    public ListaProdutos() {
        this.produtos = new Produto[1];
        this.controle = 0;
    }

    public boolean novoProduto(String nome, double preco, int estoque) {
        if (preco > 0) {
            if (estoque > 0) {
                if (controle == 0) {
                    this.produtos[0] = new Produto((controle + 1), nome, preco, estoque);
                    this.controle++;
                } else {
                    Produto aux = new Produto((controle + 1), nome, preco, estoque);
                    adicionaProduto(aux);
                }
                return true;
            }
        }
        return false;
    }

    private void adicionaProduto(Produto novo) {
        Produto[] novoProduto = new Produto[(controle + 1)];
        for (int i = 0; i < controle; i++) {
            novoProduto[i] = this.produtos[i];
        }
        novoProduto[controle] = novo;
        this.produtos = novoProduto;
        this.controle++;
    }
    
    public void mostraProdutos() {
        if (exist()) {
            for (Produto aux : produtos) {
                System.out.println(aux.mostra());
            }
        } else {
            System.out.println("Nao ha produtos cadastrados");
        }
    }

    public boolean exist() {
        if (produtos[0] != null)
            return true;
        else 
            return false;
    }

    public Produto getProdutoByCodigo(int cod) {
        for (Produto aux : produtos) {
            if (aux.getCodigo() == cod) {
                return aux;
            }
        }
        return null;
    }
}