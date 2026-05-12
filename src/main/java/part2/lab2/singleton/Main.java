package part2.lab2.singleton;

public class Main {
    public static void main(String[] args) {
        BusSchedule schedule = BusSchedule.getInstance(1000, "aaa123ddd", 30);
        System.out.println(schedule);
    }
}
