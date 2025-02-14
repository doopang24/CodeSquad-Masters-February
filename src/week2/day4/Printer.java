package week2.day4;

import java.util.*;

public class Printer {

    private static final String BLANK = "          ";
    private static final String DESK1 = "1======== ";
    private static final String DESK2 = "2======== ";
    private static final String DESK3 = "3======== ";
    private static final int HEIGHT = 10;
    private static final int WIDTH = 3;
    private static int drvLength, displayLength, computeLength;
    private static List<String> drv = new ArrayList<>();
    private static List<String> display = new ArrayList<>();
    private static List<String> compute = new ArrayList<>();
    private static String[][] printBoard;

    public Printer() {
        setDrv();
        setDisplay();
        setCompute();
        printBoard = new String[HEIGHT][WIDTH];
    }

    private void setDrv() {
        drv.add("    [DRV]");
        drvLength = 1;
    }

    private void setDisplay() {
        display.add("+-------+");
        display.add("|       |");
        display.add("|DISPLAY|");
        display.add("|       |");
        display.add("+-------+");
        displayLength = 5;
    }

    private void setCompute() {
        compute.add("+-------+");
        compute.add("|COMPUTE|");
        compute.add("+-------+");
        computeLength = 3;
    }

    public void printController(Map<Integer, Stack<String>> deskStatus, int requiredStep) {
        printStep(requiredStep);
//        List<String> belongToDesk1 = new ArrayList<>(deskStatus.get(1));
//        List<String> belongToDesk2 = new ArrayList<>(deskStatus.get(2));
//        List<String> belongToDesk3 = new ArrayList<>(deskStatus.get(3));
//
//        String[] desk1 = belongToDesk1.toArray(new String[0]);
//        String[] desk2 = belongToDesk2.toArray(new String[0]);
//        String[] desk3 = belongToDesk3.toArray(new String[0]);

        for (int i = 1; i <= deskStatus.size(); i++) {
            // TODO : String 의 2차원 배열을 만들어서, Stack 을 하나씩 확인해보면서 채운다.
        }
        for (int i = HEIGHT - 1; i >= 0; i--) {

        }

    }

    private void printStep(int requiredStep) {
        System.out.println("Step " + requiredStep);
    }
}
