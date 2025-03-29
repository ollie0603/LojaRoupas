class ItemVenda {
    private GerenteProduto produto;
    private int quantidade;

    public ItemVenda(GerenteProduto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public double getSubtotal() {
        return produto.getPreco() * quantidade;
    }

    public GerenteProduto getProduto() {
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