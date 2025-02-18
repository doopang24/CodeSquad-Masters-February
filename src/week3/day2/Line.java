package week3.day2;

public class Line implements Figure {

    private Coordinate point1, point2;
    private String[][] grid = new String[51][51];

    public Line(Coordinate point1, Coordinate point2) {
        this.point1 = point1;
        this.point2 = point2;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                grid[i][j] = " ";
            }
        }
    }

    @Override
    public double calculateArea() {
        return Math.sqrt(Math.pow((point1.getX() - point2.getX()), 2) + Math.pow((point1.getY() - point2.getY()), 2));
    }

    @Override
    public void printResult() {
        System.out.println("길이 : " + calculateArea());
    }
}
