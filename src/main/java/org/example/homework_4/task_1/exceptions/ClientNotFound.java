package org.example.homework_4.task_1.exceptions;

public class ClientNotFound extends Exception{
    public ClientNotFound(){
        super("Клиент не найден в БД");
    }
}
