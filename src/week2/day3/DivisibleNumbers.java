package week2.day3;

import java.util.Arrays;

public class DivisibleNumbers {

    public int[] solution(int[] arr, int divisor) {
        int count = 0, index = 0;
        for (int num : arr) {
            if (num % divisor == 0) count++;
        }

        if (count == 0) return new int[]{-1};   // 없을 경우 -1만 반환

        int[] answer = new int[count];  // 정확한 크기의 int[] 생성
        for (int num : arr) {
            if (num % divisor == 0)
                answer[index++] = num;
        }
        return answer;
    }

    public static void main(String[] args) {
        DivisibleNumbers application = new DivisibleNumbers();

        int[] original = new int[10];
        for (int i = 0; i < original.length; i++) original[i] = i + 1;
        System.out.println(Arrays.toString(original));

        int divisor = 11;
        int[] divisibleNumbers = application.solution(original, divisor);
        System.out.println(divisor + " -> " + Arrays.toString(divisibleNumbers));
    }
}
