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
                    Produto aux = new Produto((produtos[controle - 1].getCodigo() + 1), nome, preco, estoque);
                    adicionaProduto(aux);
                    this.controle++;
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
    }

    private int buscaProduto(int codProduto) {
        // if ()
        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i].getCodigo() == codProduto) {
                return i;
            }
        }
        return -1;
    }

    public void apagaProduto(int codProduto) {
        int posicaoProduto = buscaProduto(codProduto);
        if (controle == 0) {
            System.out.println("\nNao ha produtos cadastrados");
        } else if (posicaoProduto != -1) {
            controle--;
            Produto[] removeProduto = new Produto[controle];
            for (int i = 0, j = 0; i < produtos.length; i++) {
                if (i == posicaoProduto) {
                    continue;
                } else {
                    removeProduto[j] = produtos[i];
                    j++;
                }
            }
            this.produtos = removeProduto;
            System.out.println("\nProduto removido");
        } else  {
            System.out.println("\nProduto nao encontrado no pedido");
        }
    }
    
    public void mostraProdutos() {
        if (exist()) {
            for (Produto aux : produtos) {
                System.out.println(aux.toString());
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

    public int verificaEstoque(int codProduto, int qtd) {
        for (Produto aux : produtos) {
            if (aux.getCodigo() == codProduto) {
                if (aux.getQtdEstoque() >= qtd) {
                    return 0;
                } else {
                    return 1;
                }
            }
        }
        return 2;
    }

    public Produto getProdutoByCodigo(int cod) {
        for (Produto aux : produtos) {
            if (aux.getCodigo() == cod) {
                return aux;
            }
        }
        return null;
    }

    public void abaterEstoque(int codProduto, int qtdProduto) {
        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i].getCodigo() == codProduto)
                produtos[i].removeEstoque(qtdProduto);
        }
    }
}