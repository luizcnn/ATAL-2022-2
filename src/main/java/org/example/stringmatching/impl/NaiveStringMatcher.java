package org.example.stringmatching.impl;

import org.example.stringmatching.StringMatcher;

public class NaiveStringMatcher implements StringMatcher {

  @Override
  public int matches(String input, String pattern) {
    String[] inputArray = input.split("");
    String[] patternArray = pattern.split("");
    int inputSize = input.length();
    int patternSize = pattern.length();
    int counter = 0;

    for(int i = 0; i <= inputSize - patternSize; i++) {
      int j = 0;
      while (j < patternSize && patternArray[j].equalsIgnoreCase(inputArray[j + i])) {
        j++;
      }
      if (j == patternSize) {
        counter++;
      }
    }
    return counter;
  }

}
