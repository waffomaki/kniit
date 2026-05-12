package part2.lab1.task5;

import part2.lab1.task5.core.Constants;
import part2.lab1.task5.workers.AssemblyWorker;
import part2.lab1.task5.workers.QualityControlWorker;
import part2.lab1.task5.workers.StampingWorker;
import part2.lab1.task5.workers.WarehouseWorker;

public class Main {
    public static void main(String[] args) {
        Conveyor conveyor = Conveyor.getInstance();

        Thread stamper = new Thread(new StampingWorker(Constants.TOTAL_PARTS));
        Thread assembler = new Thread(new AssemblyWorker());
        Thread qc = new Thread(new QualityControlWorker());
        Thread warehouse = new Thread(new WarehouseWorker(Constants.TOTAL_PARTS));

        warehouse.start();
        qc.start();
        assembler.start();
        stamper.start();
    }
}