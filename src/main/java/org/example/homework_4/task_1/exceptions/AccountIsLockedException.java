package org.example.homework_4.task_1.exceptions;

public class AccountIsLockedException extends Exception {
    public AccountIsLockedException(String message) {
        super(message);
    }
}