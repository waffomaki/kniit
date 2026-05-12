package part2.lab2.observer;

public class Main {
    public static void main(String[] args) {
        NotificationService service = NotificationService.getInstance();

        User user1 = new User("Alex", 18);
        User user2 = new User("Jane", 22);
        User user3 = new User("Mike", 30);
        User user4 = new User("Nick", 21);
        User user5 = new User("Max", 23);

        service.follow(user1);
        service.follow(user3);
        service.follow(user5);

        Post.createPost(1, "First post.");
        Post.createPost(2, "Second post.");
        Post.createPost(3, "Third post.");

        service.unfollow(user3);
        service.unfollow(user5);

        Post.createPost(4, "Fourth post.");
    }
}
