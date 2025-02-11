package week2.day2;

public class Stack {

    private static final int STACK_SIZE = 8;
    private static Integer[] stack;
    private static Integer registerA, registerB;

    // 배열의 각 요소를 null 로 초기화
    public Stack() {
        stack = new Integer[STACK_SIZE];
        for (int i = 0; i < STACK_SIZE; i++) stack[i] = null;
    }

    public void stackManager(String command) {
        switch (command) {
            case "POPA":
                POPA();
                break;
            case "POPB":
                POPB();
                break;
            case "ADD":
                ADD();
                break;
            case "SUB":
                SUB();
                break;
            case "PUSH0":
                PUSH0();
                break;
            case "PUSH1":
                PUSH1();
                break;
            case "PUSH2":
                PUSH2();
                break;
            case "PUSH3":
                PUSH3();
                break;
            case "SWAP":
                SWAP();
                break;
            case "PRINT":
                PRINT();
                break;
            default:
                System.out.println("UNKNOWN");
        }
    }

    // stack 배열에 남은 공간이 있는지 확인하는 함수
    private boolean isAvailable() {
        if (stack[STACK_SIZE - 1] == null) return true;    // 배열의 마지막이 비었으면 true 반환
        System.out.println("OVERFLOW");
        return false;
    }

    // POP 기능
    private int pop() {
        int lastIn; // 가장 마지막에 들어온 원소
        for (int i = STACK_SIZE - 1; i >= 0; i--) {
            if (stack[i] != null) {
                lastIn = stack[i];
                stack[i] = null;
                return lastIn;
            }
        }
        System.out.println("EMPTY");
        return -1;  // 오류 처리
    }

    // PUSH 기능
    private void push(int input) {
        for (int i = 0; i < STACK_SIZE; i++) {
            if (stack[i] == null) {
                stack[i] = input;
                return;
            }
        }
    }

    private void POPA() {
        int value = pop();
        if (value != -1) {
            registerA = value;
        }
    }

    private void POPB() {
        int value = pop();
        if (value != -1) {
            registerB = value;
        }
    }

    private void PRINT() {
        int value = pop();
        if (value != -1) {
            System.out.println(value);
        }
    }

    private void ADD() {
        try {
            int input = registerA + registerB;
            if (isAvailable()) {
                push(input);
            }
        } catch (NullPointerException e) {
            System.out.println("ERROR");
        }
    }

    private void SUB() {
        try {
            int input = registerA - registerB;
            if (isAvailable()) {
                push(input);
            }
        } catch (NullPointerException e) {
            System.out.println("ERROR");
        }
    }

    private void PUSH0() {
        if (isAvailable()) {
            push(0);
        }
    }

    private void PUSH1() {
        if (isAvailable()) {
            push(1);
        }
    }

    private void PUSH2() {
        if (isAvailable()) {
            push(2);
        }
    }

    private void PUSH3() {
        if (isAvailable()) {
            push(3);
        }
    }

    private void SWAP() {
        try {
            int tmp = registerA;
            registerA = registerB;
            registerB = tmp;
        } catch (NullPointerException e) {
            System.out.println("ERROR");
        }
    }
}
