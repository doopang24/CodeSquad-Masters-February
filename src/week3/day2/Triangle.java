package week3.day2;

import java.util.ArrayList;
import java.util.List;

public class Triangle implements Figure {

    private List<Coordinate> coordinateList;

    public Triangle(List<Coordinate> coordinateList) {
        this.coordinateList = coordinateList;
    }

    @Override
    public double calculateArea() {
        Coordinate point1 = coordinateList.get(0);
        Coordinate point2 = coordinateList.get(1);
        Coordinate point3 = coordinateList.get(2);

        double a = getDistance(point1, point2);
        double b = getDistance(point2, point3);
        double c = getDistance(point3, point1);
        double s = (a + b + c) / 2;

        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public void printResult() {
        CoordinatePlane plane = new CoordinatePlane();
        plane.displayResult(coordinateList);
        System.out.println("면적 : " + calculateArea());
    }

    private double getDistance(Coordinate point1, Coordinate point2) {
        List<Coordinate> lineList = new ArrayList<>();
        lineList.add(point1);
        lineList.add(point2);
        Line line = new Line(lineList);
        return line.calculateArea();
    }
}
