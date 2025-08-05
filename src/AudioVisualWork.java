import java.util.ArrayList;
import java.util.List;

public abstract class AudioVisualWork {

        private String name;
        private String creationDate;
        private String description;
        private Director director;
        private List<Actor> actors = new ArrayList<>();

        public AudioVisualWork(String name, String creationDate, String description) {
            this.name = name;
            this.creationDate = creationDate;
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

        protected void viewBase() {
            System.out.println("Nome: " + name);
            System.out.println("Data de Lançamento: " + creationDate);
            System.out.println("Descrição: " + description);
            System.out.println("Diretor: " + (director != null ? director.getName() : "Não atribuído"));
            System.out.println("Atores:");
            for (Actor actor : actors) {
                System.out.println(" - " + actor.getName());
            }
        }

        public abstract void displayDetails();
    }