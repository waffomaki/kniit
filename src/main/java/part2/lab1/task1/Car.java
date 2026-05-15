package part2.lab1.task1;

public class Car implements Runnable {
    private final int id;
    private final GasStation station;

    public Car(int id, GasStation station) {
        this.id = id;
        this.station = station;
    }

    @Override
    public void run() {
        try {
            station.fuel(id);
            Thread.sleep(Constants.FUEL_TIME_MS);
            station.release(id);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
