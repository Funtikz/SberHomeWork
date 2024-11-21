package org.example.homework2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
  Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
  В этот телефонный справочник с помощью метода add() можно добавлять записи.
  С помощью метода get() искать номер телефона по фамилии.
  Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
  тогда при запросе такой фамилии должны выводиться все телефоны.
 */
public class PhoneDirectory {
    private final Map<String, List<String>> directory;

    public PhoneDirectory(Map<String, List<String>> directory) {
        this.directory = directory;
    }

    public  PhoneDirectory(){
        this.directory = new HashMap<>();

    }

    public List<String> get(String lastName){
        return this.directory.getOrDefault(lastName, new ArrayList<>());
    }

    public void add(String lastName, String phoneNumber){
        if (!this.directory.containsKey(lastName)){
            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            this.directory.put(lastName, phoneNumbers);
        }
        else{
            List<String> phoneNumbers = this.directory.get(lastName);
            phoneNumbers.add(phoneNumber);
        }
    }

    @Override
    public String toString() {
        return "PhoneDirectory{" +
                "directory=" + directory +
                '}';
    }

}
