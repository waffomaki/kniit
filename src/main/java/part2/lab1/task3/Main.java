package part2.lab1.task3;

public class Main {
    public static void main(String[] args) {
        Thread producerThread = new Thread(new Producer(Constants.TOTAL_ITEMS_TO_PRODUCE));
        Thread consumerThread = new Thread(new Consumer(Constants.TOTAL_ITEMS_TO_PRODUCE));

        producerThread.start();
        consumerThread.start();
    }
}