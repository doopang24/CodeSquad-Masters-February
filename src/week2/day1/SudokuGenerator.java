package week2.day1;

import java.util.Random;

public class SudokuGenerator {

    private static final int BOARD_SIZE = 9;        // 보드 크기
    private static final int CELL_SIZE = 3;         // 셀 크기
    private static int[][] gameBoard;               // 게임판

    // 생성자, 객체 생성하면 자동으로 스도쿠 배열 만듦
    public SudokuGenerator() {
        gameBoard = new int[BOARD_SIZE][BOARD_SIZE];
        fillSudokuBoard(0, 0);
    }

    public int[][] getGameBoard() {
        return gameBoard;
    }

    private boolean fillSudokuBoard(int row, int col) {
        if (row == BOARD_SIZE) return true;

        int nextRow = (col == BOARD_SIZE - 1) ? row + 1 : row;
        int nextCol = (col == BOARD_SIZE - 1) ? 0 : col + 1;

        int[] randomFigures = getShuffledNumbers(); // 무작위로 섞인 1~9의 숫자
        for (int figure : randomFigures) {
            if (checkRow(figure, row) && checkColumn(figure, col) && checkCell(figure, row, col)) {
                gameBoard[row][col] = figure;

                // 다음 칸으로 이동
                if (fillSudokuBoard(nextRow, nextCol)) return true;

                // 백트래킹 (되돌리기)
                gameBoard[row][col] = 0;
            }
        }
        return false;
    }

    public boolean canPlaceNumber(int[] attempt) {
        int row = attempt[0];
        int col = attempt[1];
        int userTry = attempt[2];   // 게임 이용자의 시도
        if (checkRow(userTry, row) && checkColumn(userTry, col) && checkCell(userTry, row, col)) {
            return true;
        }
        return false;
    }

    // Fisher-Yates 알고리즘
    private int[] getShuffledNumbers() {
        Random random = new Random();
        int[] numbers = new int[BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {  // 순차적인 숫자 배열 세팅
            numbers[i] = i + 1;
        }
        for (int i = BOARD_SIZE - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int tmp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = tmp;
        }
        return numbers;
    }

    // 행 (row) 검증
    private boolean checkRow(int num, int row) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (gameBoard[row][i] == num) return false;
        }
        return true;
    }

    // 열 (column) 검증
    private boolean checkColumn(int num, int col) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            if (gameBoard[i][col] == num) return false;
        }
        return true;
    }

    // 셀 (3*3) 검증
    private boolean checkCell(int num, int row, int col) {
        int startRow = (row / CELL_SIZE) * CELL_SIZE;
        int startCol = (col / CELL_SIZE) * CELL_SIZE;
        for (int i = 0; i < CELL_SIZE; i++) {
            for (int j = 0; j < CELL_SIZE; j++) {
                if (gameBoard[startRow + i][startCol + j] == num) return false;
            }
        }
        return true;
    }
}
