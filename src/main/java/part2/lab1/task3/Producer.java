package part2.lab1.task3;

public class Producer implements Runnable {
    private final int itemsToProduce;

    public Producer(int itemsToProduce) {
        this.itemsToProduce = itemsToProduce;
    }

    @Override
    public void run() {
        Storage storage = Storage.getInstance();
        try {
            for (int i = 1; i <= itemsToProduce; i++) {
                storage.produce(i);
                Thread.sleep(Constants.PRODUCER_DELAY_MS);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}