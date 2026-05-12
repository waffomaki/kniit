package part2.lab2.command;

import part2.lab2.command.commands.Command;
import part2.lab2.command.commands.update.CommentUpdateCommand;
import part2.lab2.command.commands.update.PostUpdateCommand;
import part2.lab2.command.commands.update.UserUpdateCommand;
import part2.lab2.command.entities.Comment;
import part2.lab2.command.entities.Post;
import part2.lab2.command.entities.User;

public class Main {
    public static void main(String[] args) {
        Command userUpdateCommand = new UserUpdateCommand();
        Command postUpdateCommand = new PostUpdateCommand();
        Command commentUpdateCommand = new CommentUpdateCommand();

        User user = new User(userUpdateCommand);
        Post post = new Post(postUpdateCommand);
        Comment comment = new Comment(commentUpdateCommand);

        user.update();
        post.update();
        comment.update();
    }
}
