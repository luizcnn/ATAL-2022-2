package org.example.backtracking.backpack.model;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Item {

  private final int id;
  private final int weight;
  private final int value;

  @Override
  public String toString() {
    return "Item{" +
            "id=" + id +
            '}';
  }
}
