package org.example.homework_4;

public class Client {
    private String firstName;
    private String lastName;
    private String pinCode;
    private int balance;

    public Client(String firstName, String lastName, String pinCode, int balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pinCode = pinCode;
        this.balance = balance;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
