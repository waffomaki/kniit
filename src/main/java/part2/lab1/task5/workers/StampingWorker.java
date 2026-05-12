package part2.lab1.task5;

import java.util.concurrent.BlockingQueue;

public class StampingWorker implements Runnable {
    private final int partsToProduce;
    private final Conveyor conveyor;

    public StampingWorker(int partsToProduce) {
        this.partsToProduce = partsToProduce;
        this.conveyor = Conveyor.getInstance();
    }

    @Override
    public void run() {
        BlockingQueue<Part> queue = conveyor.getStampingToAssembly();
        try {
            for (int i = 1; i <= partsToProduce; i++) {
                Part part = new Part(i);
                part.setStage("Заготовка");

                queue.put(part);
                System.out.println("Штамповщик создал: " + part);

                Thread.sleep(Constants.STAMPER_DELAY_MS);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}