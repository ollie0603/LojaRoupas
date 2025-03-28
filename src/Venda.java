import java.util.ArrayList;
import java.util.List;

class Venda {
    private static int proximoId = 1;

    private int id;
    private Cliente cliente;
    private List<ItemVenda> itens;
    private double total;

    public Venda(Cliente cliente, List<ItemVenda> itens) {
        this.id = proximoId++;
        this.cliente = cliente;
        this.itens = new ArrayList<>(itens);
        calcularTotal();
    }

    public void calcularTotal() {
        double soma = 0.0;
        for (ItemVenda item : itens) {
            soma += item.getSubtotal();
        }
        this.total = soma;
    }

    @Override
    public String toString() {
        return String.format("Venda #%s - %s - %s - R$%.2f",
                id, cliente.getNome(), total);
    }

    public int getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public List<ItemVenda> getItens() { return itens; }
    public double getTotal() { return total; }
}