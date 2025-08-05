public class Director extends Person {

    public Director(String name, String dateBirth) {
        super(name, dateBirth);
    }

    @Override
    public String getType() {
        return "Diretor";
    }
}