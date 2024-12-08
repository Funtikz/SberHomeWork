package org.example.homework_5.impl;

import org.example.homework_5.Calculator;

public class CalculatorImpl implements Calculator {
    @Override
    public int calc(int number) {
        if (number == 0 || number == 1) {
            return 1;
        }
        return number * calc(number - 1);
    }

    private void countCrow() {
        System.out.println("Вызван countCrow");
    }
}
