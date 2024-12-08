package org.example.homework_5.proxy;

import org.example.homework_5.Calculator;
import org.example.homework_5.annotations.Cache;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class CacheCalculatorProxy implements InvocationHandler {
    private final Object target;
    private final Map<Integer, Integer> cache;

    public CacheCalculatorProxy(Object target) {
        this.target = target;
        this.cache = new HashMap<>();
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.isAnnotationPresent(Cache.class) && args.length == 1 && args[0] instanceof Integer) {
            int number = (Integer) args[0];

            if (cache.containsKey(number)) {
                return cache.get(number);
            }

            int result = (int) method.invoke(target, args);
            cache.put(number, result);
            return result;
        }

        return method.invoke(target, args);
    }

    public static Calculator newInstance(Calculator target) {
        return (Calculator) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                new Class[]{Calculator.class},
                new CacheCalculatorProxy(target)
        );
    }
}
