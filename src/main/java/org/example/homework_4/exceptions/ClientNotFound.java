package org.example.homework_4.exceptions;

public class ClientNotFound extends Exception{
    public ClientNotFound(){
        super("Клиент не найден в БД");
    }
}
