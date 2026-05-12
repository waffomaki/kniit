package part2.lab1.task5;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class WarehouseWorker implements Runnable {
    private final int expectedParts;
    private final Conveyor conveyor;
    private final AtomicInteger receivedParts = new AtomicInteger(0);

    public WarehouseWorker(int expectedParts) {
        this.expectedParts = expectedParts;
        this.conveyor = Conveyor.getInstance();
    }

    @Override
    public void run() {
        BlockingQueue<Part> inputQueue = conveyor.getQcToWarehouse();

        try {
            while (receivedParts.get() < expectedParts) {
                Part part = inputQueue.take();

                int count = receivedParts.incrementAndGet();
                System.out.println(">>> СКЛАД: Принята " + part + " (всего: " + count + "/" + expectedParts + ")");

                if (count >= expectedParts) {
                    break;
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("\n=== Все детали приняты на склад ===");
    }
}