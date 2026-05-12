package part2.lab2.command.entities;

import part2.lab2.command.commands.Command;

public class User {
    private Command updateCommand;

    public User(Command updateCommand) {
        this.updateCommand = updateCommand;
    }

    public void update() {
        updateCommand.execute();
    }
}
