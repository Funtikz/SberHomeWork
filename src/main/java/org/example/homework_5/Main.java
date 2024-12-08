package org.example.homework_5;


import org.example.homework_5.entity.Client;
import org.example.homework_5.impl.CalculatorImpl;
import org.example.homework_5.proxy.CacheCalculatorProxy;
import org.example.homework_5.proxy.PerformanceProxy;
import org.example.homework_5.utils.BeanUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        /*
                                Задача 1:
                    Имплементировать следующий интерфейс в классе CalculatorImpl
                     public interface Calculator{
                        /**
                        * Расчет факториала числа.
                        * @param number
                        *
                            int calc (int number);
                        } ?????
        */


        /* Задача 2:
           Вывести на консоль все методы класса, включая все родительские методы
						      (включая приватные) */
        System.out.println("\nЗАДАНИЕ № 2");

        Class<?> client = Class.forName("org.example.homework_5.entity.Client");
        Method[] declaredMethods = client.getDeclaredMethods();
        System.out.println("Методы класса Client:");
        for (Method method : declaredMethods){
            System.out.println("Method: " + method.getName());
        }
        // Задача 3: Вывести все геттеры класса
        System.out.println("\nЗАДАНИЕ № 3");

        System.out.println("Вывод геттеров класса Client: ");
        Arrays.stream(declaredMethods)
                .filter(method -> method.getName().startsWith("get"))
                .forEach(method -> System.out.println("Геттер: " + method.getName()));

        /*
        Задача 4:
            Проверить что все String константы имеют значение = их имени
            public static final String MONDAY = "MONDAY";
         */
        System.out.println("\nЗАДАНИЕ № 4");
        Field[] fields = client.getFields();
        List<Field> listOfPublicStaticFinalFields = Arrays.stream(client.getFields())
                .filter(field -> field.getType() == String.class
                        && Modifier.isStatic(field.getModifiers())
                        && Modifier.isFinal(field.getModifiers()))
                .collect(Collectors.toList());

        listOfPublicStaticFinalFields.forEach(field -> {
            try {
                String fieldName = field.getName();
                String fieldValue = (String) field.get(null);

                if (fieldName.equals(fieldValue)) {
                    System.out.println("Верно: " + fieldName + " = " + fieldValue);
                } else {
                    System.out.println("Ошибка: " + fieldName + " != " + fieldValue);
                }
            } catch (IllegalAccessException e) {
                System.out.println("Не удалось получить доступ к полю: " + field.getName());
            }
        });
        /*
        Задача 5:
            Реализовать кэширующий прокси
         */
        System.out.println("\nЗАДАНИЕ № 5");
        Calculator calculator = new CalculatorImpl();
        Calculator proxy = CacheCalculatorProxy.newInstance(calculator);
        System.out.println(proxy.calc(5));
        System.out.println(proxy.calc(5));
        System.out.println(proxy.calc(6));
        System.out.println(proxy.calc(6));
        /*
        Задача 6:
            Создать свою аннотацию Metric. Реализовать proxy класс PerformanceProxy,
            который в случае если метод аннотирован Metric будет выводить на консоль время выполнения метода.
         */
        System.out.println("\nЗАДАНИЕ № 6");
        Calculator calculatorImpl = new CalculatorImpl();
        Calculator calculatorProxy = PerformanceProxy.createProxy(calculatorImpl);
        System.out.println(calculatorProxy.calc(3));
        /*
        Задача 7:
            Реализовать следующий класс BeanUtils по документации
         */
        System.out.println("\nЗАДАНИЕ № 7");

        Client client1 = new Client();
        client1.setBalance(100);
        client1.setFirstName("Nikita");
        client1.setLastName("Sherbakov");
        Client client2 = new Client();
        BeanUtils.assign(client2, client1);
        System.out.println(client2.getBalance());
        System.out.println(client2.getFirstName());
    }

}
