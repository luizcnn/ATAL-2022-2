package org.example.nqueens;

import org.example.nqueens.impl.NQueensImpl;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NQueensTest {

  private final NQueens nQueens = new NQueensImpl(4);

  @Test
  public void shouldReturnPositionsOf4x4Board() {
    //arrange
    final var expectedResult = new int[]{2, 0, 3, 1};

    //act
    final var result = nQueens.getQueensPosition();

    //assert
    assertEquals(Arrays.toString(expectedResult), Arrays.toString(result));
  }

}
