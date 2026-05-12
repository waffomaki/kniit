package part2.lab1.task4;

public class Main {
    public static void main(String[] args) {
        TrafficLight trafficLight = TrafficLight.getInstance();
        TrafficLightController controller = new TrafficLightController(trafficLight);

        Thread controllerThread = new Thread(controller);
        controllerThread.start();

        for (int i = 1; i <= Constants.NUM_CARS; i++) {
            Thread carThread = new Thread(new Car(i, trafficLight));
            carThread.start();

            try {
                Thread.sleep(Constants.CAR_ARRIVAL_INTERVAL_MS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        try {
            Thread.sleep(Constants.SWITCH_INTERVAL_MS * 4);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        controller.stop();
    }
}