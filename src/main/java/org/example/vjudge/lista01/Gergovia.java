package org.example.vjudge.lista01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Gergovia {

  public static void main(String[] args) throws IOException {
    final BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    while (true) {
      int inhabitants = Integer.parseInt(bf.readLine());
      if (inhabitants == 0) {
        break;
      }
      long minWork = 0;
      Long[] houses = Arrays.stream(bf.readLine().split(" "))
              .map(Long::parseLong)
              .toArray(Long[]::new);

      for (int i = 0; i < houses.length - 1; i++) {
        minWork += Math.abs(houses[i]);
        houses[i+1] += houses[i];
      }
      System.out.println(minWork);
    }
  }

}
