package week3.day5;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FunctionalClassifierAlpha {

    private static final int NUMBER = 6;

    public static void main(String[] args) {
        Consumer<String> output = result -> {
            System.out.println(result);
        };
        // index 가 NUMBER 의 약수인지 확인
        Function<Integer, Optional<Integer>> isFactor = (Integer index) ->
                NUMBER % index == 0 ? Optional.of(index) : Optional.empty();

        // 1 부터 NUMBER 까지의 숫자 중에서 약수 찾기
        List<Integer> factors = IntStream.range(1, NUMBER + 1)
                .mapToObj(i -> isFactor.apply(i))   // int 를 Integer 로 변환해서 적용
                .flatMap(Optional::stream)          // Optional 을 스트림으로 변환해서 값만 추출
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> sumFactors = list ->
                list.stream().reduce(0, (a, b) -> a + b);

        int sum = sumFactors.apply(factors);

        if (sum - NUMBER == NUMBER) {
            output.accept(NUMBER + " is perfect number");
        } else {
            output.accept(NUMBER + " is not a perfect number");
        }
    }
}
