package org.example.homework_5.proxy;

import org.example.homework_5.annotations.Metric;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class PerformanceProxy implements InvocationHandler {
    private final Object target;

    public PerformanceProxy(Object target) {
        this.target = target;
    }

    @SuppressWarnings("unchecked")
    public static <T> T createProxy(T target) {
        Class<?> targetClass = target.getClass();
        return (T) Proxy.newProxyInstance(
                targetClass.getClassLoader(),
                targetClass.getInterfaces(),
                new PerformanceProxy(target)
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(Metric.class)) {
            long startTime = System.nanoTime();
            Object result = method.invoke(target, args);
            long endTime = System.nanoTime();
            System.out.println("Время работы метода: " + (endTime - startTime) + " наносекунд");
            return result;
        }
        return method.invoke(target, args);
    }
}
