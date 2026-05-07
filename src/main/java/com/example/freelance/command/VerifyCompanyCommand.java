package com.example.freelance.command;

public class VerifyCompanyCommand implements AdminCommand {

    private final AdminActionService receiver;
    private final String companyName;

    public VerifyCompanyCommand(AdminActionService receiver, String companyName) {
        this.receiver = receiver;
        this.companyName = companyName;
    }

    @Override
    public String execute() {
        return receiver.verifyCompany(companyName);
    }

    @Override
    public String undo() {
        return receiver.removeCompanyVerification(companyName);
    }
}