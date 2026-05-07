package com.example.freelance.command;

public class BlockUserCommand implements AdminCommand {

    private final AdminActionService receiver;
    private final String username;

    public BlockUserCommand(AdminActionService receiver, String username) {
        this.receiver = receiver;
        this.username = username;
    }

    @Override
    public String execute() {
        return receiver.blockUser(username);
    }

    @Override
    public String undo() {
        return receiver.unblockUser(username);
    }
}