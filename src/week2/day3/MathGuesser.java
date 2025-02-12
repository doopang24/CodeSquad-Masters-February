package week2.day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MathGuesser {

    public Integer[] solution(int[] answers) {
        List<Integer> winnerList = new ArrayList<>();

        int[] guesser1 = new int[]{1, 2, 3, 4, 5};
        int[] guesser2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] guesser3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int count[] = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == guesser1[i % guesser1.length]) count[0]++;
            if (answers[i] == guesser2[i % guesser2.length]) count[1]++;
            if (answers[i] == guesser3[i % guesser3.length]) count[2]++;
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < count.length; i++) {
            if (count[i] >= max) max = count[i];
        }
        for(int i = 0; i < count.length; i++) {
            if(count[i]>=max) winnerList.add(i+1);
        }

        Integer[] winnerListArray = winnerList.toArray(new Integer[0]);
        Arrays.sort(winnerListArray);

        return winnerListArray;
    }

    public static void main(String[] args) {
        MathGuesser guesser = new MathGuesser();

        int[] answers = {1, 3, 2, 4, 2};
        System.out.println(Arrays.toString(guesser.solution(answers)));
    }
}
