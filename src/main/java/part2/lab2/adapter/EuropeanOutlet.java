package part2.lab2.adapter;

public class EuropeanOutlet {
    public void acceptPlug(EuropeanPlug plug) {
        System.out.println("European outlet is ready");
        plug.connect();
    }
}
