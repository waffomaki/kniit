package part2.lab2.command.commands.update;

import part2.lab2.command.commands.Command;

public class CommentUpdateCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Comment has been updated!");
    }
}
