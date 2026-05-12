package part2.lab2.factory.transport;

public class Plane implements Transport {
    private final int id;
    private boolean isBusy = false;

    public Plane(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        isBusy = true;
        System.out.println("Plane №" + id + " has started its journey at the sky!");
    }
}
