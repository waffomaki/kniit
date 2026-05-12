package part2.lab1.task1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GasStation station = new GasStation();
        List<Thread> cars = new ArrayList<>();

        int n = Constants.TOTAL_CARS;
        for (int i=1; i<=n; i++) {
            Thread car = new Thread(new Car(i, station));
            cars.add(car);
            car.start();
        }

        for (Thread car : cars) {
            car.join();
        }
    }
}
