package com.mehdilagdimi.marocair_api.base;

@FunctionalInterface
public interface TransactionGetExecuterFI<T1, T2> {
    T2 accept(T1 t);
}
