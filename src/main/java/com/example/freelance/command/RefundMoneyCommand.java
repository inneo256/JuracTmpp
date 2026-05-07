package com.example.freelance.command;

public class RefundMoneyCommand implements AdminCommand {

    private final AdminActionService receiver;
    private final String username;

    public RefundMoneyCommand(AdminActionService receiver, String username) {
        this.receiver = receiver;
        this.username = username;
    }

    @Override
    public String execute() {
        return receiver.refundMoney(username);
    }

    @Override
    public String undo() {
        return receiver.cancelRefund(username);
    }
}