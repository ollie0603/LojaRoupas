class Produto {
    private String codigo;
    private String nome;
    private double preco;
    private int quantidade;
    private String categoria;

    public Produto(String codigo, String nome, double preco, int quantidade, String tamanho, String categoria) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return String.format("%s - %s (Tamanho: %s) - R$%.2f - %d disponíveis - %s",
                codigo, nome, preco, quantidade, categoria);
    }

    public String getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }
    public int getQuantidade() { return quantidade; }
    public void setQuantidade(int quantidade) { this.quantidade = quantidade; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
}