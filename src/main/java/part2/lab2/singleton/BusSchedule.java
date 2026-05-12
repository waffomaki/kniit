package part2.lab2.singleton;

public class BusSchedule {
    private static volatile BusSchedule busSchedule;
    private int id;
    private String busNumber;
    private int minutesPeriod;

    private BusSchedule(int id, String busNumber, int minutesPeriod) {
        this.id = id;
        this.busNumber = busNumber;
        this.minutesPeriod = minutesPeriod;
    }

    public static BusSchedule getInstance(int id, String busNumber, int minutesPeriod) {
        if (busSchedule == null) {
            synchronized (BusSchedule.class) {
                // Если несколько потоков попали в метод и прошли проверку
                if (busSchedule == null) {
                    busSchedule = new BusSchedule(id, busNumber, minutesPeriod);
                }
            }
        }
        return busSchedule;
    }

    @Override
    public String toString() {
        return "Bus №" + id + ":\nNumber: " + busNumber + "\nPeriod (minutes): " + minutesPeriod;
    }
}
