package com.mehdilagdimi.marocair_api.base;


@FunctionalInterface
public interface TransactionExecuterFI<T> {
    void accept(T t);
}
