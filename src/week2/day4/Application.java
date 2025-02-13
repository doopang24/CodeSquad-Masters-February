package week2.day4;

import java.util.Scanner;

public class Application {

    public int getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("확인할 단계를 입력하세요.");
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        Application application = new Application();
        Printer printer = new Printer();
        Transporter transporter = new Transporter();

        int inputStep = application.getInput();
        transporter.transportController(inputStep);

    }
}
