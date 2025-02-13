package week2.day4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Printer {

    private static final String BLANK = "          ";
    private static final String DESK1 = "1======== ";
    private static final String DESK2 = "2======== ";
    private static final String DESK3 = "3======== ";
    private static List<String> drv = new ArrayList<>();
    private static List<String> display = new ArrayList<>();
    private static List<String> compute = new ArrayList<>();

    public Printer() {
        setDrv();
        setDisplay();
        setCompute();
    }

    private void setDrv() {
        drv.add("    [DRV]");
        drv.add("+-------+");
    }

    private void setDisplay() {
        display.add("|       |");
        display.add("|DISPLAY|");
        display.add("|       |");
    }

    private void setCompute() {
        compute.add("+-------+");
        compute.add("+-------+");
        compute.add("|COMPUTE|");
        compute.add("+-------+");
    }

    public void printController(Map<Integer, Stack<String>> deskStatus, int requiredStep) {
        printStep(requiredStep);
    }

    private void printStep(int requiredStep) {
        System.out.println("Step " + requiredStep);
    }
}
