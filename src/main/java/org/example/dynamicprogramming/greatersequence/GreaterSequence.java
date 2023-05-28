package org.example.dynamicprogramming.greatersequence;

public class GreaterSequence {

  public int[][] getGreaterAscSequence(int[] input) {
    int[][] counter = new int[input.length + 1][input.length + 1];

    for (int curr = (input.length - 1); curr >= 0; curr--) {
      for (int prev = (input.length - 1); prev >= -1; prev--) {
        int take = 0;
        if (prev == -1 || input[curr] > input[prev]) {
          take = 1 + counter[curr + 1][curr + 1];
        }
        int notTake = counter[curr + 1][prev + 1];
        counter[curr][prev + 1] = Math.max(take, notTake);
      }
    }

    return counter;
  }

  public static void main(String[] args) {
    final var greaterSequence = new GreaterSequence();

    final var result = greaterSequence.getGreaterAscSequence(new int[] {6, 5, 0, 2, 1, 4});

    System.out.println(result[0][0]);

  }

}
