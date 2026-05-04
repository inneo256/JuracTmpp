package com.example.freelance.facade;

import com.example.freelance.*;
import com.example.freelance.AbsractFact.Theme;
import com.example.freelance.AbsractFact.ThemeFactory;
import com.example.freelance.model.UserEntity;
import com.example.freelance.prot.PostRegistry;
import com.example.freelance.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
public class AuthFacade {

    private final UserRepository userRepository;
    private final AuthService authService;
    public AuthFacade(UserRepository userRepository, AuthService authService) {
        this.userRepository = userRepository;
        this.authService = authService;
    }


    public String handleLogin(String name, String password, Model model) {
        UserEntity user = userRepository.findByUsername(name).orElse(null);

        if (user == null) {
            model.addAttribute("error", "Пользователь не найден");
            return "auth";
        }

        if (!user.getPassword().equals(password)) {
            model.addAttribute("error", "Неверный пароль");
            return "auth";
        }

        UserCreator creator = getCreatorByType(user.getRole());
        prepareDashboardModel(user.getUsername(), model);

        return creator.createDashboard(user.getUsername());
    }

    private UserCreator getCreatorByType(String type) {
        if (type.equalsIgnoreCase("freelancer")) {
            return new FreelancerCreator();
        } else if (type.equalsIgnoreCase("client")) {
            return new ClientCreator();
        }

        throw new IllegalArgumentException("Unknown type: " + type);
    }

    private void prepareDashboardModel(String name, Model model) {
        model.addAttribute("requests", authService.getRequestsForFreelancer(name));

        Theme pinkTheme = ThemeFactory.getFactory("pink").createTheme();
        Theme darkTheme = ThemeFactory.getFactory("dark").createTheme();

        model.addAttribute("name", name);
        model.addAttribute("pinkTheme", pinkTheme);
        model.addAttribute("darkTheme", darkTheme);
        model.addAttribute("posts", PostRegistry.getAllPosts());
    }
}