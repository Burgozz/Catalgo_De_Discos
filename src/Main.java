import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Disco> discos = new ArrayList<>();
        int opcao;

        do {
            System.out.println("\n=== Catálogo de Discos ===");
            System.out.println("1. Cadastrar Disco");
            System.out.println("2. Listar Discos");
            System.out.println("3. Editar Disco");
            System.out.println("4. Remover Disco");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarDisco(discos, scanner);
                    break;
                case 2:
                    listarDiscos(discos);
                    break;
                case 3:
                    editarDisco(discos, scanner);
                    break;
                case 4:
                    removerDisco(discos, scanner);
                    break;
                case 5:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            
        } while (opcao != 5);
    }

    private static void cadastrarDisco(ArrayList<Disco> discos, Scanner scanner) {
        System.out.print("Título do disco: ");
        String titulo = scanner.nextLine();
        System.out.print("Ano de lançamento: ");
        int ano = scanner.nextInt();
        scanner.nextLine(); // limpar buffer
        System.out.print("Nome do artista: ");
        String nomeArtista = scanner.nextLine();
        System.out.print("Gênero do artista: ");
        String genero = scanner.nextLine();

        Artista artista = new Artista(nomeArtista, genero);
        Disco disco = new Disco(titulo, ano, artista);

        System.out.println("Adicione as faixas ao disco:");
        while (true) {
            System.out.print("Nome da faixa (ou 'sair' para terminar): ");
            String nomeFaixa = scanner.nextLine();
            if (nomeFaixa.equalsIgnoreCase("sair")) break;

            System.out.print("Duração da faixa (em segundos): ");
            int duracao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            Faixa faixa = new Faixa(nomeFaixa, duracao);
            disco.adicionarFaixa(faixa);
        }

        discos.add(disco);
        System.out.println("Disco cadastrado com sucesso!");
    }

    private static void listarDiscos(ArrayList<Disco> discos) {
        if (discos.isEmpty()) {
            System.out.println("Nenhum disco cadastrado.");
            return;
        }
        System.out.println("\n=== Lista de Discos ===");
        for (int i = 0; i < discos.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + discos.get(i).getTitulo());
            System.out.println(discos.get(i)); // Mostra informações detalhadas
        }
    }

    private static void editarDisco(ArrayList<Disco> discos, Scanner scanner) {
        listarDiscos(discos);
        System.out.print("Selecione o número do disco para editar: ");
        int indice = scanner.nextInt() - 1;
        scanner.nextLine(); // limpar buffer
        if (indice < 0 || indice >= discos.size()) {
            System.out.println("Disco inválido.");
            return;
        }

        Disco disco = discos.get(indice);
        System.out.print("Novo título do disco (ou Enter para manter): ");
        String novoTitulo = scanner.nextLine();
        if (!novoTitulo.isEmpty()) {
            disco.editar(novoTitulo);
        }

        System.out.println("Edição concluída.");
    }

    private static void removerDisco(ArrayList<Disco> discos, Scanner scanner) {
        listarDiscos(discos);
        System.out.print("Selecione o número do disco para remover: ");
        int indice = scanner.nextInt() - 1;
        scanner.nextLine(); // limpar buffer
        if (indice < 0 || indice >= discos.size()) {
            System.out.println("Disco inválido.");
            return;
        }
        discos.remove(indice);
        System.out.println("Disco removido com sucesso!");
    }
}