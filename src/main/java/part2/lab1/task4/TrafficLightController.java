package part2.lab1.task4;

public class TrafficLightController implements Runnable {
    private final TrafficLight trafficLight;
    private volatile boolean running = true;

    public TrafficLightController(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    @Override
    public void run() {
        try {
            while (running) {
                trafficLight.turnGreen();
                Thread.sleep(Constants.SWITCH_INTERVAL_MS);

                trafficLight.turnRed();
                Thread.sleep(Constants.SWITCH_INTERVAL_MS);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void stop() {
        running = false;
    }
}