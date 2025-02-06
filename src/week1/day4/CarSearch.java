package week1.day4;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarSearch {

    public String solution(String[] input) {
        CarManager manager = new CarManager();

        YearMonth referencePoint = parseDate(input[0]);     // 생산 비교 시점
        int requirement = Integer.parseInt(input[1]);       // 요구되는 수용 인원

        List<Car> inProductionModels = manager.getAvailableCarByDate(referencePoint);   // 입력된 시점에 생산중인 모델 리스트

        List<Car> suitableModels = new ArrayList<>();                                   // 수용 인원까지 맞는 모델 리스트
        for (Car singleModel : inProductionModels) {
            if (singleModel.canAccommodate(singleModel, requirement)) {
                suitableModels.add(singleModel);
            }
        }
        return joinModels(suitableModels);
    }

    private String joinModels(List<Car> suitableModels) {
        StringBuilder builder = new StringBuilder();
        for (Car singleCarModel : suitableModels) {
            builder.append(singleCarModel.getName());
            if (singleCarModel.isDiscontinued(singleCarModel)) builder.append("*"); // 현재 단종이면 * 추가
            builder.append("(").append(singleCarModel.getType()).append("),");
        }
        if (!builder.isEmpty()) builder.deleteCharAt(builder.length() - 1);     // 마지막 쉼표 제거
        return builder.toString();
    }

    private YearMonth parseDate(String input) {  // 입력된 String 을 날짜 형식으로 변환
        int year = Integer.parseInt(input.substring(0, 4));
        int month = Integer.parseInt(input.substring(4));
        return YearMonth.of(year, month);
    }

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public String[] inputParser(String input) {     // 입력값의 공백 제거
        String[] answer = input.split(",");
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answer[i].trim();
        }
        return answer;
    }

    public static void main(String[] args) {
        CarSearch search = new CarSearch();

        String input = search.getInput();
        String[] parsedInput = search.inputParser(input);
        System.out.println(search.solution(parsedInput));
    }
}
