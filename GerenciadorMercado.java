import java.text.DecimalFormat;

public class GerenciadorMercado {

    private DecimalFormat df = new DecimalFormat("0.00");
    private ListaProdutos listaProdutos;
    private Pedido pedido;
    private Pedido[] pedidosFinalizados;
    private int controle;

    public GerenciadorMercado() {
        this.listaProdutos = new ListaProdutos();
        this.pedidosFinalizados = new Pedido[1];
        this.controle = 0;
    }

    public void novoPedido() {
        this.pedido = new Pedido();
    }

    public void adicionaProduto(String nome, double valor, int estoque) {
        this.listaProdutos.novoProduto(nome, valor, estoque);  
    }

    public void adicionaItemPedido(int codProduto, int qtd) {
        int aux  = listaProdutos.verificaEstoque(codProduto, qtd);
        if (aux == 0) {
            pedido.novoItem(codProduto, qtd);
            System.out.println("\nItem adicionado ao pedido");
        } else if (aux == 1) {
            System.out.println("\nQuantidade nao disponivel em estoque.\nItem nao adicionado.");
        } else {
            System.out.println("\nCodigo de item nao encontrado.\nItem nao adicionado.");
        }
    }

    public void removeItemPedido(int cod) {
        pedido.removeItem(cod);
    }
        
    public void apagaProduto(int codProduto) {
        listaProdutos.apagaProduto(codProduto);
    }

    public void cancelarPedido() {
        this.pedido = null;
        System.out.println("\nPedido Cancelado");
    }

    public void produtosCadastrados() {
        listaProdutos.mostraProdutos();
    }

    public void mostraPedido() {
        for (Item aux : pedido.getItens()) {
            if (aux != null) {
                System.out.println(listaProdutos.getProdutoByCodigo(aux.getCodProduto()).mostra());
                System.out.println("Quantidade:\t"+ aux.getQtdProduto());
            }
        }
        System.out.println("\nTotal:\tR$"+ df.format(calculaPedido(pedido.getItens())));
    }

    public void mostraProdutos() {
        listaProdutos.mostraProdutos();
    }
        
    public void finalizarPedido(int formaPagamento) {
        if (pedido == null || pedido.isNull()) {
            System.out.println("Nao ha itens no pedido");
        } else if (pedido.formaPagamento(formaPagamento)) {
            double valor = calculaPedido(pedido.getItens());
            pedido.setValorPedido(valor);
            mostraPedido();
            pedido.mostraPagamento();
            guardaPedido(pedido);
            abaterEstoque();
            pedido = null;
            System.out.println("\nPedido Concluido");
        }
    }    

    private double calculaPedido(Item[] itens) {
        double valorTotal = 0;
        for (Item aux : itens) {
            Produto p = listaProdutos.getProdutoByCodigo(aux.getCodProduto());
            valorTotal += p.getPrecoProduto() * aux.getQtdProduto();
        }
        return valorTotal;
    }

    private void abaterEstoque () {
        for (Item aux : pedido.getItens()) {
            this.listaProdutos.abaterEstoque(aux.getCodProduto(), aux.getQtdProduto());
        }
    }

    private void guardaPedido(Pedido p) {
        if (controle == 0) {
            this.pedidosFinalizados[controle] = p;
            controle++;
        } else {            
            Pedido[] aux = new Pedido[(controle + 1)];
            for (int i = 0; i < controle; i++) {
                aux[i] = this.pedidosFinalizados[i];
            }
            aux[controle] = p;
            this.pedidosFinalizados = aux;
            this.controle++;
        }
    }

}