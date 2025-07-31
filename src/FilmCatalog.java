import java.util.*;

public class FilmCatalog {
    private static List<Movie> movies = new ArrayList<>();
    private static List<Actor> actors = new ArrayList<>();
    private static List<Director> directors = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n===== Catálogo de Filmes =====");
            System.out.println("1. Cadastrar Filme");
            System.out.println("2. Cadastrar Ator");
            System.out.println("3. Cadastrar Diretor");
            System.out.println("4. Associar Atores e Diretor ao Filme");
            System.out.println("5. Pesquisar Filme por Nome");
            System.out.println("0. Sair");
            System.out.print("Escolha a opção: ");
            System.out.println();
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> registerMovie();
                case 2 -> registerActor();
                case 3 -> registerDirector();
                case 4 -> associateMovie();
                case 5 -> searchMovie();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void registerMovie() {
        System.out.println();
        System.out.print("Nome do Filme: ");
        String name = scanner.nextLine();
        System.out.print("Data de Lançamento: ");
        String date = scanner.nextLine();
        System.out.print("Orçamento: ");
        double budget = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Descrição: ");
        String description = scanner.nextLine();

        movies.add(new Movie(name, date, budget, description));
        System.out.println("Filme cadastrado!");
    }

    private static void registerActor() {
        System.out.println();
        System.out.print("Nome do Ator: ");
        String name = scanner.nextLine();
        System.out.print("Data de Nascimento: ");
        String date = scanner.nextLine();

        actors.add(new Actor(name, date));
        System.out.println("Ator cadastrado!");
    }

    private static void registerDirector() {
        System.out.println();
        System.out.print("Nome do Diretor: ");
        String name = scanner.nextLine();
        System.out.print("Data de Nascimento: ");
        String date = scanner.nextLine();

        directors.add(new Director(name, date));
        System.out.println("Diretor cadastrado!");
    }

    private static void associateMovie() {
        if (movies.isEmpty()) {
            System.out.println("Nenhum filme cadastrado.");
            return;
        }

        System.out.println("Selecione um filme:");
        System.out.println();
        for (int i = 0; i < movies.size(); i++) {
            System.out.println(i + " - " + movies.get(i).getName());
        }
        int idxMovie = Integer.parseInt(scanner.nextLine());
        Movie movie = movies.get(idxMovie);

        System.out.println("Selecione um diretor:");
        System.out.println();
        for (int i = 0; i < directors.size(); i++) {
            System.out.println(i + " - " + directors.get(i).getName());
        }
        int idxDirector = Integer.parseInt(scanner.nextLine());
        movie.setDirector(directors.get(idxDirector));

        System.out.println("Adicione atores (digite o número, -1 para encerrar):");
        System.out.println();
        for (int i = 0; i < actors.size(); i++) {
            System.out.println(i + " - " + actors.get(i).getName());
        }

        int idxAtor;
        while ((idxAtor = Integer.parseInt(scanner.nextLine())) != -1) {
            if (idxAtor >= 0 && idxAtor < actors.size()) {
                movie.addActor(actors.get(idxAtor));
            } else {
                System.out.println("Índice inválido.");
            }
        }

        System.out.println("Associação feita com sucesso!");
    }

    private static void searchMovie() {
        System.out.println("\n===== Pesquisa de Filme =====");
        System.out.print("Digite o nome do filme: ");
        System.out.println();
        String term = scanner.nextLine();

        boolean found = false;
        for (Movie movie : movies) {
            if (movie.nameContains(term)) {
                movie.displayDetails();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Nenhum filme encontrado com esse nome.");
        }
    }
}
