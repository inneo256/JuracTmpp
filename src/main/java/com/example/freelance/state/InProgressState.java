package com.example.freelance.state;

public class InProgressState implements ProjectState {

    @Override
    public void next(ProjectContext context) {
        context.setState(new ReviewState());
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
    @Override public boolean canClientAccept() { return false; }
    @Override public boolean canClientDispute() { return true; }

    @Override public boolean canFreelancerSendPart() { return true; }
    @Override public boolean canFreelancerSendToReview() { return true; }

    @Override
    public String getName() {
        return "В работе";
    }
}