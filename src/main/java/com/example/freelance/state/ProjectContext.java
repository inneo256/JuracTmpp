package com.example.freelance.state;

public class ProjectContext {

    private ProjectState state = new CreatedState();

    private String projectTitle = "";
    private String description = "";
    private String advance = "";
    private String freelancerName = "";
    private String projectPart = "";

    public void next() {
        state.next(this);
    }

    public void cancel() {
        state.cancel(this);
    }

    public void dispute() {
        state.dispute(this);
    }

    public void setState(ProjectState state) {
        this.state = state;
    }

    public String getStateName() {
        return state.getName();
    }

    public boolean canClientEdit() {
        return state.canClientEdit();
    }

    public boolean canClientAccept() {
        return state.canClientAccept();
    }

    public boolean canClientDispute() {
        return state.canClientDispute();
    }

    public boolean canFreelancerSendPart() {
        return state.canFreelancerSendPart();
    }

    public boolean canFreelancerSendToReview() {
        return state.canFreelancerSendToReview();
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdvance() {
        return advance;
    }

    public void setAdvance(String advance) {
        this.advance = advance;
    }

    public String getFreelancerName() {
        return freelancerName;
    }

    public void setFreelancerName(String freelancerName) {
        this.freelancerName = freelancerName;
    }

    public String getProjectPart() {
        return projectPart;
    }

    public void setProjectPart(String projectPart) {
        this.projectPart = projectPart;
    }
}