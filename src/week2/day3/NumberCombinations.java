package week2.day3;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class NumberCombinations {

    public Integer[] solution(int[] numbers) {
        Set<Integer> combinations = new TreeSet<>();    // TreeSet 을 사용해서 자동 정렬
        int lt, rt;
        for (lt = 0; lt < numbers.length - 1; lt++) {
            for (rt = lt + 1; rt < numbers.length; rt++) {
                combinations.add(numbers[lt] + numbers[rt]);
            }
        }
        return combinations.toArray(new Integer[0]);
    }

    public static void main(String[] args) {
        NumberCombinations combinations = new NumberCombinations();

        int[] numbers = new int[]{2, 1, 3, 4, 1};
        System.out.println(Arrays.toString(combinations.solution(numbers)));
    }
}
