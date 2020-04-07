package com.codegym;

import java.util.*;

public class StudentsDatabase {
    private Map<String, Integer> hashMap;
    private Map<String, Integer> linkedHashMap;
    private Map<String, Integer> treeMap;

    public StudentsDatabase() {
        this.hashMap = new HashMap<>();
        this.linkedHashMap = new LinkedHashMap<>();
        this.treeMap = new TreeMap<>();
    }

    public String addStudent(Student student) {
        this.hashMap.put(student.getName(), student.getAge());
        return student.getName();
    }

    public void addAll(Map<? extends String, ? extends Integer> map) {
        this.hashMap.putAll(map);
    }

    public void showStudents() {
        this.linkedHashMap.putAll(this.hashMap);
        System.out.println(this.linkedHashMap);
    }

    public void sortDatabase() {
        this.treeMap.putAll(this.hashMap);
        System.out.println(this.treeMap);
    }

    public static <K extends Comparable<? super K>, V> SortedSet<Map.Entry<K, V>> entriesSortedSetByName(Map<K,V> map) {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>> (
            new Comparator<Map.Entry<K,V>>() {
                @Override 
                public int compare(Map.Entry<K,V> entry1, Map.Entry<K,V> entry2) {
                    return (entry1.getKey().compareTo(entry2.getKey()) < 0) ? 1: ((entry1.getKey().compareTo(entry2.getKey()) == 0) ? 0 : -1);
                }
            }
        );

        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }

    public void sortReverseStudent() {
        System.out.println(entriesSortedSetByName(this.hashMap));
    }
}