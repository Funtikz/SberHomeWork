package org.example.homework_4.task_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    /*
        1. Не совсем понял откуда мы должны брать данные баланса и пин кодов, поэтому решил сделать импровизированную БД,
        которая хранит данные о наших клиентах и исходя из этого написал реализацию ...
     */
    public static void main(String[] args) {
        // Добавление наших клиентов для корректной реализации (Заглушка "типо" БД)
        Client client1 = new Client("Щербаков", "Никита", "1234", 100);
        Client client2 = new Client("Василий", "Нарожний", "2334", 0);
        Client client3 = new Client("Лысенко", "Кирилл", "4000", 1000);
        Client client4 = new Client("Савченко", "Денис", "4044", 200);
        List<Client> listOfClients = new ArrayList<>();
        listOfClients.add(client1);
        listOfClients.add(client2);
        listOfClients.add(client3);
        listOfClients.add(client4);

        // Инициализация нужных классов
        Scanner scanner = new Scanner(System.in);
        PinValidator pinValidator = new PinValidator();
        TerminalImpl terminal = new TerminalImpl();

        while (true) {
            terminal.setPinValidator(pinValidator);
            terminal.enterPin(listOfClients);  // Запрашиваем PIN-код

            boolean isRunning = true;
            do {
                System.out.println("Выберите действие:");
                System.out.println("1. Проверить баланс");
                System.out.println("2. Внести деньги");
                System.out.println("3. Снять деньги");
                System.out.println("4. Выйти");

                System.out.println("\n\n\n");
                System.out.print("Ваш выбор: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        terminal.checkBalance();
                        break;

                    case 2:
                        terminal.deposit();
                        break;

                    case 3:
                        terminal.withdraw();
                        break;

                    case 4:
                        System.out.println("Спасибо за использование терминала! До свидания.");
                        isRunning = false;
                        break;

                    default:
                        System.out.println("Неправильный выбор. Попробуйте снова.");
                }
            } while (isRunning);

            // После выхода из меню снова запрашиваем PIN-код
            System.out.println("Для продолжения, пожалуйста, введите свой PIN-код.");
            pinValidator.setEnteredPin(new StringBuilder());  // Сбрасываем PIN-код перед новым вводом
        }
    }
}
