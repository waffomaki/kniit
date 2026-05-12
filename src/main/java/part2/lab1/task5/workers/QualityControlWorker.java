package part2.lab1.task5;

import java.util.concurrent.BlockingQueue;

public class QualityControlWorker implements Runnable {
    private final Conveyor conveyor;

    public QualityControlWorker() {
        this.conveyor = Conveyor.getInstance();
    }

    @Override
    public void run() {
        BlockingQueue<Part> inputQueue = conveyor.getAssemblyToQC();
        BlockingQueue<Part> outputQueue = conveyor.getQcToWarehouse();

        try {
            while (true) {
                Part part = inputQueue.take();

                part.setStage("Проверена ОК");
                System.out.println("Контроль качества: " + part);

                outputQueue.put(part);

                Thread.sleep(Constants.QC_DELAY_MS);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}