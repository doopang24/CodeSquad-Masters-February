package week1.day5;

import java.util.List;

public class Player {
    private String name;
    private List<Card> hand;
    private int score;

    public Player(String name, List<Card> hand) {
        this.name = name;
        this.hand = hand;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public int getScore() {
        return score;
    }

    public void addScore() {
        this.score += 1;
    }
}

