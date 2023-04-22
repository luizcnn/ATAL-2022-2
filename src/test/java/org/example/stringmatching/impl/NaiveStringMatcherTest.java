package org.example.stringmatching.impl;

import org.example.stringmatching.StringMatcher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NaiveStringMatcherTest {


  private static final String NOT_MATCHER_STRING = "I will not match with anyone!";
  private static final String ONE_MATCH_STRING = "I've just match once";
  private static final String THREE_MATCH_STRING = "How many matchs you want ? Maybe three? ";
  private static final String ALL_TERMS_MATCHED = "AAAAAAAA";
  private final StringMatcher stringMatcher = getStringMatcher();

  private static NaiveStringMatcher getStringMatcher() {
    return new NaiveStringMatcher();
  }

  @Test
  public void shouldHaveNoMatches() {
    //arrange
    final var pattern = "XPTO";

    //act //asserts
    assertEquals(0, stringMatcher.matches(NOT_MATCHER_STRING, pattern));
  }

  @Test
  public void shouldMatchOnce() {
    //arrange
    final var matchOncePattern = "st ma";

    //act //asserts
    assertEquals(1, stringMatcher.matches(ONE_MATCH_STRING, matchOncePattern));
  }

  @Test
  public void shouldMatchThreeTimes() {
    //arrange
    final var matchThreePattern = "ma";

    //act //asserts
    assertEquals(3, stringMatcher.matches(THREE_MATCH_STRING, matchThreePattern));
  }

  @Test
  public void shouldMatchAllTerms() {
    //arrange
    final var allMatchedPattern = "A";

    //act //asserts
    assertEquals(8, stringMatcher.matches(ALL_TERMS_MATCHED, allMatchedPattern));
  }


}