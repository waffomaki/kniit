package part2.lab2.observer;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class NotificationService {
    private static volatile NotificationService instance;
    private final List<Observer> subscribers = new CopyOnWriteArrayList<>();

    private NotificationService() {
        System.out.println("Notification service has started!");
    }

    public static NotificationService getInstance() {
        if (instance == null) {
            synchronized (NotificationService.class) {
                if (instance == null) {
                    instance = new NotificationService();
                }
            }
        }
        return instance;
    }

    public void follow(Observer observer) {
        subscribers.add(observer);
        System.out.println("New follower: " + observer);
    }

    public void unfollow(Observer observer) {
        subscribers.remove(observer);
        System.out.println("Unfollowed: " + observer);
    }

    public void sendNotification(String message) {
        for (Observer observer : subscribers) {
            observer.update(message);
        }
    }
}