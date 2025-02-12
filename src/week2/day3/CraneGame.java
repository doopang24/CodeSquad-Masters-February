package week2.day3;

import java.util.ArrayList;
import java.util.List;

public class CraneGame {

    public int solution(int[][] board, int[] moves) {
        int count = 0, Depth = board.length;
        List<Integer> basket = new ArrayList<>();
        for (int turn : moves) {    // moves 순회
            int col = turn - 1;     // col : 크레인의 열 index 위치
            for (int i = 0; i < Depth; i++) {     // 인형을 집으러 내려감
                if (board[i][col] != 0) {
                    if (!basket.isEmpty() && basket.getLast() == board[i][col]) {
                        basket.removeLast();
                        count += 2;
                    } else {
                        basket.add(board[i][col]);
                    }
                    board[i][col] = 0;  // 인형을 꺼내면 빈칸으로 처리
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CraneGame game = new CraneGame();

        int[][] gameBoard = new int[][]{
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };
        int[] moves = new int[]{1, 5, 3, 5, 1, 2, 1, 4};

        System.out.println(game.solution(gameBoard, moves));
    }
}
