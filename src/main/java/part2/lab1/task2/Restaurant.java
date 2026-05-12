package part2.lab1.task2;

import java.util.LinkedList;
import java.util.Queue;

public class Restaurant {
    private static final Restaurant INSTANCE = new Restaurant();
    private Queue<String> tray = new LinkedList<>();

    private Restaurant() {}

    public static Restaurant getInstance() {
        return INSTANCE;
    }

    public synchronized void cookDish(String dishName) throws InterruptedException {
        while (tray.size() >= Constants.MAX_TRAY_SIZE) {
            wait();
        }
        tray.add(dishName);
        System.out.println("Повар приготовил: " + dishName + " (на подносе: " + tray.size() + ")");
        notify();
    }

    public synchronized void serveDish() throws InterruptedException {
        while (tray.isEmpty()) {
            wait();
        }
        String dish = tray.poll();
        System.out.println("Официант забрал: " + dish + " (на подносе: " + tray.size() + ")");
        notify();
    }
}