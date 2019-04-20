public class Pedido {

    private Item[] itensPedido;
    private String formaPagamento;
    private double valorPedido;
    private int controle;

    public Pedido() {
        this.itensPedido = new Item[1];
        controle = 0;
    }

    public boolean isNull() {
        if (controle == 0)
            return true;
        else
            return false;
    }

    public void novoItem(int codProduto, int qtdProduto) {
        if (controle == 0) {
            this.itensPedido[controle] = new Item(codProduto, qtdProduto);
            controle++;
        } else {
            Item item = new Item(codProduto, qtdProduto);
            adicionaItem(item);
            this.controle++;
        }
    }

    private void adicionaItem(Item novo) {
        Item[] novoItem = new Item[(controle + 1)];
        for (int i = 0; i < controle; i++) {
            novoItem[i] = this.itensPedido[i];
        }
        novoItem[controle] = novo;
        this.itensPedido = novoItem;
    }

    public Item[] getItens() {
        return this.itensPedido;
    }

    private int buscaItem(int codProduto) {
        // if ()
        for (int i = 0; i < itensPedido.length; i++) {
            if (itensPedido[i].getCodProduto() == codProduto) {
                return i;
            }
        }
        return -1;
    }

    public void removeItem(int codProduto) {
        int posicaoItem = buscaItem(codProduto);
        if (controle == 0) {
            System.out.println("\nNao ha itens no pedido");
        } else if (posicaoItem != -1) {
            controle--;
            Item[] removeItem = new Item[controle];
            for (int i = 0, j = 0; i < itensPedido.length; i++) {
                if (i == posicaoItem) {
                    continue;
                } else {
                    removeItem[j] = itensPedido[i];
                    j++;
                }
            }
            this.itensPedido = removeItem;
            System.out.println("\nItem removido");
        } else  {
            System.out.println("\nProduto nao encontrado no pedido");
        }
    }

    public boolean formaPagamento(int pagamento) {
        switch (pagamento) {
            case 1:
                this.formaPagamento = "Dinheiro";
                return true;
            case 2:
                this.formaPagamento = "Cartao";
                return true;
            case 3:
                this.formaPagamento = "Cheque";
                return true;
            default: 
                System.out.println("Forma de pagamento invalida, operacao cancelada");
                return false;
        }
    }

    public void setValorPedido(double valorPedido) {
        this.valorPedido = valorPedido;
    }

    public void mostraPagamento() {
        System.out.println("Pagamento em "+ this.formaPagamento);
    }

}