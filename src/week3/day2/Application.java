package week3.day2;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        FigureFactory factory = new FigureFactory();
        InputHandler inputHandler = new InputHandler();

        List<Coordinate> coordinateList = inputHandler.getCoordinates();
        factory.findOutFigure(coordinateList);
    }
}
