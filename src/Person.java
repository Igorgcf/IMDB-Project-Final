public abstract class Person {

    private String name;
    private String DateBirth;

    public Person(String name, String dataNascimento) {
        this.name = name;
        this.DateBirth = dataNascimento;
    }

    public String getName() {
        return name;
    }

    public String getDateBirth() {
        return DateBirth;
    }

    public abstract String getType();
}

