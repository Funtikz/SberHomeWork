package org.example.homework_4.task_1;


import org.example.homework_4.task_1.exceptions.*;

import java.util.List;
import java.util.Scanner;

public class TerminalImpl implements Terminal {
    private TerminalServer terminalServer;
    private PinValidator pinValidator;
    private List<Client> clients;

    public TerminalImpl() {
    }

    public TerminalImpl(TerminalServer terminalServer,
                        PinValidator pinValidator,
                        List<Client> clients) {
        this.terminalServer = terminalServer;
        this.pinValidator = pinValidator;
        this.clients = clients;
    }

    @Override
    public void enterPin(List<Client> listOfClients) {
        Scanner scanner = new Scanner(System.in);
        boolean isCorrect = false;
        Client currentClient = null;

        System.out.println("\nДобро пожаловать в терминал! Для использования терминала необходимо ввести PIN-код");

        //Проверка условий на вход
        while (!isCorrect){
            int currentSymbol = pinValidator.getEnteredPin().length() + 1;
            System.out.println("Введите " + currentSymbol + "-й символ PIN-кода:");
            char character = scanner.next().charAt(0);
            try {
                pinValidator.addSymbolToPin(character);
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            } catch (AccountIsLockedException e) {
                System.out.println("Вы сделали слишком много попыток! Пожалуйста подождите " +
                        ((pinValidator.getLockEndTime() - System.currentTimeMillis()) / 1000) + " секунд.");
            }
            if (pinValidator.pinIsValid()){
                try {
                    currentClient = pinValidator.clientsIsPresent(listOfClients);
                    isCorrect = true;
                } catch (ClientNotFound e) {
                    System.out.println("К сожалению вы не зарегистрированы в данном банке :( " +
                            "или вы ввели не правильный PIN-код \n попробуйте еще раз! ");
                    pinValidator.setEnteredPin(new StringBuilder());
                }
            }
        }

        System.out.println("Добро пожаловать, " + currentClient.getFirstName() + " " + currentClient.getLastName() + "!\n" );
        this.terminalServer = new TerminalServer(currentClient);
    }

    @Override
    public void checkBalance()  {
        System.out.println("Ваш баланс: " + terminalServer.getBalance() + "руб\n");
    }

    @Override
    public void deposit(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму которую нужно положить на счет");
        int amount = scanner.nextInt();
        try {
            terminalServer.deposit(amount);
            System.out.println("Ваш счет пополнен! Ваш баланс: " + this.terminalServer.getBalance());
        } catch (InvalidAmountException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void withdraw()  {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму которую нужно снять");
        int amount = scanner.nextInt();
        try {
            terminalServer.withdraw(amount);
            System.out.println("Операция успешно выполнена! Ваш баланс: " + terminalServer.getBalance());
        } catch (InsufficientFundsException | InvalidAmountException e) {
            System.out.println(e.getMessage());
        }

    }



    public TerminalServer getTerminalServer() {
        return terminalServer;
    }

    public PinValidator getPinValidator() {
        return pinValidator;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setTerminalServer(TerminalServer terminalServer) {
        this.terminalServer = terminalServer;
    }

    public void setPinValidator(PinValidator pinValidator) {
        this.pinValidator = pinValidator;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
