package com.example.freelance.controller;
import com.example.freelance.Registry.SiteStats;
import com.example.freelance.*;
import com.example.freelance.AbsractFact.Theme;
import com.example.freelance.AbsractFact.ThemeFactory;
import com.example.freelance.composite.FreelancerCompositeService;
import com.example.freelance.facade.AuthFacade;
import com.example.freelance.prot.PostRegistry;
import com.example.freelance.strategy.PostSortContext;
import com.example.freelance.strategy.SortByBudgetStrategy;
import com.example.freelance.strategy.SortByTitleStrategy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.freelance.adapter.*;
@Controller
public class AuthController {
    private final AuthFacade authFacade;
    private final AuthService authService;
    private final FreelancerCompositeService freelancerCompositeService;


    public AuthController(AuthFacade authFacade,
                          AuthService authService,
                          FreelancerCompositeService freelancerCompositeService) {
        this.authFacade = authFacade;
        this.authService = authService;
        this.freelancerCompositeService = freelancerCompositeService;
    }

    @GetMapping("/auth")
    public String authPage() {
        return "auth";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam(required = false) String name,
                               @RequestParam(required = false) String password,
                               @RequestParam(required = false) String type,
                               Model model) {


        boolean success = authService.register(name, password, type);

        UserCreator creator;


        if (type.equalsIgnoreCase("freelancer")) {
            creator = new FreelancerCreator();
            SiteStats.getInstance().addFreelancer();
        } else if (type.equalsIgnoreCase("client")) {
            creator = new ClientCreator();
            SiteStats.getInstance().addClient();
        } else throw new IllegalArgumentException("Unknown type: " + type);


        Theme pinkTheme = ThemeFactory.getFactory("pink").createTheme();
        Theme darkTheme = ThemeFactory.getFactory("dark").createTheme();

        model.addAttribute("name", name);
        model.addAttribute("pinkTheme", pinkTheme);
        model.addAttribute("darkTheme", darkTheme);
        model.addAttribute("posts", PostRegistry.getAllPosts()); // ← посты из реестра

        return creator.createDashboard(name);
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String name,
                            @RequestParam String password,
                            Model model) {
        return authFacade.handleLogin(name, password, model);
    }


    @PostMapping("/update-skill")
    public String updateSkill(@RequestParam String name,
                              @RequestParam String skillType,
                              Model model) {

        authService.updateSkillType(name, skillType);

        // возвращаем обратно в кабинет
        Theme pinkTheme = ThemeFactory.getFactory("pink").createTheme();
        Theme darkTheme = ThemeFactory.getFactory("dark").createTheme();

        model.addAttribute("name", name);
        model.addAttribute("pinkTheme", pinkTheme);
        model.addAttribute("darkTheme", darkTheme);
        model.addAttribute("posts", PostRegistry.getAllPosts());
        model.addAttribute("requests", authService.getRequestsForFreelancer(name));

        return "freelancer_dashboard";
    }

    @GetMapping("/client/specialists")
    public String showFreelancers(@RequestParam String name, Model model) {
        model.addAttribute("clientName", name);
        model.addAttribute("groupedSpecialists",
                freelancerCompositeService.getGroupedSpecialistsForClient(name));
        return "specialists";
    }

    @PostMapping("/update-contacts")
    public String updateContacts(@RequestParam String name,
                                 @RequestParam String email,
                                 @RequestParam String telegram,
                                 Model model) {

        authService.updateContacts(name, email, telegram);

        Theme pinkTheme = ThemeFactory.getFactory("pink").createTheme();
        Theme darkTheme = ThemeFactory.getFactory("dark").createTheme();

        model.addAttribute("name", name);
        model.addAttribute("pinkTheme", pinkTheme);
        model.addAttribute("darkTheme", darkTheme);
        model.addAttribute("posts", PostRegistry.getAllPosts());
        model.addAttribute("requests", authService.getRequestsForFreelancer(name));

        return "freelancer_dashboard";
    }

    @PostMapping("/send-request")
    public String sendRequest(@RequestParam String clientName,
                              @RequestParam String freelancerName,
                              Model model) {

        authService.sendRequest(clientName, freelancerName);

        model.addAttribute("clientName", clientName);
        model.addAttribute("groupedSpecialists",
                freelancerCompositeService.getGroupedSpecialistsForClient(clientName));

        return "specialists";
    }

    @PostMapping("/approve-request")
    public String approveRequest(@RequestParam Long requestId,
                                 @RequestParam String name,
                                 Model model) {

        authService.approveRequest(requestId);

        Theme pinkTheme = ThemeFactory.getFactory("pink").createTheme();
        Theme darkTheme = ThemeFactory.getFactory("dark").createTheme();

        model.addAttribute("name", name);
        model.addAttribute("pinkTheme", pinkTheme);
        model.addAttribute("darkTheme", darkTheme);
        model.addAttribute("posts", PostRegistry.getAllPosts());
        model.addAttribute("requests", authService.getRequestsForFreelancer(name));

        return "freelancer_dashboard";
    }

    @GetMapping("/payment-page")
    public String paymentPage() {
        return "payment";
    }

    @PostMapping("/pay")
    public String pay(@RequestParam String paymentSystem, Model model) {

        Payment payment;
        double amount = 100.0;

        if (paymentSystem.equalsIgnoreCase("paypal")) {
            payment = new PayPalAdapter(new PayPalService());
        } else if (paymentSystem.equalsIgnoreCase("stripe")) {
            payment = new StripeAdapter(new StripeService());
        } else if (paymentSystem.equalsIgnoreCase("card")) {
            payment = new CardAdapter(new CardService());
        } else if (paymentSystem.equalsIgnoreCase("crypto")) {
            payment = new CryptoAdapter(new CryptoService());
        } else {
            model.addAttribute("message", "Неизвестный способ оплаты");
            return "payment_result";
        }

        String result = payment.pay(amount);
        model.addAttribute("message", result);

        return "payment_result";
    }

    @GetMapping("/client-dashboard")
    public String clientDashboard(@RequestParam String name, Model model) {
        Theme pinkTheme = ThemeFactory.getFactory("pink").createTheme();
        Theme darkTheme = ThemeFactory.getFactory("dark").createTheme();

        model.addAttribute("name", name);
        model.addAttribute("pinkTheme", pinkTheme);
        model.addAttribute("darkTheme", darkTheme);
        model.addAttribute("posts", PostRegistry.getAllPosts());

        return "client_dashboard";
    }

    @GetMapping("/freelancer-dashboard")
    public String freelancerDashboard(@RequestParam String name,
                                      @RequestParam(required = false) String sort,
                                      Model model) {
        Theme pinkTheme = ThemeFactory.getFactory("pink").createTheme();
        Theme darkTheme = ThemeFactory.getFactory("dark").createTheme();

        var posts = PostRegistry.getAllPosts();

        if (sort != null && !sort.isEmpty()) {
            PostSortContext context = new PostSortContext();

            if (sort.equals("budget")) {
                context.setStrategy(new SortByBudgetStrategy());
                posts = context.execute(posts);
            }

            if (sort.equals("title")) {
                context.setStrategy(new SortByTitleStrategy());
                posts = context.execute(posts);
            }
        }

        model.addAttribute("name", name);
        model.addAttribute("pinkTheme", pinkTheme);
        model.addAttribute("darkTheme", darkTheme);
        model.addAttribute("posts", posts);
        model.addAttribute("requests", authService.getRequestsForFreelancer(name));
        model.addAttribute("selectedSort", sort);

        return "freelancer_dashboard";
    }
}