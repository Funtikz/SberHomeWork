package org.example.homework_5.entity;

public class Client {
    private String firstName;
    private String lastName;
    private double balance;

    public static final String MONDAY = "MONDAY";
    public static final String TUESDAY = "TUESDAY";

    public static final  String Wednesday ="Wednesda";

    public Client(){

    }
    public Client(String firstName, String lastName, double balance) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }

    public void printHelloPublic(){
        System.out.println("Hello is the public method");
    }

    private void printHelloPrivateMethod(){
        System.out.println("Hello is the private method");
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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
