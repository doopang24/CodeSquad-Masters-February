package week3.day2;

import java.util.List;

public class Line implements Figure {

    private List<Coordinate> coordinateList;

    public Line(List<Coordinate> coordinateList) {
        this.coordinateList = coordinateList;
    }

    @Override
    public double calculateArea() {
        Coordinate point1 = coordinateList.get(0);
        Coordinate point2 = coordinateList.get(1);
        return Math.sqrt(Math.pow((point1.getX() - point2.getX()), 2) + Math.pow((point1.getY() - point2.getY()), 2));
    }

    @Override
    public void printResult() {
        CoordinatePlane plane = new CoordinatePlane();
        plane.displayResult(coordinateList);

        System.out.println("길이 : " + calculateArea());
    }
}
