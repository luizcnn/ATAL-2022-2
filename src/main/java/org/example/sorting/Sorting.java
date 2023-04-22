package org.example.sorting;

public interface Sorting<T extends Comparable<T>> {

  void sort(T[] array);

}