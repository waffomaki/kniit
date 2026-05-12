package part2.lab2.factory.transport;

public class Ship implements Transport {
    private final int id;
    private boolean isBusy = false;

    public Ship(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        isBusy = true;
        System.out.println("Ship №" + id + " has started its journey on the water!");
    }
}
