package week1.day2;

public class Main {
    private String getInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("점수를 쉼표와 띄어쓰기로 구분해서 입력하세요.");
        return scanner.nextLine();
    }

    private int[] StringToIntArray(String input) {
        String[] inputSplit = input.split(", ");
        int[] answer = new int[inputSplit.length];
        for (int i = 0; i < inputSplit.length; i++) {
            answer[i] = Integer.parseInt(inputSplit[i]);
        }
        return answer;
    }
}

