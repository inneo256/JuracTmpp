package com.example.freelance.state;

public interface ProjectState {
    void next(ProjectContext context);
    void cancel(ProjectContext context);
    void dispute(ProjectContext context);

    boolean canClientEdit();
    boolean canClientAccept();
    boolean canClientDispute();

    boolean canFreelancerSendPart();
    boolean canFreelancerSendToReview();

    String getName();
}