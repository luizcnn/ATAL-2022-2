package org.example.vjudge.lista01;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class CreatingStrings {

  private final static Set<String> RESULTS = new TreeSet<>();

  public static void main(String[] args) {
    final Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();
    generateStrings(input);

    System.out.println(RESULTS.size());
    RESULTS.forEach(System.out::println);
  }

  private static void generateStrings(String input) {
    generateStrings("", input);
  }

  private static void generateStrings(String str, String input) {
    if (input.length() == 0) {
      RESULTS.add(str);
    }

    for (int i = 0; i < input.length(); i++) {
      String s = str + input.charAt(i);
      String r = input.substring(0, i) + input.substring(i + 1);
      generateStrings(s, r);
    }
  }

}
