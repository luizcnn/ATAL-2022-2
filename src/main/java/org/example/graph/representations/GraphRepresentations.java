package org.example.graph.representations;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.graph.model.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GraphRepresentations {

  public static <T> int[][] buildAdjacencyMatrix(List<Node<T>> nodes) {
    int[][] result = new int[nodes.size()][nodes.size()];

    for (int i = 0; i < nodes.size(); i++) {
      for (int j = 0; j < nodes.size(); j++) {
        if (nodes.get(i).getAdjacents().contains(nodes.get(j))) {
          result[i][j] = 1;
        }
      }
    }
    return result;
  }

  public static <T> Node<T>[][] buildValuedAdjacencyMatrix(List<Node<T>> nodes) {
    Node[][] result =  new Node[nodes.size()][nodes.size()];

    for (int i = 0; i < nodes.size(); i++) {
      for (int j = 0; j < nodes.size(); j++) {
        if (nodes.get(i).getAdjacents().contains(nodes.get(j))) {
          result[i][j] = nodes.get(j);
        }
      }
    }
    return result;
  }

  public static <T> List<Set<Node<T>>> buildAdjacencyList(List<Node<T>> nodes) {
    final var result = new ArrayList<Set<Node<T>>>();
    for (Node<T> node : nodes) {
      result.add(node.getAdjacents());
    }
    return result;
  }

  public static <T> void printMatrixOfAdjacency(Node<T>[][] matrix) {
    Arrays.stream(matrix).forEach(row -> System.out.println(Arrays.toString(row)));
  }

}
