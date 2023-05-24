package org.example.divideandconquer.maxminsum.impl;

import org.example.divideandconquer.maxminsum.MaxMinSum;

public class MaxMinSumImpl implements MaxMinSum {

  @Override
  public int[] maxMinSum(int[] array, int i, int j, int[] result) {
    if (i == j) {
      result[2] += array[i];
      return result;
    } else if (i == j - 1) {
      if (array[i] > array[j]) {
        result[0] = Math.max(result[0], array[i]);
        result[1] = Math.min(result[1], array[j]);
      } else {
        result[0] = Math.max(result[0], array[j]);
        result[1] = Math.max(result[1], array[i]);
      }
      result[2] += array[i];
      result[2] += array[j];
      return result;
    } else {
      int middle = (i + j) / 2;
      maxMinSum(array, i, middle, result);
      maxMinSum(array, middle + 1, j, result);
    }
    return result;
  }

}
