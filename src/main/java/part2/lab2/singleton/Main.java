package part2.lab2.singleton;

public class Main {
    public static void main(String[] args) {
        BusSchedule schedule = BusSchedule.getInstance(1000, "aaa123ddd", 30);
        BusSchedule schedule1 = BusSchedule.getInstance(2000, "asdasd", 20);

        System.out.println(schedule);
        System.out.println(schedule1);
        System.out.println(schedule == schedule1);
    }
}
