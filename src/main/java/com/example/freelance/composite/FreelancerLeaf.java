package com.example.freelance.composite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreelancerLeaf implements FreelancerComponent {

    private String name;
    private String skillType;

    public FreelancerLeaf(String name, String skillType) {
        this.name = name;
        this.skillType = skillType;
    }

    @Override
    public void show(StringBuilder sb, String prefix) {
        sb.append(prefix)
                .append("👤 ")
                .append(name)
                .append(" (")
                .append(skillType)
                .append(")\n");
    }
    @Override
    public int count() {
        return 1;
    }

    @Override
    public List<FreelancerLeaf> findBySkill(String skill) {
        List<FreelancerLeaf> result = new ArrayList<>();
        if (this.skillType.equalsIgnoreCase(skill)) {
            result.add(this);
        }
        return result;
    }

    @Override
    public Map<String, Integer> countBySkill() {
        Map<String, Integer> map = new HashMap<>();
        map.put(skillType, 1);
        return map;
    }
}