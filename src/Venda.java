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
        this.total = 0.0;
        if (itens != null) {
            for (ItemVenda item : itens) {
                if (item != null && item.getProduto() != null) {  // Verifica nulos
                    this.total += item.getSubtotal();
                }
            }
        }
    }

    @Override
    public String toString() {
        return String.format("Venda #%d - Cliente: %s - Total: R$%.2f",
                id, cliente.getNome(), total);
    }

    public int getId() {
        return id;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public List<ItemVenda> getItens() {
        return itens;
    }
    public double getTotal() {
        return total;
    }
}