package org.example.backtracking.backpack;

import org.example.backtracking.backpack.model.Item;

import java.util.List;

public interface BackPack {

  List<Item> getMostValuableSet(List<Item> items, int backPackCapacity);

}
