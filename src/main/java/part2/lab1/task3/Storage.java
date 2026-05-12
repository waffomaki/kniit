package part2.lab1.task3;

import java.util.LinkedList;
import java.util.Queue;

public class Storage {
    private static final Storage INSTANCE = new Storage();
    private final Queue<Integer> items = new LinkedList<>();

    private Storage() {}

    public static Storage getInstance() {
        return INSTANCE;
    }

    public synchronized void produce(int item) throws InterruptedException {
        while (items.size() >= Constants.MAX_ITEMS) {
            wait();
        }

        items.add(item);
        System.out.println("Производитель создал товар: " + item + " (На складе: " + items.size() + ")");
        notify();
    }

    public synchronized void consume() throws InterruptedException {
        while (items.isEmpty()) {
            wait();
        }

        int item = items.poll();
        System.out.println("Потребитель забрал товар: " + item + " (На складе: " + items.size() + ")");
        notify();
    }
}