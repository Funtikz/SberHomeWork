package org.example.homework_4.task_2;

import java.util.Scanner;

import static org.example.homework_4.task_2.URLReader.readContent;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String url;

        while (true) {
            System.out.println("Введите URL сайта для получения содержимого:");
            url = scanner.nextLine();

            if (url.trim().isEmpty()) {
                System.out.println("URL не может быть пустым. Пожалуйста, введите правильный URL.");
                continue;
            }

            readContent(url);

            System.out.println("Хотите ввести другой URL? (y/n)");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("n")) {
                break;
            }
        }

        scanner.close();
    }
}
