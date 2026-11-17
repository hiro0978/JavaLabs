package yehor.lab3.model;

public enum Sex {
    MALE("ч"),
    FEMALE("ж");

    private final String shortName;

    Sex(String shortName) {
        this.shortName = shortName;
    }

    public String getShortName() {
        return shortName;
    }
}
