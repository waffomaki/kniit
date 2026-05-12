package part2.lab2.observer;

import java.util.ArrayList;
import java.util.List;

public class Post {
    private static List<Post> postList = new ArrayList<>();
    private int id;
    private String text;

    private Post(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public static void createPost(int id, String text) {
        Post post = new Post(id, text);
        postList.add(post);
        String msg = "New post №" + id + "!\n" + text;
        NotificationService.getInstance().sendNotification(msg);
    }

    public static List<Post> getPostList() {
        return postList;
    }

    @Override
    public String toString() {
        return "Post №" + id + ":\n" + text + '\n';
    }
}
