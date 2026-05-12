package part2.lab1.task3;

public class Consumer implements Runnable {
    private final int itemsToConsume;

    public Consumer(int itemsToConsume) {
        this.itemsToConsume = itemsToConsume;
    }

    @Override
    public void run() {
        Storage storage = Storage.getInstance();
        try {
            for (int i = 0; i < itemsToConsume; i++) {
                storage.consume();
                Thread.sleep(Constants.CONSUMER_DELAY_MS);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}