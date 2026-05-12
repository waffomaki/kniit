package part2.lab1.task6;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadLocalRandom;

public class Runner implements Runnable {
    private final int runnerNumber;
    private final CyclicBarrier barrier;

    public Runner(int runnerNumber, CyclicBarrier barrier) {
        this.runnerNumber = runnerNumber;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println("Бегун №" + runnerNumber + " готовится");

            barrier.await();

            System.out.println("Бегун №" + runnerNumber + " начал забег");

            int runTime = ThreadLocalRandom.current()
                    .nextInt(Constants.MIN_RUN_TIME_MS, Constants.MAX_RUN_TIME_MS);
            Thread.sleep(runTime);

            System.out.println("Бегун №" + runnerNumber + " финишировал за " + runTime + " мс");

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (BrokenBarrierException e) {
            return;
        }
    }
}