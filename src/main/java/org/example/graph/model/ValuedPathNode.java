package org.example.graph.model;

import lombok.Getter;
import lombok.Setter;

public class ValuedPathNode<T> extends Node<T> {

  @Getter
  @Setter
  private int cost;

  public ValuedPathNode(T value, int cost) {
    this(value);
    this.cost = cost;
  }

  public ValuedPathNode(T value) {
    super(value);
  }

  @Override
  public void addAdjacentNode(Node<T> node) {
    this.getAdjacents().add(node);
    node.getAdjacents().add(this);
  }
}
