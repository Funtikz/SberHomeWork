package org.example.homework_3.task_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. addAll
        List<Integer> source = Arrays.asList(1, 2, 3);
        List<Number> destination = new ArrayList<>(Arrays.asList(10, 20));
        CollectionUtils.addAll(source, destination);
        System.out.println("После addAll: " + destination); // [10, 20, 1, 2, 3]

        // 2. newArrayList
        List<String> newList = CollectionUtils.newArrayList();
        newList.add("apple");
        newList.add("banana");
        System.out.println("newArrayList: " + newList); // [apple, banana]

        // 3. indexOf
        int index = CollectionUtils.indexOf(source, 2);
        System.out.println("Индекс элемента '2' в source: " + index); // 1

        // 4. limit
        List<Integer> limitedList = CollectionUtils.limit(source, 2);
        System.out.println("Ограниченный список: " + limitedList); // [1, 2]

        // 5. add
        CollectionUtils.add(destination, 4);
        System.out.println("После добавления элемента в destination: " + destination); // [10, 20, 1, 2, 3, 4]

        // 6. removeAll
        List<Integer> toRemove = Arrays.asList(2, 3);
        CollectionUtils.removeAll(destination, toRemove);
        System.out.println("После removeAll: " + destination); // [10, 20, 1, 4]

        // 7. containsAll
        List<Integer> c1 = Arrays.asList(1, 2, 3, 4);
        List<Integer> c2 = Arrays.asList(2, 4);
        boolean containsAll = CollectionUtils.containsAll(c1, c2);
        System.out.println("c1 содержит все элементы c2: " + containsAll); // true

        // 8. containsAny
        List<Integer> c3 = Arrays.asList(5, 6);
        boolean containsAny = CollectionUtils.containsAny(c1, c3);
        System.out.println("c1 содержит хотя бы один элемент из c3: " + containsAny); // false

        // 9. range (Comparable)
        List<Integer> numbers = Arrays.asList(8, 1, 3, 5, 6, 4);
        List<?> rangeResult = CollectionUtils.range(numbers, 3, 6);
        System.out.println("Диапазон (Comparable): " + rangeResult); // [3, 5, 6, 4]

        // 10. range (Comparator)
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        List<?> rangeWithComparator = CollectionUtils.range(words, "banana", "date", String::compareTo);
        System.out.println("Диапазон (Comparator): " + rangeWithComparator); // [banana, cherry, date]
    }
}
