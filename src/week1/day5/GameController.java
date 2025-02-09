package week1.day5;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    public List<Player> producePlayerList(int headCount) {
        List<Player> playerList = new ArrayList<>();

        int cardsPerPlayer = (headCount == 3) ? 8 : (headCount == 4 ? 7 : 6);
        int floorCardCount = (headCount == 3) ? 9 : (headCount == 4 ? 8 : 6);

        return playerList;
    }
}
