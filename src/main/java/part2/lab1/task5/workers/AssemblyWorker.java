package part2.lab1.task5.workers;

import part2.lab1.task5.Conveyor;
import part2.lab1.task5.Part;
import part2.lab1.task5.core.Constants;
import part2.lab1.task5.core.PartStage;

import java.util.concurrent.BlockingQueue;

public class AssemblyWorker implements Runnable {
    private final Conveyor conveyor;

    public AssemblyWorker() {
        this.conveyor = Conveyor.getInstance();
    }

    @Override
    public void run() {
        BlockingQueue<Part> inputQueue = conveyor.getStampingToAssembly();
        BlockingQueue<Part> outputQueue = conveyor.getAssemblyToQC();

        try {
            while (true) {
                Part part = inputQueue.take();

                part.setStage(PartStage.ASSEMBLED);
                System.out.println("[Сборщик] Обработал: " + part);

                outputQueue.put(part);

                Thread.sleep(Constants.ASSEMBLER_DELAY_MS);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}