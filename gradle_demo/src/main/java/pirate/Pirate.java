package pirate;

public class Pirate {
    final private String name;
    final private String hobby;

    public Pirate(String name, String hobby) {
        this.name = name;
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }

    public String getHobby() {
        return hobby;
    }
}
