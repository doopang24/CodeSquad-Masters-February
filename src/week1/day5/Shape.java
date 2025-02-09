package week1.day5;

public enum Shape {
    DOG("\uD83D\uDC36"),
    CAT("\uD83D\uDC31"),
    COW("\uD83D\uDC2E");

    private final String animal;

    Shape(String animal) {
        this.animal = animal;
    }

    public String getAnimal() {
        return animal;
    }
}
