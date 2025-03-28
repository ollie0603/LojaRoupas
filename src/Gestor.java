import java.util.*;
import java.text.SimpleDateFormat;

class Gestor {
    private List<ProdutoInterface> produtos;
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
            for (ProdutoInterface p : produtos) {
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

        for (ProdutoInterface p : produtos) {
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

        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getCodigo().equals(codigo)) {
                produtos.remove(i);
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
            for (int i = 0; i < vendas.size(); i++) {
                System.out.printf("%d. %s%n", i+1, vendas.get(i));
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
                ProdutoInterface produtoSelecionado = null;
                for (ProdutoInterface p : produtos) {
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
                        itens.add(new ItemVenda((Produto) produtoSelecionado, quantidade));
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
            System.out.println("Resumo da Venda:");
            System.out.println(novaVenda);
            System.out.println("Itens:");
            for (ItemVenda item : novaVenda.getItens()) {
                System.out.println("  " + item);
            }
        } else {
            System.out.println("Venda cancelada - nenhum produto selecionado.");
        }
    }

    private void detalharVenda() {
        System.out.println("\n=== DETALHES DE VENDA ===");
        listarVendas();
        System.out.print("Digite o ID da venda: ");
        int id = scanner.nextInt();

        for (Venda v : vendas) {
            if (v.getId() == id) {
                System.out.println("\n=== DETALHES ===");
                System.out.println("Cliente: " + v.getCliente().getNome());
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

        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCpf().equals(cpf)) {
                clientes.remove(i);
                System.out.println("Cliente removido com sucesso!");
                return;
            }
        }
        System.out.println("Cliente não encontrado!");
    }
}






