import java.util.*;
import java.text.SimpleDateFormat;

class Gestor {
    private List<Produto> produtos;
    private List<Venda> vendas;
    private List<Cliente> clientes;
    private Scanner scanner;

    public static void main(String[] args) {
        Gestor gestor = new Gestor();
        gestor.menuPrincipal();
    }

    public Gestor() {
        this.produtos = new ArrayList<>();
        this.vendas = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.scanner = new Scanner(System.in);

        clientes.add(new Cliente("123.456.789-00", "João Silva", "joao@email.com", "11999998888"));
        produtos.add(new Produto("P001", "Camiseta Branca", 49.90, 10, "M", "Camisetas"));
        produtos.add(new Produto("P002", "Calça Jeans", 129.90, 5, "42", "Calças"));
    }

    public void menuPrincipal() {
        int opcao;
        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Gerenciar Produtos");
            System.out.println("2. Gerenciar Vendas");
            System.out.println("3. Gerenciar Clientes");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    gerenciarProdutos();
                    break;
                case 2:
                    gerenciarVendas();
                    break;
                case 3:
                    gerenciarClientes();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private void gerenciarProdutos() {
        int opcao;
        do {
            System.out.println("\n=== GERENCIAR PRODUTOS ===");
            System.out.println("1. Listar Produtos");
            System.out.println("2. Cadastrar Produto");
            System.out.println("3. Editar Produto");
            System.out.println("4. Excluir Produto");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    listarProdutos();
                    break;
                case 2:
                    cadastrarProduto();
                    break;
                case 3:
                    editarProduto();
                    break;
                case 4:
                    excluirProduto();
                    break;
            }
        } while (opcao != 0);
    }

