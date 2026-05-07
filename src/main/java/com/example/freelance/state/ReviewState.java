package com.example.freelance.state;

public class ReviewState implements ProjectState {

    @Override
    public void next(ProjectContext context) {
        context.setState(new CompletedState());
    }

    @Override
    public void cancel(ProjectContext context) {
        context.setState(new CancelledState());
    }

    @Override
    public void dispute(ProjectContext context) {
        context.setState(new DisputeState());
    }

    @Override public boolean canClientEdit() { return false; }
    @Override public boolean canClientAccept() { return true; }
    @Override public boolean canClientDispute() { return true; }

    @Override public boolean canFreelancerSendPart() { return false; }
    @Override public boolean canFreelancerSendToReview() { return false; }

    @Override
    public String getName() {
        return "На проверке";
    }
}