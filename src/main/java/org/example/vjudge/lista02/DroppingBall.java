package org.example.vjudge.lista02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DroppingBall {

  public static void main(String[] args) {
    FastReader fs = new FastReader();
    int qtdOfTests = fs.nextInt();

    while (qtdOfTests != 0) {
      int a = fs.nextInt();
      int b = fs.nextInt();
      int node = 1;

      for (int i = 1; i < a; i++) {
        if (isEven(b)) {
          node = (node * 2) + 1;
          b = b / 2;
        } else {
          node *= 2;
          b = (b + 1) / 2;
        }
      }
      System.out.println(node);
      qtdOfTests--;
    }
  }

  private static boolean isEven(int value) {
    return value % 2 == 0;
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