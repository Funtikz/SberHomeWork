package org.example.homework_4;

import java.util.List;

public interface Terminal {
    void enterPin(List<Client> clientList);
    void checkBalance();
    void deposit();
    void withdraw();
}
