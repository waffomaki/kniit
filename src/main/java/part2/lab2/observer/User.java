package part2.lab2.observer;

public class User implements Observer {
    private String name;
    private int age;
    private int notifications = 0;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void update(String message) {
        System.out.println("Notification for " + this + ":\n" + message);
        notifications++;
    }

    public int getNotifications() {
        return this.notifications;
    }

    @Override
    public String toString() {
        return name + ", " + age;
    }
}
