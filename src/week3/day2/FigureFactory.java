package week3.day2;

import java.util.List;

public class FigureFactory {

    public void findOutFigure(List<Coordinate> coordinateList) {
        int vertex = coordinateList.size();
        switch (vertex) {
            case 2:
                Figure line = new Line(coordinateList.get(0), coordinateList.get(1));
                line.printResult();
                break;
            case 3:
                Figure triangle = new Triangle(coordinateList.get(0), coordinateList.get(1), coordinateList.get(2));
                triangle.printResult();
                break;
            case 5:
                Figure polygon = new Polygon(coordinateList);
                polygon.printResult();
                break;
        }
    }
}
