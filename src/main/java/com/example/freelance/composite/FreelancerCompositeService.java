package com.example.freelance.composite;

import com.example.freelance.AuthService;
import com.example.freelance.UserRepository;
import com.example.freelance.model.SpecialistCardData;
import com.example.freelance.model.UserEntity;
import com.example.freelance.proxy.FreelancerContactAccess;
import com.example.freelance.proxy.FreelancerContactProxy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class FreelancerCompositeService {

    private final UserRepository userRepository;
    private final AuthService authService;

    public FreelancerCompositeService(UserRepository userRepository, AuthService authService) {
        this.userRepository = userRepository;
        this.authService = authService;
    }
    public Map<String, List<SpecialistCardData>> getGroupedSpecialistsForClient(String clientName) {
        List<UserEntity> freelancers = userRepository.findByRoleIgnoreCase("freelancer");
        Map<String, List<SpecialistCardData>> grouped = new LinkedHashMap<>();

        for (UserEntity user : freelancers) {
            String skillType = user.getSkillType();

            if (skillType == null || skillType.isBlank()) {
                skillType = "Без skill";
            }

            boolean approved = authService.isRequestApproved(clientName, user.getUsername());

            FreelancerContactAccess access =
                    new FreelancerContactProxy(user, approved);

            //proxy
            String contactInfo = access.request();

            SpecialistCardData card = new SpecialistCardData(
                    user.getUsername(),
                    skillType,
                    approved,
                    contactInfo
            );

            grouped.computeIfAbsent(skillType, k -> new ArrayList<>()).add(card);
        }

        return grouped;
    }
    public  FreelancerGroup buildTree() {
        List<UserEntity> freelancers = userRepository.findByRoleIgnoreCase("freelancer");

        FreelancerGroup root = new FreelancerGroup("Все фрилансеры");
        Map<String, FreelancerGroup> groups = new LinkedHashMap<>();

        for (UserEntity user : freelancers) {
            String skillType = user.getSkillType();

            if (skillType == null || skillType.isBlank()) {
                skillType = "Без skill";
            }

            if (!groups.containsKey(skillType)) {
                groups.put(skillType, new FreelancerGroup(skillType));
            }

            groups.get(skillType).add(
                    new FreelancerLeaf(user.getUsername(), skillType)
            );
        }

        for (FreelancerGroup group : groups.values()) {
            root.add(group);
        }

        return root;
    }
//для proxy
    public String buildTreeText() {
        FreelancerGroup root = buildTree();
        StringBuilder sb = new StringBuilder();
        root.show(sb, "");
        return sb.toString();
    }
    public Map<String, List<UserEntity>> getGroupedSpecialists() {
        List<UserEntity> freelancers = userRepository.findByRoleIgnoreCase("freelancer");
        Map<String, List<UserEntity>> grouped = new LinkedHashMap<>();

        for (UserEntity user : freelancers) {
            String skillType = user.getSkillType();

            if (skillType == null || skillType.isBlank()) {
                skillType = "Без skill";
            }

            grouped.computeIfAbsent(skillType, k -> new ArrayList<>()).add(user);
        }

        return grouped;
    }
}