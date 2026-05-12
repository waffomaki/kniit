package part2.lab2.factory.schedule;

import part2.lab2.factory.transport.Transport;

public abstract class Schedule {
    public abstract Transport createTravel(int id);
}
