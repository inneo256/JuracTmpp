package com.example.freelance.command;

public class WarnUserCommand implements AdminCommand {

    private final AdminActionService receiver;
    private final String username;

    public WarnUserCommand(AdminActionService receiver, String username) {
        this.receiver = receiver;
        this.username = username;
    }

    @Override
    public String execute() {
        return receiver.warnUser(username);
    }

    @Override
    public String undo() {
        return receiver.removeWarning(username);
    }
}