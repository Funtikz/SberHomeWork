package org.example.homework_4;

import org.example.homework_4.exceptions.AccountIsLockedException;
import org.example.homework_4.exceptions.ClientNotFound;
import org.example.homework_4.exceptions.InvalidInputException;

import java.util.List;

public class PinValidator {
    private StringBuilder enteredPin = new StringBuilder();
    private int failedAttempts = 0;
    private long lockEndTime = 0;

    public void addSymbolToPin(char digit) throws InvalidInputException, AccountIsLockedException {
        if (isAccountLocked()) {
            long timeRemaining = (lockEndTime - System.currentTimeMillis()) / 1000;
            throw new AccountIsLockedException("Аккаунт заблокирован. Осталось " + timeRemaining + " секунд.");
        }

        if (!Character.isDigit(digit)){
            throw new InvalidInputException("Неправильный символ, в PIN-CODE должны быть только цифры!");
        }
        enteredPin.append(digit);
    }

    public boolean pinIsValid(){
        return enteredPin.length() == 4;
    }

    public boolean isAccountLocked() {
        return lockEndTime > System.currentTimeMillis();
    }


    public Client clientsIsPresent(List<Client> clients) throws ClientNotFound {
        for(Client client : clients){
            if (client.getPinCode().contentEquals(enteredPin)){
                resetFailedAttempts();
                return client;
            }
        }
        increaseFailedAttempts();
        throw new ClientNotFound();
    }

    private void increaseFailedAttempts() {
        failedAttempts++;
        if (failedAttempts >= 3) {
            lockEndTime = System.currentTimeMillis() + 10 * 1000;
            failedAttempts = 0;
        }
    }

    private void resetFailedAttempts() {
        failedAttempts = 0;
    }

    public StringBuilder getEnteredPin() {
        return enteredPin;
    }

    public void setEnteredPin(StringBuilder enteredPin) {
        this.enteredPin = enteredPin;
    }

    public int getFailedAttempts() {
        return failedAttempts;
    }

    public void setFailedAttempts(int failedAttempts) {
        this.failedAttempts = failedAttempts;
    }

    public long getLockEndTime() {
        return lockEndTime;
    }

    public void setLockEndTime(long lockEndTime) {
        this.lockEndTime = lockEndTime;
    }

}
