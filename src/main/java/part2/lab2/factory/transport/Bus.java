package part2.lab2.factory.transport;

public class Bus implements Transport {
    private final int id;
    private boolean isBusy = false;

    public Bus(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        isBusy = true;
        System.out.println("Bus №" + id + " has started its journey on the ground!");
    }
}
