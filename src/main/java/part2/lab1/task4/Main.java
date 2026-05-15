package part2.lab1.task4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TrafficLight trafficLight = TrafficLight.getInstance();
        TrafficLightController controller = new TrafficLightController(trafficLight);

        Thread controllerThread = new Thread(controller);
        controllerThread.start();

        List<Thread> carThreads = new ArrayList<>();
        for (int i = 1; i <= Constants.NUM_CARS; i++) {
            Thread carThread = new Thread(new Car(i, trafficLight));
            carThreads.add(carThread);
            carThread.start();

            try {
                Thread.sleep(Constants.CAR_ARRIVAL_INTERVAL_MS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        for (Thread carThread : carThreads) {
            try {
                carThread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        controller.stop();
    }
}