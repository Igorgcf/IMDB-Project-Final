
public class Actor extends Person {

    public Actor(String name, String dateBirth) {
        super(name, dateBirth);
    }

    @Override
    public String getType() {
        return "Ator";
    }
}
