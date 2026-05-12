package part2.lab1.task4;

public class Car implements Runnable {
    private final int carNumber;
    private final TrafficLight trafficLight;

    public Car(int carNumber, TrafficLight trafficLight) {
        this.carNumber = carNumber;
        this.trafficLight = trafficLight;
    }

    @Override
    public void run() {
        try {
            System.out.println("Машина " + carNumber + " подъехала к перекрестку");
            trafficLight.waitForGreen();
            System.out.println("Машина " + carNumber + " проезжает перекресток");
            Thread.sleep(Constants.CAR_PASS_DELAY_MS);
            System.out.println("Машина " + carNumber + " проехала перекресток");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}