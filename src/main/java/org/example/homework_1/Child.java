package org.example.homework_1;

public class Child extends Parent{
    // 1. Статический блок, выводящий на экран "Child:static 1"
    static {
        System.out.println("Child:static 1");
    }

    // 2. Нестатический блок, выводящий на экран "Child:instance 1"
    {
        System.out.println("Child:instance 1");
    }

    // 3. Статический блок, выводящий на экран "Child:static 2"
    static {
        System.out.println("Child:static 2");
    }

    // 4. Конструктор без параметров, выводящий на экран "Child:constructor"
    Child(){
        System.out.println("Child:constructor");
    }

    // 5. Конструктор с параметром Name, выводящий на экран "Child:name-constructor"
    Child(String name){
        super(name);
        System.out.println("Child:name-constructor");
    }

    // 6. Нестатический блок, выводящий на экран "Child:instance 2"
    {
        System.out.println("Child:instance 2");
    }
}
