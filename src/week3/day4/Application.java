package week3.day4;

public class Application {
    public static void main(String[] args) {
        Memory memory = new Memory();

        String base = memory.init(1024);
        System.out.println("Base Address : " + base);

        try {
            memory.setSize("short", 4);
            memory.setSize("int", 8);
            memory.setSize("String", 16);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


        try {
            String arrayPointer = memory.malloc("int", 4);
            System.out.println("arrayPointer : " + arrayPointer);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            String shortPointer = memory.malloc("short", 5);
            System.out.println("shortPointer : " + shortPointer);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }
}
