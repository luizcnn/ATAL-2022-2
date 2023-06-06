package org.example.graph.representations;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.graph.model.Node;
import org.example.graph.model.NodeImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class GraphRepresentations {

  public static <T> int[][] buildAdjacencyMatrix(List<Node<T>> nodeImpls) {
    int[][] result = new int[nodeImpls.size()][nodeImpls.size()];

    for (int i = 0; i < nodeImpls.size(); i++) {
      for (int j = 0; j < nodeImpls.size(); j++) {
        if (nodeImpls.get(i).getAdjacents().contains(nodeImpls.get(j))) {
          result[i][j] = 1;
        }
      }
    }
    return result;
  }

  public static <T> Node[][] buildValuedAdjacencyMatrix(List<Node<T>> nodeImpls) {
    Node[][] result =  new Node[nodeImpls.size()][nodeImpls.size()];

    for (int i = 0; i < nodeImpls.size(); i++) {
      for (int j = 0; j < nodeImpls.size(); j++) {
        if (nodeImpls.get(i).getAdjacents().contains(nodeImpls.get(j))) {
          result[i][j] = nodeImpls.get(j);
        }
      }
    }
    return result;
  }

  public static <T> List<Set<Node<T>>> buildAdjacencyList(List<NodeImpl<T>> nodeImpls) {
    final var result = new ArrayList<Set<Node<T>>>();
    for (Node<T> nodeImpl : nodeImpls) {
      result.add(nodeImpl.getAdjacents());
    }
    return result;
  }

  public static <T> void printMatrixOfAdjacency(Node<T>[][] matrix) {
    Arrays.stream(matrix).forEach(row -> System.out.println(Arrays.toString(row)));
  }

}
