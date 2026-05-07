package com.example.freelance.controller;

import com.example.freelance.state.ProjectContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ProjectController {

    private ProjectContext project = new ProjectContext();

    @GetMapping("/client-project")
    public String clientProject(Model model) {
        model.addAttribute("project", project);
        return "client_project_workspace";
    }

    @GetMapping("/freelancer-project")
    public String freelancerProject(Model model) {
        model.addAttribute("project", project);
        return "freelancer_project_workspace";
    }

    @PostMapping("/project/save")
    public String saveProject(@RequestParam String projectTitle,
                              @RequestParam String description,
                              @RequestParam String advance,
                              @RequestParam String freelancerName) {

        if (project.canClientEdit()) {
            project.setProjectTitle(projectTitle);
            project.setDescription(description);
            project.setAdvance(advance);
            project.setFreelancerName(freelancerName);
            project.next();
        }

        return "redirect:/client-project";
    }

    @PostMapping("/project/send-part")
    public String sendPart(@RequestParam String projectPart) {

        if (project.canFreelancerSendPart()) {
            project.setProjectPart(projectPart);
        }

        return "redirect:/freelancer-project";
    }

    @PostMapping("/project/send-review")
    public String sendReview() {

        if (project.canFreelancerSendToReview()) {
            project.next();
        }

        return "redirect:/freelancer-project";
    }

    @PostMapping("/project/accept")
    public String acceptProject() {

        if (project.canClientAccept()) {
            project.next();
        }

        return "redirect:/client-project";
    }

    @PostMapping("/project/dispute")
    public String disputeProject() {
        project.dispute();
        return "redirect:/client-project";
    }

    @PostMapping("/project/cancel")
    public String cancelProject() {
        project.cancel();
        return "redirect:/client-project";
    }
}