package week3.day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputHandler {

    Scanner scanner = new Scanner(System.in);
    FigureFactory factory = new FigureFactory();

    public List<Coordinate> getCoordinates() {
        try {
            System.out.println("> 좌표를 입력하세요.");
            String input = scanner.next();
            return StringToList(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCoordinates();
        }
    }

    private List<Coordinate> StringToList(String input) {
        List<Coordinate> coordinateList = new ArrayList<>();

        Pattern coordinatePattern = Pattern.compile("\\((\\d+),(\\d+)\\)");
        Matcher matcher = coordinatePattern.matcher(input);

        while (matcher.find()) {
            int x = Integer.parseInt(matcher.group(1));
            int y = Integer.parseInt(matcher.group(2));
            if (x < 0 || x > 24 || y < 0 || y > 24) throw new IllegalArgumentException("0 이상 24 이하의 정수를 입력하세요.");
            coordinateList.add(new Coordinate(x, y));
        }
        if (coordinateList.size() == 4) throw new IllegalArgumentException("좌표 갯수를 다시 확인하세요.");
        return coordinateList;
    }
}
