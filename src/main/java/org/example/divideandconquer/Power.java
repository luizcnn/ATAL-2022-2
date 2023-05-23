package org.example.divideandconquer;

public class Power {

  public static void main(String[] args) {
    System.out.println(pot(3, 3));
  }

  private static Integer pot(int x, int exp) {
    if (exp == 1) {
      return x;
    } else {
      if (exp % 2 == 0) {
        return pot(x, exp/2) * pot(x, exp/2);
      } else {
        return x * pot(x, (exp-1)/2) * pot(x, exp/2);
      }
    }
  }

}
