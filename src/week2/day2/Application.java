package week2.day2;

public class Application {
    public static void main(String[] args) {
        InputHandler handler = new InputHandler();
        Stack stack = new Stack();

        String[] commandList = handler.getCommands();
        for (String command : commandList) {
            stack.stackManager(command);
        }
    }
}
