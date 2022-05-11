package com.tutorial.java8;

@FunctionalInterface
public interface BiFunction<T, U, R> {
    R apply(T t, U u);
}
