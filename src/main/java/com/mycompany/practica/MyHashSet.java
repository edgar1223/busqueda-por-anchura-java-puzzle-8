/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practica;

import java.util.List;

/**
 *
 * @author Edgar David
 */
class MyHashSet<T> {
     private final int INITIAL_CAPACITY = 16;
    private Object[] array;
    private int size;

    public MyHashSet() {
        array = new Object[INITIAL_CAPACITY];
        size = 0;
    }

    // Constructor que acepta una lista como argumento
    public MyHashSet(List<T> list) {
        this();
        for (T element : list) {
            add(element);
        }
    }

    // Método para agregar todos los elementos de una lista al conjunto
    public void addAll(List<T> list) {
        for (T element : list) {
            add(element);
        }
    }

    public boolean add(T element) {
        if (contains(element)) {
            return false;
        }
        if (size == array.length) {
            resize();
        }
        int index = getIndex(element);
        array[index] = element;
        size++;
        return true;
    }

    public boolean contains(T element) {
        int index = getIndex(element);
        return array[index] != null && array[index].equals(element);
    }

    private int getIndex(T element) {
        return Math.abs(element.hashCode() % array.length);
    }

    private void resize() {
        Object[] newArray = new Object[array.length * 2];
        for (Object element : array) {
            if (element != null) {
                int index = getIndex((T) element);
                newArray[index] = element;
            }
        }
        array = newArray;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        boolean first = true;
        for (Object element : array) {
            if (element != null) {
                if (!first) {
                    sb.append(", ");
                }
                sb.append(element.toString());
                first = false;
            }
        }
        sb.append("]");
        return sb.toString();
    }
}