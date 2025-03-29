class Produto implements GerenteProduto {
    private String codigo;
    private String nome;
    private double preco;
    private int quantidade;
    private String categoria;

    public Produto(String codigo, String nome, double preco, int quantidade, String categoria) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }

    @Override
    public String getDetalhes() {
        return String.format("%s - %s - R$%.2f - %d disponíveis - %s",
                codigo, nome, preco, quantidade, categoria);
    }

    @Override
    public String toString() {
        return getDetalhes();
    }

    @Override
    public String getCodigo() {
        return codigo;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String getCategoria() {
        return categoria;
    }

    @Override
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

}