package org.example.backpack;

import org.example.backpack.model.Item;

import java.util.Set;

public interface BackPack {

  Set<Item> getMostValuableSet(Set<Item> items, int backPackCapacity);

}
