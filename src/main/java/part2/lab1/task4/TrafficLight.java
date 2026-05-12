package part2.lab1.task4;

public class TrafficLight {
    private static final TrafficLight INSTANCE = new TrafficLight();
    private LightState currentState = LightState.RED;

    private TrafficLight() {}

    public static TrafficLight getInstance() {
        return INSTANCE;
    }

    public synchronized void turnGreen() {
        currentState = LightState.GREEN;
        System.out.println("Зеленый свет!");
        notifyAll();
    }

    public synchronized void turnRed() {
        currentState = LightState.RED;
        System.out.println("Красный свет!");
    }

    public synchronized void waitForGreen() throws InterruptedException {
        while (currentState != LightState.GREEN) {
            wait();
        }
    }
}