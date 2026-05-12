package part2.lab1.task2;

public class Waiter implements Runnable {
    private final int dishesToServe;

    public Waiter(int dishesToServe) {
        this.dishesToServe = dishesToServe;
    }

    @Override
    public void run() {
        Restaurant restaurant = Restaurant.getInstance();
        try {
            for (int i = 0; i < dishesToServe; i++) {
                restaurant.serveDish();
                Thread.sleep(Constants.WAITER_DELAY_MS);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}