import java.util.ArrayList;
import java.util.List;

public class Movie extends AudioVisualWork{
    private String name;
    private String creationDate;
    private double budget;
    private String description;

    private Director director;
    private List<Actor> actors = new ArrayList<>();

    public Movie(String name, String creationDate, double budget, String description) {
        super(name, creationDate, description);
        this.budget = budget;
    }

    public void displayDetails() {
        System.out.println();
        System.out.println("=== Filme ====");
        viewBase();
        System.out.println("Orçamento: R$ " + budget);
        System.out.println("-------------------------------");
    }
}
