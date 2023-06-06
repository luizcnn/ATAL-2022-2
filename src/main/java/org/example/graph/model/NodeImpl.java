package org.example.graph.model;

import lombok.Getter;

@Getter
public class NodeImpl<T> extends Node<T> {

  public NodeImpl(T value) {
    super(value);
  }

  @Override
  public void addAdjacentNode(Node<T> node) {
    this.getAdjacents().add(node);
    node.getAdjacents().add(this);
  }

  @Override
  public String toString() {
    return String.format("{\"value\":\"%s, \"color\":\"%s\"}", value, nodeColor);
  }
}
