package org.example.vjudge.lista01;

import java.util.Scanner;

public class PowerSum {

  private static int solutions = 0;

  public static void main(String[] args) {
    final Scanner sc = new Scanner(System.in);
    int input = Integer.parseInt(sc.nextLine());
    int power = Integer.parseInt(sc.nextLine());
    int limitIndex = (int) Math.floor(Math.pow(input, (double) 1/power));
    calculatePowerSums(input, power, 0, limitIndex);
    System.out.println(solutions);
  }

  private static void calculatePowerSums(int input, int power, int result, int limitIndex) {
    if (limitIndex == 0) {
      if (input == 0) {
        solutions++;
      }
    } else {
      int calculated = (int) Math.pow(limitIndex, power);
      if (calculated <= input) {
        result += calculated;
        calculatePowerSums(input - calculated, power, result, limitIndex - 1);
      }
      calculatePowerSums(input, power, 0, limitIndex - 1);
    }
  }

}
