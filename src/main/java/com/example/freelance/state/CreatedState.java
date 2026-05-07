package com.example.freelance.state;

public class CreatedState implements ProjectState {

    @Override
    public void next(ProjectContext context) {
        context.setState(new InProgressState());
    }

    @Override
    public void cancel(ProjectContext context) {
        context.setState(new CancelledState());
    }

    @Override
    public void dispute(ProjectContext context) {
        context.setState(new DisputeState());
    }

    @Override public boolean canClientEdit() { return true; }
    @Override public boolean canClientAccept() { return false; }
    @Override public boolean canClientDispute() { return false; }

    @Override public boolean canFreelancerSendPart() { return false; }
    @Override public boolean canFreelancerSendToReview() { return false; }

    @Override
    public String getName() {
        return "Создан";
    }
}