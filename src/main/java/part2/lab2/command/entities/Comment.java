package part2.lab2.command.entities;

import part2.lab2.command.commands.Command;

public class Comment {
    private Command updateCommand;

    public Comment(Command updateCommand) {
        this.updateCommand = updateCommand;
    }

    public void update() {
        updateCommand.execute();
    }
}
