package org.example.vjudge.lista01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Permutations {

  public static void main(String[] args) throws IOException {
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final int input = Integer.parseInt(br.readLine());
    if (input == 1) {
      System.out.println(input);
    } else if (input <= 3) {
      System.out.println("NO SOLUTION");
    } else {
      getBeautifulPermutations(input);
    }
  }

  private static void getBeautifulPermutations(int input) {
    StringBuffer evenBuffer = new StringBuffer();
    StringBuffer oddBuffer = new StringBuffer();
    for (int i = 1; i <= input; i+=2) {
      if (i != input) {
        evenBuffer.append(i + 1).append(" ");
      }
      oddBuffer.append(i).append(" ");
    }
    System.out.println(evenBuffer);
    System.out.println(oddBuffer);
  }

}
