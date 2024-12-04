package org.example.homework3.task_2;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CollectionUtils {

    // Копирует все элементы из source в destination
    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    // Создает новый пустой ArrayList
    public static <T> List<T> newArrayList() {
        return new ArrayList<>();
    }

    // Возвращает индекс первого вхождения элемента в списке или -1, если элемент не найден
    public static int indexOf(List<?> source, Object o) {
        return source.indexOf(o);
    }

    // Возвращает список, ограниченный указанным размером
    public static <T> List<T> limit(List<T> source, int size) {
        return new ArrayList<>(source.subList(0, Math.min(size, source.size())));
    }

    // Добавляет элемент в список
    public static <T> void add(List<? super T> source, T o) {
        source.add(o);
    }

    // Удаляет все элементы второго списка из первого
    public static <T> void removeAll(List<T> removeFrom, List<?> c2) {
        removeFrom.removeAll(c2);
    }

    // Возвращает true, если первый список содержит все элементы второго
    public static boolean containsAll(List<?> c1, List<?> c2) {
        return c1.containsAll(c2);
    }

    // Возвращает true, если первый список содержит хотя бы один элемент второго
    public static boolean containsAny(List<?> c1, List<?> c2) {
        for (Object o : c2) {
            if (c1.contains(o)) {
                return true;
            }
        }
        return false;
    }

    // Возвращает список элементов из заданного диапазона [min, max], сравнение через Comparable
    public static <T extends Comparable<T>> List<T> range(List<T> list, T min, T max) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (item.compareTo(min) >= 0 && item.compareTo(max) <= 0) {
                result.add(item);
            }
        }
        return result;
    }

    // Возвращает список элементов из заданного диапазона [min, max], сравнение через Comparator
    public static <T> List<T> range(List<T> list, T min, T max, Comparator<? super T> comparator) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (comparator.compare(item, min) >= 0 && comparator.compare(item, max) <= 0) {
                result.add(item);
            }
        }
        return result;
    }
}

