import java.util.ArrayList;
import java.util.List;

public class Movie {
    private String name;
    private String creationDate;
    private double budget;
    private String description;

    private Director director;
    private List<Actor> actors = new ArrayList<>();

    public Movie(String name, String creationDate, double budget, String description) {
        this.name = name;
        this.creationDate = creationDate;
        this.budget = budget;
        this.description = description;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public void addActor(Actor actor) {
        actors.add(actor);
    }

    public String getName() {
        return name;
    }

    public boolean nameContains(String term) {
        return name.toLowerCase().contains(term.toLowerCase());
    }

    public void displayDetails() {
        System.out.println();
        System.out.println("Detalhes do filme:");
        System.out.println("Filme: " + name);
        System.out.println("Data de criação: " + creationDate);
        System.out.println("Orçamento: R$ " + budget);
        System.out.println("Descrição: " + description);
        System.out.println("Diretor: " + (director != null ? director.getName() : "Não atribuído"));
        System.out.println("Atores:");
        for (Actor actor : actors) {
            System.out.println(" - " + actor.getName());
        }
        System.out.println("-------------------------------");
    }
}
