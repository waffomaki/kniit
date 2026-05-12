package part2.lab1.task2;

public class Main {
    public static void main(String[] args) {
        int totalDishes = Constants.TOTAL_DISHES;

        String[] menu = new String[totalDishes];
        for (int i = 0; i < totalDishes; i++) {
            menu[i] = "Блюдо " + (i + 1);
        }

        Thread cookThread = new Thread(new Cook(menu));
        Thread waiterThread = new Thread(new Waiter(menu.length));

        cookThread.start();
        waiterThread.start();
    }
}