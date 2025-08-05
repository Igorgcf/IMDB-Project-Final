import java.util.ArrayList;
import java.util.List;

public class Series extends AudioVisualWork{
    private String name;
    private String creationDate;
    private int seasons;
    private String description;

    private Director director;
    private List<Actor> actors = new ArrayList<>();

    public Series(String name, String creationDate, int seasons, String description) {
        super(name, creationDate, description);
        this.seasons = seasons;
    }

    public void displayDetails() {
        System.out.println("=== Série ====");
        viewBase();
        System.out.println("Temporadas: " + seasons);
        System.out.println("-------------------------------");
    }
}

