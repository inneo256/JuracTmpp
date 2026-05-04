package com.example.freelance.composite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreelancerGroup implements FreelancerComponent {

    private String groupName;
    private List<FreelancerComponent> children = new ArrayList<>();

    public FreelancerGroup(String groupName) {
        this.groupName = groupName;
    }

    public void add(FreelancerComponent component) {
        children.add(component);
    }

    public void remove(FreelancerComponent component) {
        children.remove(component);
    }

    public FreelancerComponent getChild(int index) {
        return children.get(index);
    }

    @Override
    public void show(StringBuilder sb, String prefix) {
        sb.append(prefix)
                .append(groupName)
                .append("\n");

        for (FreelancerComponent child : children) {
            child.show(sb, prefix + "   ");
        }
    }
    @Override
    public int count() {
        int sum = 0;
        for (FreelancerComponent child : children) {
            sum += child.count();
        }
        return sum;
    }


    @Override
    public List<FreelancerLeaf> findBySkill(String skill) {
        List<FreelancerLeaf> result = new ArrayList<>();

        for (FreelancerComponent child : children) {
            result.addAll(child.findBySkill(skill));
        }

        return result;
    }
    @Override
    public Map<String, Integer> countBySkill() {
        Map<String, Integer> map = new HashMap<>();

        for (FreelancerComponent child : children) {
            Map<String, Integer> childMap = child.countBySkill();

            for (String key : childMap.keySet()) {
                map.put(key, map.getOrDefault(key, 0) + childMap.get(key));
            }
        }

        return map;
    }
}
