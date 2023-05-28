package org.example.graph.algorithms;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.graph.model.Node;
import org.example.graph.model.NodeColor;

import java.util.List;

import static java.util.Objects.nonNull;
import static org.example.graph.representations.GraphRepresentations.buildValuedAdjacencyMatrix;
import static org.example.graph.representations.GraphRepresentations.printMatrixOfAdjacency;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DepthFirstSearch {

  public static <T> void run(final Node<T>[][] matrix, int startNode) {
    final var row = matrix[startNode];
    for (Node<T> tNode : row) {
      if (nonNull(tNode) && tNode.getNodeColor().equals(NodeColor.WHITE)) {
        visit(tNode);
      }
    }

    printMatrixOfAdjacency(matrix);
  }

  private static <T> void visit(Node<T> tNode) {
    tNode.setNodeColor(NodeColor.GRAY);
    for (Node<T> adj : tNode.getAdjacents()) {
      if (nonNull(adj) && adj.getNodeColor().equals(NodeColor.WHITE)) {
        visit(adj);
      }
    }
    tNode.setNodeColor(NodeColor.BLACK);
  }

  public static void main(String[] args) {
    final var node0 = new Node<>(0);
    final var node1 = new Node<>(1);
    final var node2 = new Node<>(2);
    final var node3 = new Node<>(3);
    final var node4 = new Node<>(4);

    node0.addAdjacentNodes(node1, node4);
    node1.addAdjacentNodes(node0, node2, node3, node4);
    node2.addAdjacentNodes(node1, node3);
    node3.addAdjacentNodes(node1, node2, node4);
    node4.addAdjacentNodes(node0, node3, node1);

    DepthFirstSearch.run(buildValuedAdjacencyMatrix(List.of(node0, node1, node2, node3, node4)),4);
  }

}
