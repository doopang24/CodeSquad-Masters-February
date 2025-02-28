package week4.day4;

public class Application {
    public static void main(String[] args) {
        DateReceiver receiver = new DateReceiver();
        ProgressBar bar = new ProgressBar();
        MartianCalendar calendar = new MartianCalendar();

        int[] inputDate = new int[3];
        try {
            inputDate = receiver.getInput();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        Thread progressThread = new Thread(() -> bar.printProgressBar());
        progressThread.start();

//        try {
//            progressThread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        bar.printProgressBar();

        calendar.startConvert(inputDate);
    }
}
