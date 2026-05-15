package part2.lab1.task6;

import java.io.IOException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        int numRunners = Constants.NUM_RUNNERS;

        CyclicBarrier barrier = new CyclicBarrier(numRunners, () -> {
            System.out.println("\nНачало гонки\n");
        });

        ExecutorService executor = Executors.newFixedThreadPool(numRunners);
        for (int i = 1; i <= numRunners; i++) {
            executor.submit(new Runner(i, barrier));
        }
        executor.shutdown();

        try {
            long timeoutSec = (Constants.MAX_RUN_TIME_MS / 1000) + 1;
            executor.awaitTermination(timeoutSec, TimeUnit.SECONDS);
            System.out.println("\nГонка завершена!");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}