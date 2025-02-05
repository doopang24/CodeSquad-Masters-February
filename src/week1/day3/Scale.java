package week1.day3;

import java.util.Scanner;

public class Scale {

    public String distinction(int[] playOrder) {
        int bottom = 1, top = 8;
        if (playOrder[0] == bottom) {
            for (int i = 0; i < playOrder.length - 1; i++) {
                if (playOrder[i] >= playOrder[i + 1]) {
                    return "mixed";
                }
            }
            return "ascending";
        } else if (playOrder[0] == top) {
            for (int i = playOrder.length - 2; i >= 0; i--) {
                if (playOrder[i] <= playOrder[i + 1]) {
                    return "mixed";
                }
            }
            return "descending";
        } else {
            return "mixed";
        }
    }

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("연주한 순서를 띄어쓰기로 구분해서 입력하세요.");
        return scanner.nextLine();
    }

    public int[] StringToIntArray(String input) {
        String[] dividedInput = input.split(" ");
        int[] answer = new int[dividedInput.length];
        for (int i = 0; i < dividedInput.length; i++) {
            answer[i] = Integer.parseInt(dividedInput[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scale scale = new Scale();
        String input = scale.getInput();
        int[] playOrder = scale.StringToIntArray(input);
        System.out.println(scale.distinction(playOrder));
    }
}
