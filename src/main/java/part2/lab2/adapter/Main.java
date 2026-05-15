package part2.lab2.adapter;

public class Main {
    public static void main(String[] args) {
        AmericanCharger americanCharger = new AmericanCharger();
        EuropeanPlug adapter = new AmericanChargerAdapter(americanCharger);

        EuropeanCharger europeanCharger = new EuropeanCharger();
        EuropeanOutlet europeanOutlet = new EuropeanOutlet();
        europeanOutlet.acceptPlug(europeanCharger);
        System.out.println();
        europeanOutlet.acceptPlug(adapter);
    }
}