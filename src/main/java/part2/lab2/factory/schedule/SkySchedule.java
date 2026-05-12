package part2.lab2.factory.schedule;

import part2.lab2.factory.transport.Transport;
import part2.lab2.factory.transport.Plane;

public class SkySchedule extends Schedule {
    @Override
    public Transport createTravel(int id) {
        return new Plane(id);
    }
}
