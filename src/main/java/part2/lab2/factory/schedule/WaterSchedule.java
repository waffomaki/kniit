package part2.lab2.factory.schedule;

import part2.lab2.factory.transport.Ship;
import part2.lab2.factory.transport.Transport;

public class WaterSchedule extends Schedule {
    @Override
    public Transport createTravel(int id) {
        return new Ship(id);
    }
}
