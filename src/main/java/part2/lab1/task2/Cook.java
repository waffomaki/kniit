package part2.lab1.task2;

public class Cook implements Runnable {
    private final String[] dishes;

    public Cook(String[] dishes) {
        this.dishes = dishes;
    }

    @Override
    public void run() {
        Restaurant restaurant = Restaurant.getInstance();
        try {
            for (String dish : dishes) {
                restaurant.cookDish(dish);
                Thread.sleep(Constants.COOK_DELAY_MS);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}