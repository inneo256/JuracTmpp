package com.example.freelance.controller;

import com.example.freelance.memento.Portfolio;
import com.example.freelance.memento.PortfolioHistory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PortfolioController {

    private Portfolio portfolio = new Portfolio(
            "",
            "",
            "",
            ""
    );

    private PortfolioHistory history = new PortfolioHistory();

    @GetMapping("/portfolio")
    public String openPortfolio(Model model) {
        model.addAttribute("portfolio", portfolio);
        return "portfolio";
    }

    @PostMapping("/portfolio/save")
    public String savePortfolio(@RequestParam String description,
                                @RequestParam String skills,
                                @RequestParam String works,
                                @RequestParam String certificates,
                                Model model) {

        history.save(portfolio);

        portfolio.update(description, skills, works, certificates);

        model.addAttribute("portfolio", portfolio);
        model.addAttribute("message", "Портфолио сохранено. Предыдущая версия добавлена в историю.");

        return "portfolio";
    }

    @PostMapping("/portfolio/restore")
    public String restorePortfolio(Model model) {

        if (history.hasHistory()) {
            portfolio.setMemento(history.getLastMemento());
            model.addAttribute("message", "Предыдущая версия портфолио восстановлена.");
        } else {
            model.addAttribute("message", "Нет сохранённых версий для восстановления.");
        }

        model.addAttribute("portfolio", portfolio);
        return "portfolio";
    }
}