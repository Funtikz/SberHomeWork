package org.example.homework_1;

public abstract class Parent {

    // 1. Приватное поле name
    private String name;

    // 2. Статический блок, выводящий на экран "Parent:static 1"
    static {
        System.out.println("Parent:static 1");
    }

    // 3. Нестатический блок, выводящий на экран "Parent:instance 1"
    {
        System.out.println("Parent:instance 1");
    }

    // 4. Статический блок, выводящий на экран "Parent::static 2"
    static {
        System.out.println("Parent::static 2");
    }

    // 5. Конструктор без параметров, выводящий на экран "Parent::constructor"
    public Parent(){
        System.out.println("Parent::constructor");
    }
    // 6. Нестатический блок, выводящий на экран "Parent:instance 2"
    {
        System.out.println("Parent:instance 2");
    }

    // 7. Конструктор с параметром Name, выводящий на экран "Parent:name-constructor"
    public Parent(String name){
        this.name = name;
        System.out.println("Parent:name-constructor");
    }
}
