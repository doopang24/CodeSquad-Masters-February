package week2.day4;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StackManager {

    private static Map<Integer, Stack<String>> deskStatus = new HashMap<>();
    private static Stack<String> desk1, desk2, desk3;

    StackManager() {
        desk1 = new Stack<>();
        desk2 = new Stack<>();
        desk3 = new Stack<>();

        desk1.push("COMPUTE");
        desk1.push("DISPLAY");
        desk1.push("DRV");

        deskStatus.put(1, desk1);
        deskStatus.put(2, desk2);
        deskStatus.put(3, desk3);
    }

    public Stack<String> getDesk(int deskNumber) {
        return deskStatus.getOrDefault(deskNumber, new Stack<>());
    }

    public void addPart(int deskNumber, String part) {
        deskStatus.get(deskNumber).push(part);
    }

    public String takeOutPart(int deskNumber) {
        return deskStatus.get(deskNumber).pop();
    }

    // 읽기 전용으로 반환
    public Map<Integer, Stack<String>> getDeskStatus() {
        return Collections.unmodifiableMap(deskStatus);
    }
}
