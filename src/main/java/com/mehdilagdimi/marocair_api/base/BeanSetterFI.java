package com.mehdilagdimi.marocair_api.base;

@FunctionalInterface
public interface BeanSetterFI<T> {
    void set(T obj);
}
