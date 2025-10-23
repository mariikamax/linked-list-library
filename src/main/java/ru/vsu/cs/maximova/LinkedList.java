package ru.vsu.cs.maximova;


public interface LinkedList<T> {
    void addToEnd(T data);
    void addFirst(T data);
    void addOfIndex(int index, T data);
    T getElementOfIndex(int index);
    boolean removeElement(T data);
    int size();
    boolean isEmpty();
    void output();
}