package org.example.homework2;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class HomeWorkTest2 {
    public static void main(String[] args) {
        /*
        Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
        Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
        Посчитать сколько раз встречается каждое слово.
         */
        String[] words = {
                "apple", "banana", "cherry", "apple", "date",
                "banana", "fig", "grape", "cherry", "kiwi",
                "lemon", "mango", "banana", "pear", "fig",
                "apple", "orange", "kiwi", "apple", "mango"
        };

        Map<String, Long> wordsAndCount = Arrays.stream(words)
                .collect(Collectors.groupingBy(word -> word, Collectors.counting()));
        wordsAndCount.forEach((word, count) ->
                System.out.println(word + " : " + count));

        System.out.println("\n \n2 задание ");

        /*
          Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
          В этот телефонный справочник с помощью метода add() можно добавлять записи.
          С помощью метода get() искать номер телефона по фамилии.
          Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
          тогда при запросе такой фамилии должны выводиться все телефоны.
         */
        PhoneDirectory phoneDirectory = new PhoneDirectory();
        phoneDirectory.add("Щербаков", "+79882505362");
        phoneDirectory.add("Нарожний", "+79515006221");
        phoneDirectory.add("Нарожний", "+79094342260");
        phoneDirectory.add("Савченко", "+79930808475");
        phoneDirectory.add("Савченко", "+79518488475");

        System.out.println("Поиск номеров по фамилии Савченко" + phoneDirectory.get("Савченко"));
        System.out.println("Поиск номеров по фамилии Нарожний" + phoneDirectory.get("Нарожний"));
        System.out.println("Поиск номеров по фамилии Щербаков" + phoneDirectory.get("Щербаков"));

    }


}
