package com.example.freelance.command;

public class DeleteProjectCommand implements AdminCommand {

    private final AdminActionService receiver;
    private final String projectName;

    public DeleteProjectCommand(AdminActionService receiver, String projectName) {
        this.receiver = receiver;
        this.projectName = projectName;
    }

    @Override
    public String execute() {
        return receiver.deleteProject(projectName);
    }

    @Override
    public String undo() {
        return receiver.restoreProject(projectName);
    }
}