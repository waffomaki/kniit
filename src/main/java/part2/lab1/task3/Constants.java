package part2.lab1.task3;

public final class Constants {
    public static final int MAX_ITEMS = 5;
    public static final int TOTAL_ITEMS_TO_PRODUCE = 12;
    public static final int PRODUCER_DELAY_MS = 300;
    public static final int CONSUMER_DELAY_MS = 500;

    private Constants() {
        throw new UnsupportedOperationException("Isn't allowed");
    }
}