    private void listarProdutos() {
        System.out.println("\n=== LISTA DE PRODUTOS ===");
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            for (Produto p : produtos) {
                System.out.println(p);
            }
        }
    }

    private void cadastrarProduto() {
        System.out.println("\n=== CADASTRAR PRODUTO ===");
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Preço: ");
        double preco = scanner.nextDouble();
        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Tamanho: ");
        String tamanho = scanner.nextLine();
        System.out.print("Categoria: ");
        String categoria = scanner.nextLine();

        Produto novoProduto = new Produto(codigo, nome, preco, quantidade, tamanho, categoria);
        produtos.add(novoProduto);
        System.out.println("Produto cadastrado com sucesso!");
    }

    private void editarProduto() {
        System.out.println("\n=== EDITAR PRODUTO ===");
        listarProdutos();
        System.out.print("Digite o código do produto a editar: ");
        String codigo = scanner.nextLine();

        for (Produto p : produtos) {
            if (p.getCodigo().equals(codigo)) {
                System.out.print("Novo nome (" + p.getNome() + "): ");
                String nome = scanner.nextLine();
                if (!nome.isEmpty()) p.setNome(nome);

                System.out.print("Novo preço (" + p.getPreco() + "): ");
                String precoStr = scanner.nextLine();
                if (!precoStr.isEmpty()) p.setPreco(Double.parseDouble(precoStr));

                System.out.print("Nova quantidade (" + p.getQuantidade() + "): ");
                String qtdStr = scanner.nextLine();
                if (!qtdStr.isEmpty()) p.setQuantidade(Integer.parseInt(qtdStr));

                System.out.print("Nova categoria (" + p.getCategoria() + "): ");
                String categoria = scanner.nextLine();
                if (!categoria.isEmpty()) p.setCategoria(categoria);

                System.out.println("Produto atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado!");
    }

    private void excluirProduto() {
        System.out.println("\n=== EXCLUIR PRODUTO ===");
        listarProdutos();
        System.out.print("Digite o código do produto a excluir: ");
        String codigo = scanner.nextLine();

        Iterator<Produto> iterator = produtos.iterator();
        while (iterator.hasNext()) {
            Produto p = iterator.next();
            if (p.getCodigo().equals(codigo)) {
                iterator.remove();
                System.out.println("Produto removido com sucesso!");
                return;
            }
        }
        System.out.println("Produto não encontrado!");
    }

    private void gerenciarVendas() {
        int opcao;
        do {
            System.out.println("\n=== GERENCIAR VENDAS ===");
            System.out.println("1. Listar Vendas");
            System.out.println("2. Registrar Venda");
            System.out.println("3. Detalhes de Venda");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    listarVendas();
                    break;
                case 2:
                    registrarVenda();
                    break;
                case 3:
                    detalharVenda();
                    break;
            }
        } while (opcao != 0);
    }

    private void listarVendas() {
        System.out.println("\n=== LISTA DE VENDAS ===");
        if (vendas.isEmpty()) {
            System.out.println("Nenhuma venda registrada.");
        } else {
            for (Venda v : vendas) {
                System.out.println(v);
            }
        }
    }

    private void registrarVenda() {
        System.out.println("\n=== REGISTRAR VENDA ===");

        System.out.println("Clientes cadastrados:");
        for (Cliente c : clientes) {
            System.out.println(c.getCpf() + " - " + c.getNome());
        }
        System.out.print("Digite o CPF do cliente: ");
        String cpf = scanner.nextLine();

        Cliente clienteVenda = null;
        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                clienteVenda = c;
                break;
            }
        }

        if (clienteVenda == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        List<ItemVenda> itens = new ArrayList<>();
        boolean continuar = true;

        do {
            System.out.println("\nProdutos disponíveis:");
            listarProdutos();
            System.out.print("Digite o código do produto (ou 0 para finalizar): ");
            String codigo = scanner.nextLine();

            if (codigo.equals("0")) {
                continuar = false;
            } else {
                Produto produtoSelecionado = null;
                for (Produto p : produtos) {
                    if (p.getCodigo().equals(codigo)) {
                        produtoSelecionado = p;
                        break;
                    }
                }

                if (produtoSelecionado != null) {
                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();
                    scanner.nextLine();

                    if (quantidade <= produtoSelecionado.getQuantidade()) {
                        itens.add(new ItemVenda(produtoSelecionado, quantidade));
                        produtoSelecionado.setQuantidade(produtoSelecionado.getQuantidade() - quantidade);
                        System.out.println("Produto adicionado à venda.");
                    } else {
                        System.out.println("Quantidade indisponível em estoque!");
                    }
                } else {
                    System.out.println("Produto não encontrado!");
                }
            }
        } while (continuar && !produtos.isEmpty());

        if (!itens.isEmpty()) {
            Venda novaVenda = new Venda(clienteVenda, itens);
            vendas.add(novaVenda);
            System.out.println("\nVenda registrada com sucesso!");
            System.out.println(novaVenda);
        } else {
            System.out.println("Venda cancelada - nenhum produto selecionado.");
        }
    }

    private void detalharVenda() {
        System.out.println("\n=== DETALHES DE VENDA ===");
        listarVendas();
        System.out.print("Digite o ID da venda: ");
        String id = scanner.nextLine();

        for (Venda v : vendas) {
            if (v.getId().equals(id)) {
                System.out.println("\n=== DETALHES ===");
                System.out.println("Cliente: " + v.getCliente().getNome());
                System.out.println("Data: " + v.getDataFormatada());
                System.out.println("\nItens:");
                for (ItemVenda item : v.getItens()) {
                    System.out.printf("%s x%d - R$%.2f\n",
                            item.getProduto().getNome(),
                            item.getQuantidade(),
                            item.getSubtotal());
                }
                System.out.printf("\nTotal: R$%.2f\n", v.getTotal());
                return;
            }
        }
        System.out.println("Venda não encontrada!");
    }

    private void gerenciarClientes() {
        int opcao;
        do {
            System.out.println("\n=== GERENCIAR CLIENTES ===");
            System.out.println("1. Listar Clientes");
            System.out.println("2. Cadastrar Cliente");
            System.out.println("3. Editar Cliente");
            System.out.println("4. Excluir Cliente");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    listarClientes();
                    break;
                case 2:
                    cadastrarCliente();
                    break;
                case 3:
                    editarCliente();
                    break;
                case 4:
                    excluirCliente();
                    break;
            }
        } while (opcao != 0);
    }

    private void listarClientes() {
        System.out.println("\n=== LISTA DE CLIENTES ===");
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
        } else {
            for (Cliente c : clientes) {
                System.out.println(c);
            }
        }
    }

    private void cadastrarCliente() {
        System.out.println("\n=== CADASTRAR CLIENTE ===");
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        Cliente novoCliente = new Cliente(cpf, nome, email, telefone);
        clientes.add(novoCliente);
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private void editarCliente() {
        System.out.println("\n=== EDITAR CLIENTE ===");
        listarClientes();
        System.out.print("Digite o CPF do cliente a editar: ");
        String cpf = scanner.nextLine();

        for (Cliente c : clientes) {
            if (c.getCpf().equals(cpf)) {
                System.out.print("Novo nome (" + c.getNome() + "): ");
                String nome = scanner.nextLine();
                if (!nome.isEmpty()) c.setNome(nome);

                System.out.print("Novo email (" + c.getEmail() + "): ");
                String email = scanner.nextLine();
                if (!email.isEmpty()) c.setEmail(email);

                System.out.print("Novo telefone (" + c.getTelefone() + "): ");
                String telefone = scanner.nextLine();
                if (!telefone.isEmpty()) c.setTelefone(telefone);

                System.out.println("Cliente atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Cliente não encontrado!");
    }

    private void excluirCliente() {
        System.out.println("\n=== EXCLUIR CLIENTE ===");
        listarClientes();
        System.out.print("Digite o CPF do cliente a excluir: ");
        String cpf = scanner.nextLine();

        Iterator<Cliente> iterator = clientes.iterator();
        while (iterator.hasNext()) {
            Cliente c = iterator.next();
            if (c.getCpf().equals(cpf)) {
                iterator.remove();
                System.out.println("Cliente removido com sucesso!");
                return;
            }
        }
        System.out.println("Cliente não encontrado!");
    }
}

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

class Venda {
    private String id;
    private Cliente cliente;
    private List<ItemVenda> itens;
    private double total;
    private Date data;

    public Venda(Cliente cliente, List<ItemVenda> itens) {
        this.id = UUID.randomUUID().toString().substring(0, 8);
        this.cliente = cliente;
        this.itens = new ArrayList<>(itens);
        this.data = new Date();
        calcularTotal();
    }

    public void calcularTotal() {
        this.total = itens.stream()
                .mapToDouble(ItemVenda::getSubtotal)
                .sum();
    }

    public String getDataFormatada() {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm").format(data);
    }

    @Override
    public String toString() {
        return String.format("Venda #%s - %s - %s - R$%.2f",
                id, cliente.getNome(), getDataFormatada(), total);
    }

    public String getId() { return id; }
    public Cliente getCliente() { return cliente; }
    public List<ItemVenda> getItens() { return itens; }
    public double getTotal() { return total; }
    public Date getData() { return data; }
}

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

    public Produto getProduto() { return produto; }
    public int getQuantidade() { return quantidade; }
}

class Cliente {
    private String cpf;
    private String nome;
    private String email;
    private String telefone;

    public Cliente(String cpf, String nome, String email, String telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return String.format("%s - %s - %s - %s", cpf, nome, email, telefone);
    }

    public String getCpf() { return cpf; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
}