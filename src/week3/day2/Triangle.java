package week3.day2;

public class Triangle implements Figure {

    private Coordinate point1, point2, point3;

    public Triangle(Coordinate point1, Coordinate point2, Coordinate point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    @Override
    public double calculateArea() {
        double a = getDistance(point1, point2);
        double b = getDistance(point2, point3);
        double c = getDistance(point3, point1);
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public void printResult() {
        System.out.println("면적 : " + calculateArea());
    }

    private double getDistance(Coordinate point1, Coordinate point2) {
        int x1 = point1.getX();
        int y1 = point1.getY();
        int x2 = point2.getX();
        int y2 = point2.getY();
        return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    }
}
