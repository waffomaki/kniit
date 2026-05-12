package part2.lab1.task1;

public class GasStation {
    private final Object lock = new Object();
    private int pumps = Constants.TOTAL_PUMPS;

    public void fuel(int carID) throws InterruptedException {
        synchronized (lock) {
            while (pumps == 0) {
                lock.wait();
            }
            pumps--;
            System.out.println(carID + " заправляется...");
        }
    }

    public void release(int carID) {
        synchronized (lock) {
            pumps++;
            System.out.println(carID + " заправлена!");
            lock.notify();
        }
    }
}
