package part2.lab2.adapter;

public class EuropeanOutlet {
    public void acceptPlug(EuropeanPlug plug) {
        System.out.println("Got the plug...");
        plug.connect();
        System.out.println("Got an european plug!");
    }
}
