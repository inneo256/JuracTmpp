package com.example.freelance.command;

public class CloseDisputeCommand implements AdminCommand {

    private final AdminActionService receiver;
    private final String disputeName;

    public CloseDisputeCommand(AdminActionService receiver, String disputeName) {
        this.receiver = receiver;
        this.disputeName = disputeName;
    }

    @Override
    public String execute() {
        return receiver.closeDispute(disputeName);
    }

    @Override
    public String undo() {
        return receiver.reopenDispute(disputeName);
    }
}