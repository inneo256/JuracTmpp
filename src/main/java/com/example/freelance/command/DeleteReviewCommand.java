package com.example.freelance.command;

public class DeleteReviewCommand implements AdminCommand {

    private final AdminActionService receiver;
    private final String reviewName;

    public DeleteReviewCommand(AdminActionService receiver, String reviewName) {
        this.receiver = receiver;
        this.reviewName = reviewName;
    }

    @Override
    public String execute() {
        return receiver.deleteReview(reviewName);
    }

    @Override
    public String undo() {
        return receiver.restoreReview(reviewName);
    }
}
