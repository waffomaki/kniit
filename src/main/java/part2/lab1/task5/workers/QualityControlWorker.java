package part2.lab1.task5.workers;

import part2.lab1.task5.Conveyor;
import part2.lab1.task5.Part;
import part2.lab1.task5.core.Constants;
import part2.lab1.task5.core.PartStage;

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

                part.setStage(PartStage.QC_PASSED);
                System.out.println("[Оператор контроля качества]: " + part);

                outputQueue.put(part);

                Thread.sleep(Constants.QC_DELAY_MS);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}