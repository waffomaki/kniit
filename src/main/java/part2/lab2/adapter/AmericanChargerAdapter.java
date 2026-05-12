package part2.lab2.adapter;

public class AmericanChargeAdapter implements EuropeanPlug {
    private AmericanCharger charger;

    public AmericanChargeAdapter(AmericanCharger charger) {
        this.charger = charger;
    }

    @Override
    public void connect() {
        System.out.println("Adapting...");
        charger.insertIntoUsOutlet();
    }
}
