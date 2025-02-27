package week4.day4;

public class Application {
    public static void main(String[] args) {
        DateReceiver receiver = new DateReceiver();
        DateUtils utils = new DateUtils();
        ProcessBar bar = new ProcessBar();
        MartianCalendar calendar = new MartianCalendar();

        int[] inputDate = new int[3];

        try {
            inputDate = receiver.getInput();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        bar.printProcessBar();

        long totalDays = utils.countDays(inputDate);
        int[] martianDate = utils.convertMartian(totalDays);
    }
}
