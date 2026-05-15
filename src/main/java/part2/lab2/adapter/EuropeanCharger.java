package part2.lab2.adapter;

public class EuropeanCharger implements EuropeanPlug {
    @Override
    public void connect() {
        System.out.println("European charger is connected!");
    }
}
