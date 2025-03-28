class ItemVenda {
    private Produto produto;
    private int quantidade;

    public ItemVenda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public double getSubtotal() {
        return produto.getPreco() * quantidade;
    }

    public Produto getProduto() {
        return produto;
    }
    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public String toString() {
        return String.format("%s x%d - R$%.2f (Subtotal: R$%.2f)",
                produto.getNome(),
                quantidade,
                produto.getPreco(),
                getSubtotal());
    }
}