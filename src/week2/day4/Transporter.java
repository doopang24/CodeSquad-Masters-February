package week2.day4;

import java.util.List;

public class Transporter {

    static Printer printer = new Printer();
    static StackManager manager = new StackManager();
    static List<List<String>> transportStatus;
    static int step = 1;

    public void transportController(int requiredStep) {
        int numberOfParts = 3;
        int from = 1, mid = 2, to = 3;

        hanoi(numberOfParts, from, mid, to, requiredStep);
        printer.printController(manager.getDeskStatus(), requiredStep);
    }

    private void hanoi(int numberOfParts, int from, int mid, int to, int requiredStep) {
        if (step >= requiredStep) return;
        if (numberOfParts == 1) {
            moveParts(from, to);
            return;
        }
        hanoi(numberOfParts - 1, from, to, mid, requiredStep);
        if (step >= requiredStep) return;
        moveParts(from, to);
        hanoi(numberOfParts - 1, mid, from, to, requiredStep);
    }

    private void moveParts(int from, int to) {
        step++;
        String part = manager.takeOutPart(from);
        manager.addPart(to, part);
    }
}
