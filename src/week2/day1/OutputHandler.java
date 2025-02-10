package week2.day1;

import java.util.Random;

public class OutputHandler {
    static Random random = new Random();

    public void printSudokuBoard(int[][] gameBoard) {
        int boardSize = gameBoard[0].length;
        for (int i = 0; i < boardSize; i++) {
            if (i % 3 == 0 && i != 0) {
                System.out.println("-----------------------------");
            }
            for (int j = 0; j < boardSize; j++) {
                if (j % 3 == 0 && j != 0) System.out.print("|");
                if (gameBoard[i][j] == 0) {
                    System.out.print("   ");    // 0이면 빈칸만 출력
                } else {
                    System.out.print(" " + gameBoard[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    public void printEasySudoku(int[][] gameBoard) {        // 비교적 쉬운 스도쿠
        int hiddenCount = random.nextInt(2) + 2;      // 숨겨진 수가 2~3개
        gameBoard = generateHiddenGameBoard(gameBoard, hiddenCount);
        printSudokuBoard(gameBoard);
    }

    public void printHardSudoku(int[][] gameBoard) {        // 비교적 어려운 스도쿠
        int hiddenCount = random.nextInt(2) + 4;      // 숨겨진 수가 4~5개
        gameBoard = generateHiddenGameBoard(gameBoard, hiddenCount);
        printSudokuBoard(gameBoard);
    }

    private int[][] generateHiddenGameBoard(int[][] gameBoard, int hiddenCount) {
        // 각 행마다 hiddenCount 만큼의 수를 0으로 바꿈
        for (int i = 0; i < gameBoard.length; i++) {
            int count = 0, randomPos;
            while (hiddenCount >= count) {
                randomPos = random.nextInt(9);  // 0으로 바꿀 index 를 random 으로 받음
                gameBoard[i][randomPos] = 0;
                count++;
            }
        }
        return gameBoard;
    }
}
