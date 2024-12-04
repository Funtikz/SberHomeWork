package org.example.homework_4.task_1;


import org.example.homework_4.task_1.exceptions.InsufficientFundsException;
import org.example.homework_4.task_1.exceptions.InvalidAmountException;

public class TerminalServer {
    private Client client;

    public TerminalServer(Client client) {
        this.client = client;
    }

    private boolean isAmountValid(int amount){
        return amount % 100 != 0;
    }
    public int getBalance() {
        return client.getBalance();
    }



    public void deposit(int amount) throws InvalidAmountException {
        if (isAmountValid(amount)){
            throw  new InvalidAmountException("Сумма должна быть кратной 100");
        }
        client.setBalance(client.getBalance() + amount);
    }

    public void withdraw(int amount) throws InsufficientFundsException, InvalidAmountException {
        if (client.getBalance() < amount){
            throw new InsufficientFundsException("На счету недостаточно средств");
        }
        if (isAmountValid(amount)){
            throw new InvalidAmountException("Сумма должна быть кратной 100");
        }
        client.setBalance(client.getBalance() - amount);
    }
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
