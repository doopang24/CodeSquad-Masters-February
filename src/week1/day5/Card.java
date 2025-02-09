package week1.day5;

import java.util.ArrayList;
import java.util.List;

public class Card {

    private static final int SET_SIZE = 12;

    private Shape shape;
    private int figure;
    private static final List<Card> cardPack = new ArrayList<>();

    public Card(Shape shape, int figure) {
        this.shape = shape;
        this.figure = figure;
    }

    // Card 객체가 만들어지면 자동으로 카드팩(36개) 생성
    static {
        for (Shape animal : Shape.values()) {
            for (int i = 1; i <= SET_SIZE; i++) {
                cardPack.add(new Card(animal, i));
            }
        }
    }

    public List<Card> getCardPack() {
        return cardPack;
    }
}

