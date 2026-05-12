package part2.lab2.factory;

import part2.lab2.factory.schedule.GroundSchedule;
import part2.lab2.factory.schedule.Schedule;
import part2.lab2.factory.schedule.SkySchedule;
import part2.lab2.factory.schedule.WaterSchedule;
import part2.lab2.factory.transport.Transport;

public class Main {
    public static void main(String[] args) {
        Schedule waterSchedule = new WaterSchedule();
        Schedule skySchedule = new SkySchedule();
        Schedule groundSchedule = new GroundSchedule();

        Transport[] fleet = {
                waterSchedule.createTravel(102),
                skySchedule.createTravel(203),
                groundSchedule.createTravel(304)
        };

        System.out.println("\nSchedule:");
        for (Transport t : fleet) {
            t.run();
        }
    }
}