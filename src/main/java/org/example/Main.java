package org.example;

import org.example.entity.Employee;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        LinkedList<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(4, "Burak", "Cevizli"));

        System.out.println("Tekrar Edenler: " + findDuplicates(employees));
        System.out.println("Benzersiz Liste (Map): " + findUniques(employees));
        System.out.println("Sadece Tek Geçenler: " + removeDuplicates(employees));
    }

    public static List<Employee> findDuplicates(List<Employee> employees) {
        Set<Employee> seen = new HashSet<>();
        Set<Employee> duplicateSet = new HashSet<>();
        List<Employee> duplicates = new LinkedList<>();

        for (Employee e : employees) {
            if (e != null) {
                if (!seen.add(e)) {
                    if (duplicateSet.add(e)) {
                        duplicates.add(e);
                    }
                }
            }
        }
        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        Map<Integer, Employee> uniqueMap = new HashMap<>();
        for (Employee e : employees) {
            if (e != null && !uniqueMap.containsKey(e.getId())) {
                uniqueMap.put(e.getId(), e);
            }
        }
        return uniqueMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        Map<Employee, Integer> countMap = new HashMap<>();
        for (Employee e : employees) {
            if (e != null) {
                countMap.put(e, countMap.getOrDefault(e, 0) + 1);
            }
        }

        List<Employee> onlyUniques = new LinkedList<>();
        for (Employee e : employees) {
            if (e != null && countMap.get(e) == 1) {
                onlyUniques.add(e);
            }
        }
        return onlyUniques;
    }
}