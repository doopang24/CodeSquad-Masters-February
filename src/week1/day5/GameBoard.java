package week1.day5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameBoard {

    //
    public void processGameFlow(int headCount) {
        List<Player> playerList = new ArrayList<>();
    }

    // 플레이어 수 입력 & 검증
    public int printPrompt() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("게임에 참여할 플레이어 수를 입력하세요.");
                int input = scanner.nextInt();
                if (input < 3 || input > 5) {
                    throw new Exception();
                }
                return input;
            } catch (Exception e) {
                System.out.println("3 이상 5 이하의 플레이어 수를 입력하세요.");
            }
        }
    }

    public static void main(String[] args) {
        GameBoard board = new GameBoard();

        int headCount = board.printPrompt();
    }
}

