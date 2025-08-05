import java.util.*;

public class FilmCatalog {
    private static List<Series> series = new ArrayList<>();
    private static List<Movie> movies = new ArrayList<>();
    private static List<Actor> actors = new ArrayList<>();
    private static List<Director> directors = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n===== Catálogo de Obras Audiovisuais =====");
            System.out.println("1. Cadastrar Filme");
            System.out.println("2. Cadastrar Série");
            System.out.println("3. Cadastrar Ator");
            System.out.println("4. Cadastrar Diretor");
            System.out.println("5. Associar Atores e Diretor (Filme)");
            System.out.println("6. Associar Atores e Diretor (Série)");
            System.out.println("7. Pesquisar Filme por Nome");
            System.out.println("8. Pesquisar Série por Nome");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> registerMovie();
                case 2 -> registerSeries();
                case 3 -> registerActor();
                case 4 -> registerDirector();
                case 5 -> associateMovie();
                case 6 -> associateSeries();
                case 7 -> searchMovie();
                case 8 -> searchSeries();
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

    private static void registerSeries() {
        System.out.print("Nome da Série: ");
        String name = scanner.nextLine();
        System.out.print("Data de Lançamento: ");
        String date = scanner.nextLine();
        System.out.print("Número de Temporadas: ");
        int seasons = Integer.parseInt(scanner.nextLine());
        System.out.print("Descrição: ");
        String description = scanner.nextLine();

        series.add(new Series(name, date, seasons, description));
        System.out.println("Série cadastrada!");
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
        Movie movie = selectMovie();
        associateWork(movie);
    }

    private static void associateSeries () {
        if (series.isEmpty()) {
            System.out.println("Nenhuma série cadastrada.");
            return;
        }
        Series series = selectSeries();
        associateWork(series);
    }
    private static Movie selectMovie() {
        System.out.println("Selecione um filme:");
        for (int i = 0; i < movies.size(); i++) {
            System.out.println(i + " - " + movies.get(i).getName());
        }
        int idx = Integer.parseInt(scanner.nextLine());
        return movies.get(idx);
    }

    private static Series selectSeries() {
        System.out.println("Selecione uma série:");
        for (int i = 0; i < series.size(); i++) {
            System.out.println(i + " - " + series.get(i).getName());
        }
        int idx = Integer.parseInt(scanner.nextLine());
        return series.get(idx);
    }

    private static void associateWork
            (AudioVisualWork work) {
        if (directors.isEmpty()) {
            System.out.println("Nenhum diretor cadastrado.");
            return;
        }
        System.out.println("Selecione um diretor:");
        for (int i = 0; i < directors.size(); i++) {
            System.out.println(i + " - " + directors.get(i).getName());
        }
        int idxDiretor = Integer.parseInt(scanner.nextLine());
        work.setDirector(directors.get(idxDiretor));

        if (actors.isEmpty()) {
            System.out.println("Nenhum ator cadastrado.");
            return;
        }
        System.out.println("Adicione atores (digite o número, -1 para encerrar):");
        for (int i = 0; i < actors.size(); i++) {
            System.out.println(i + " - " + actors.get(i).getName());
        }
        int idxAtor;
        while ((idxAtor = Integer.parseInt(scanner.nextLine())) != -1) {
            if (idxAtor >= 0 && idxAtor < actors.size()) {
                work.addActor(actors.get(idxAtor));
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

    private static void searchSeries() {
        System.out.print("Digite o nome da série: ");
        String term = scanner.nextLine();
        boolean encontrado = false;
        for (Series serie : series) {
            if (serie.nameContains(term)) {
                serie.displayDetails();
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Nenhuma série encontrada com esse nome.");
        }
    }
}
