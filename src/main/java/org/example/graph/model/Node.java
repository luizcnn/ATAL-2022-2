package org.example.graph.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
public abstract class Node<T> {

  protected T value;

  @Setter
  protected NodeColor nodeColor = NodeColor.WHITE;

  protected final Set<Node<T>> adjacents = new HashSet<>();

  public Node(T value) {
    this.value = value;
  }

  public abstract void addAdjacentNode(Node<T> node);

}
