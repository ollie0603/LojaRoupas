public interface ProdutoInterface {
    String getCodigo();
    String getNome();
    double getPreco();
    int getQuantidade();
    String getCategoria();
    void setNome(String nome);
    void setPreco(double preco);
    void setQuantidade(int quantidade);
    void setCategoria(String categoria);
    String getDetalhes();
}