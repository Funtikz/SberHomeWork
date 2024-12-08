package org.example.homework_5;


import org.example.homework_5.annotations.Metric;

public interface Calculator {
    @Metric
    int calc(int arg);
}
