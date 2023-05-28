package org.example.graph.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Getter
public class Node<T> {

  private T value;

  @Setter
  private NodeColor nodeColor = NodeColor.WHITE;

  private final Set<Node<T>> adjacents = new HashSet<>();

  public Node(T value) {
    this.value = value;
  }

  @SafeVarargs
  public final void addAdjacentNodes(Node<T>... nodes) {
    Arrays.stream(nodes).forEach(node -> {
      this.getAdjacents().add(node);
      node.getAdjacents().add(this);
    });
  }

  @Override
  public String toString() {
    return String.format("{\"value\":\"%s, \"color\":\"%s\"}", value, nodeColor);
  }

}
