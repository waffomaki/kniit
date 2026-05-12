package part2.lab2.factory.schedule;

import part2.lab2.factory.transport.Bus;
import part2.lab2.factory.transport.Transport;

public class GroundSchedule extends Schedule {
    @Override
    public Transport createTravel(int id) {
        return new Bus(id);
    }
}
