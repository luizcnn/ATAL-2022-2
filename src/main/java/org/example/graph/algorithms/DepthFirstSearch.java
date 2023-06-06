package org.example.graph.algorithms;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.graph.model.Node;
import org.example.graph.model.NodeColor;
import org.example.graph.model.NodeImpl;

import java.util.List;

import static java.util.Objects.nonNull;
import static org.example.graph.representations.GraphRepresentations.buildValuedAdjacencyMatrix;
import static org.example.graph.representations.GraphRepresentations.printMatrixOfAdjacency;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DepthFirstSearch {

  public static <T> void run(final Node<T>[][] matrix, int startNode) {
    final var row = matrix[startNode];
    for (Node<T> tNodeImpl : row) {
      if (nonNull(tNodeImpl) && tNodeImpl.getNodeColor().equals(NodeColor.WHITE)) {
        visit(tNodeImpl);
      }
    }

    printMatrixOfAdjacency(matrix);
  }

  private static <T> void visit(Node<T> tNodeImpl) {
    tNodeImpl.setNodeColor(NodeColor.GRAY);
    for (Node<T> adj : tNodeImpl.getAdjacents()) {
      if (nonNull(adj) && adj.getNodeColor().equals(NodeColor.WHITE)) {
        visit(adj);
      }
    }
    tNodeImpl.setNodeColor(NodeColor.BLACK);
  }

  public static void main(String[] args) {
    final var node0 = new NodeImpl<>(0);
    final var node1 = new NodeImpl<>(1);
    final var node2 = new NodeImpl<>(2);
    final var node3 = new NodeImpl<>(3);
    final var node4 = new NodeImpl<>(4);

    node0.addAdjacentNode(node1);
    node0.addAdjacentNode(node4);
    node1.addAdjacentNode(node0);
    node1.addAdjacentNode(node2);
    node1.addAdjacentNode(node3);
    node1.addAdjacentNode(node4);
    node2.addAdjacentNode(node1);
    node2.addAdjacentNode(node3);
    node3.addAdjacentNode(node1);
    node3.addAdjacentNode(node2);
    node3.addAdjacentNode(node4);
    node4.addAdjacentNode(node0);
    node4.addAdjacentNode(node3);
    node4.addAdjacentNode(node1);

    DepthFirstSearch.run(buildValuedAdjacencyMatrix(List.of(node0, node1, node2, node3, node4)),4);
  }

}
