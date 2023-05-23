package org.example.vjudge.lista02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CoinsCombination {

  private static final Long MODULE =  Double.valueOf(Math.pow(10, 9) + 7).longValue();

  public static void main(String[] args) {
    FastReader fs = new FastReader();
    int coinsQtd = fs.nextInt();
    int targetValue = fs.nextInt();
    int [] coins = new int[coinsQtd];

    for (int i = 0; i < coinsQtd; i++) {
      coins[i] = fs.nextInt();
    }

    Arrays.sort(coins);
    System.out.println(coinsCombinations(targetValue, coins));
  }

  private static long coinsCombinations(int targetValue, int[] coins) {
    int[] memory = new int[targetValue + 1];
    memory[0] = 1;
    for (int i = 1; i <= targetValue; i++) {
      for (int coin : coins) {
        if (i - coin >= 0) {
          memory[i] = (memory[i] + memory[i - coin]);
          if (memory[i] > MODULE) {
            memory[i] -= MODULE;
          }
        } else {
          break;
        }
      }
    }
    return memory[targetValue];
  }

  static class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader()
    {
      br = new BufferedReader(
              new InputStreamReader(System.in));
    }

    String next()
    {
      while (st == null || !st.hasMoreElements()) {
        try {
          st = new StringTokenizer(br.readLine());
        }
        catch (IOException e) {
          e.printStackTrace();
        }
      }
      return st.nextToken();
    }

    int nextInt() { return Integer.parseInt(next()); }

    long nextLong() { return Long.parseLong(next()); }

    double nextDouble()
    {
      return Double.parseDouble(next());
    }

    String nextLine()
    {
      String str = "";
      try {
        if(st.hasMoreTokens()){
          str = st.nextToken("\n");
        }
        else{
          str = br.readLine();
        }
      }
      catch (IOException e) {
        e.printStackTrace();
      }
      return str;
    }
  }

}