package part2.lab2.adapter;

public class AmericanChargerAdapter implements EuropeanPlug {
    private AmericanCharger charger;

    public AmericanChargerAdapter(AmericanCharger charger) {
        this.charger = charger;
    }

    @Override
    public void connect() {
        System.out.println("Adapting...");
        charger.insertIntoUsOutlet();
    }
}
