package com.example.freelance.state;

public class CancelledState implements ProjectState {

    @Override public void next(ProjectContext context) { }
    @Override public void cancel(ProjectContext context) { }
    @Override public void dispute(ProjectContext context) { }

    @Override public boolean canClientEdit() { return false; }
    @Override public boolean canClientAccept() { return false; }
    @Override public boolean canClientDispute() { return false; }

    @Override public boolean canFreelancerSendPart() { return false; }
    @Override public boolean canFreelancerSendToReview() { return false; }

    @Override
    public String getName() {
        return "Отменён";
    }
}