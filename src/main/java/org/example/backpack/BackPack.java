package org.example.backpack;

import org.example.backpack.model.Item;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface BackPack {

  List<Item> getMostValuableSet(List<Item> items, int backPackCapacity);

}
