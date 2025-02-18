package week3.day2;

import java.util.Comparator;
import java.util.List;

public class Polygon implements Figure {

    private List<Coordinate> coordinateList;

    public Polygon(List<Coordinate> coordinateList) {
        this.coordinateList = coordinateList;
    }

    @Override
    public double calculateArea() {
        coordinateList = sortCoordinateList();
        double totalArea = 0;
        Coordinate basePoint = coordinateList.getFirst();

        for (int i = 1; i < coordinateList.size() - 1; i++) {
            Triangle triangle = new Triangle(basePoint, coordinateList.get(i), coordinateList.get(i + 1));
            totalArea += triangle.calculateArea();
        }
        return totalArea;
    }

    @Override
    public void printResult() {
        System.out.println("면적 : " + calculateArea());
    }

    // 무게 중심점 계산
    private Coordinate calculateCentroid(List<Coordinate> coordinateList) {
        double sumX = 0, sumY = 0;
        int n = coordinateList.size();
        for (Coordinate point : coordinateList) {
            sumX += point.getX();
            sumY += point.getY();
        }
        return new Coordinate((int) (sumX / n), (int) (sumY / n));
    }

    // 극각을 사용해서 정렬
    private List<Coordinate> sortCoordinateList() {
        Coordinate centroid = calculateCentroid(coordinateList);
        coordinateList.sort(Comparator.comparingDouble(Coordinate -> Math.atan2(Coordinate.getY() - centroid.getY(), Coordinate.getX() - centroid.getX())));
        return coordinateList;
    }
}
