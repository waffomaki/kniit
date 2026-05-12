package part2.lab2.command.commands.update;

import part2.lab2.command.commands.Command;

public class UserUpdateCommand implements Command {
    @Override
    public void execute() {
        // some logic here
        System.out.println("User has been updated!");
    }
}
