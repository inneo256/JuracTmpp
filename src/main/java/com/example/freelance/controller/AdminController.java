package com.example.freelance.controller;

import com.example.freelance.AbsractFact.ThemeFactory;
import com.example.freelance.Registry.SiteStats;
import com.example.freelance.command.*;
import com.example.freelance.composite.FreelancerCompositeService;
import com.example.freelance.composite.FreelancerGroup;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    private final FreelancerCompositeService freelancerCompositeService;
    private final AdminActionService receiver;
    private final AdminCommandInvoker invoker;

    public AdminController(FreelancerCompositeService freelancerCompositeService,
                           AdminActionService receiver,
                           AdminCommandInvoker invoker) {

        this.freelancerCompositeService = freelancerCompositeService;
        this.receiver = receiver;
        this.invoker = invoker;
    }

    @GetMapping("/admin-login")
    public String adminLoginPage() {
        return "admin_login";
    }

    @GetMapping("/admin")
    public String adminPage(Model model) {

        SiteStats stats = SiteStats.getInstance();

        FreelancerGroup root = freelancerCompositeService.buildTree();

        model.addAttribute("freelancerCount", stats.getFreelancerCount());
        model.addAttribute("clientCount", stats.getClientCount());
        model.addAttribute("orderCount", stats.getOrderCount());
        model.addAttribute("cloneCount", stats.getCloneCount());
        model.addAttribute("totalUsers", stats.getTotalUsers());

        model.addAttribute("pinkTheme",
                ThemeFactory.getFactory("pink").createTheme());

        model.addAttribute("darkTheme",
                ThemeFactory.getFactory("dark").createTheme());

        model.addAttribute("total", root.count());
        model.addAttribute("stats", root.countBySkill());
        model.addAttribute("treeText",
                freelancerCompositeService.buildTreeText());

        return "admin_dashboard";
    }

    @PostMapping("/admin/command")
    public String executeCommand(@RequestParam String commandType,
                                 @RequestParam String target,
                                 Model model) {

        AdminCommand command;

        switch (commandType) {

            case "blockUser":
                command = new BlockUserCommand(receiver, target);
                break;

            case "deleteProject":
                command = new DeleteProjectCommand(receiver, target);
                break;

            case "refundMoney":
                command = new RefundMoneyCommand(receiver, target);
                break;

            case "warnUser":
                command = new WarnUserCommand(receiver, target);
                break;

            case "deleteReview":
                command = new DeleteReviewCommand(receiver, target);
                break;

            case "closeDispute":
                command = new CloseDisputeCommand(receiver, target);
                break;

            case "verifyCompany":
                command = new VerifyCompanyCommand(receiver, target);
                break;

            default:
                model.addAttribute("commandMessage",
                        "Неизвестная команда");

                return adminPage(model);
        }

        String result = invoker.executeCommand(command);

        model.addAttribute("commandMessage", result);

        return adminPage(model);
    }

    @PostMapping("/admin/undo")
    public String undoCommand(Model model) {

        String result = invoker.undoLastCommand();

        model.addAttribute("commandMessage", result);

        return adminPage(model);
    }
}