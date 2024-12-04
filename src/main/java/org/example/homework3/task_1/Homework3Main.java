package org.example.homework3.task_1;

import java.util.HashMap;
import java.util.Map;

public class Homework3Main {
    public static void main(String[] args) {
        System.out.println("ЗАДАНИЕ № 1");
        CountMap<String> countMap = new CountMapImpl<>();

        // 1. Добавление элементов
        countMap.add("apple");
        countMap.add("apple");
        countMap.add("banana");
        countMap.add("cherry");
        countMap.add("banana");

        System.out.println("Количество 'apple': " + countMap.getCount("apple")); // 2
        System.out.println("Количество 'banana': " + countMap.getCount("banana")); // 2
        System.out.println("Количество 'cherry': " + countMap.getCount("cherry")); // 1

        // 2. Удаление элементов
        int removedCount = countMap.remove("banana");
        System.out.println("Удалено 'banana', было: " + removedCount); // 2
        System.out.println("Количество 'banana' после удаления: " + countMap.getCount("banana")); // 0

        // 3. Размер Map
        System.out.println("Размер Map: " + countMap.size()); // 2 (apple, cherry)

        // 4. Добавление элементов из другого CountMap
        CountMap<String> anotherMap = new CountMapImpl<>();
        anotherMap.add("apple");
        anotherMap.add("apple");
        anotherMap.add("date");

        countMap.addAll(anotherMap);
        System.out.println("Количество 'apple' после addAll: " + countMap.getCount("apple")); // 4
        System.out.println("Количество 'date': " + countMap.getCount("date")); // 1

        // 5. Конвертация в Map
        Map<String, Integer> map = countMap.toMap();
        System.out.println("Map из CountMap: " + map); // {apple=4, cherry=1, date=1}

        // 6. Запись данных в существующий Map
        Map<String, Integer> destinationMap = new HashMap<>();
        countMap.toMap(destinationMap);
        System.out.println("Данные записаны в другую Map: " + destinationMap); // {apple=4, cherry=1, date=1}
    }
}
