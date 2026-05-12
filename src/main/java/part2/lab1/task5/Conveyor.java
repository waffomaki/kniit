package part2.lab1.task5;

import part2.lab1.task5.core.Constants;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Conveyor {
    private static final Conveyor INSTANCE = new Conveyor();

    private final BlockingQueue<Part> stampingToAssembly;
    private final BlockingQueue<Part> assemblyToQC;
    private final BlockingQueue<Part> qcToWarehouse;

    private Conveyor() {
        this.stampingToAssembly = new LinkedBlockingQueue<>(Constants.QUEUE_CAPACITY);
        this.assemblyToQC = new LinkedBlockingQueue<>(Constants.QUEUE_CAPACITY);
        this.qcToWarehouse = new LinkedBlockingQueue<>(Constants.QUEUE_CAPACITY);
    }

    public static Conveyor getInstance() {
        return INSTANCE;
    }

    public BlockingQueue<Part> getStampingToAssembly() {
        return stampingToAssembly;
    }

    public BlockingQueue<Part> getAssemblyToQC() {
        return assemblyToQC;
    }

    public BlockingQueue<Part> getQcToWarehouse() {
        return qcToWarehouse;
    }
}