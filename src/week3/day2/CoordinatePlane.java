package week3.day2;

import java.util.List;

public class CoordinatePlane {

    private String[][] grid = new String[25][25];

    public CoordinatePlane() {
        initializeGrid();
    }

    // 빈 문자열로 초기화
    private void initializeGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                grid[i][j] = "   ";
            }
        }

        // y축 생성
        for (int i = 0; i < grid.length; i++) {
            if (i % 2 == 0 && i <= 24) {
                if ((24 - i) < 10 && (24 - i) != 0) {
                    grid[i][0] = " " + String.valueOf(24 - i) + "|";
                } else if ((24 - i) == 0) {
                    grid[i][0] = " " + String.valueOf(0) + " ";
                } else {
                    grid[i][0] = String.valueOf(24 - i) + "|";
                }
            } else {
                grid[i][0] = "  |";
            }
        }

        // x축 생성
        for (int i = 1; i < grid.length; i++) {
            grid[23][i] = "___";
        }
        for (int i = 1; i < grid.length; i++) {
            if (i < 10) {
                grid[24][i] = "  " + String.valueOf(i);
            } else {
                grid[24][i] = " " + String.valueOf(i);
            }
        }
    }

    public void displayResult(List<Coordinate> coordinateList) {
        for (Coordinate point : coordinateList) {
            // 점 찍히는 위치 오류
            grid[grid.length - point.getY() - 1][point.getX()] = " * ";
        }
        printGrid();
    }

    private void printGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
    }
}
