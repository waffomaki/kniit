package part2.lab2.adapter;

public class Main {
    public static void main(String[] args) {
        AmericanCharger americanCharger = new AmericanCharger();
        EuropeanPlug adapter = new AmericanChargeAdapter(americanCharger);
        EuropeanOutlet europeanOutlet = new EuropeanOutlet();
        europeanOutlet.acceptPlug(adapter);
    }
}