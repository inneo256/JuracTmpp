package com.example.freelance.composite;

import java.util.List;
import java.util.Map;

public interface FreelancerComponent {
    void show(StringBuilder sb, String prefix);
    int count();
    List<FreelancerLeaf> findBySkill(String skill);
    Map<String, Integer> countBySkill();
}