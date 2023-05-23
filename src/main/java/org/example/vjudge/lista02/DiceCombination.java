package org.example.vjudge.lista02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;

public class DiceCombination {

  private static final Long MODULE =  Double.valueOf(Math.pow(10, 9) + 7).longValue();

  public static void main(String[] args) {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    try {
      int n = Integer.parseInt(bf.readLine());
      System.out.println(diceCombinations(n));
    } catch (IOException e) {
      throw new UncheckedIOException(e);
    }
  }

  private static long diceCombinations(int n) {
    long[] comb = new long[n + 7];
    comb[0] = 1L;
    for (int i = 0; i < n; i++) {
      for (int j = 1; j <= 6; j++) {
        comb[i + j] += comb[i];
        comb[i + j] %= MODULE;
      }
    }
    return comb[n];
  }

}
