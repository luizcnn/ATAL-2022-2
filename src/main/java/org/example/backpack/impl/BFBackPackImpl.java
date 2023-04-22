package org.example.backpack.impl;

import org.example.backpack.BackPack;
import org.example.backpack.model.Item;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Esta classe implementa a resolução do problema da mochila, utilizando um algoritmo de força bruta.
 * A ideia do algoritmo é gerarmos todas as possíveis combinações de solução, validarmos uma a uma, e retornar
 * o conjunto de itens mais valiosos, que não excedam o limite de peso da mochila.
 */
public class BFBackPackImpl implements BackPack {

  @Override
  public Set<Item> getMostValuableSet(Set<Item> items, int backPackCapacity) {
    final Set<List<Item>> combinations = getAllCombinations(new ArrayList<>(items));
    final var result = new HashSet<Item>();
    int maxPrice = 0;

    for (List<Item> combination : combinations) {
      int weight = combination
              .stream()
              .reduce(0, (subtotal, element) -> subtotal + element.getWeight(), Integer::sum);
      int price = combination
              .stream()
              .reduce(0, (subtotal, element) -> subtotal + element.getValue(), Integer::sum);
      if (weight < backPackCapacity && price > maxPrice) {
        maxPrice = price;
        result.clear();
        result.addAll(combination);
      }
    }
    return result;
  }

  public static <T> Set<List<T>> getAllCombinations(List<T> items) {
    Set<List<T>> combinationList = new HashSet<>();
    for ( long i = 1; i < Math.pow(2, items.size()); i++ ) {
      List<T> subList = new ArrayList<>();
      for ( int j = 0; j < items.size(); j++ ) {
        if ((i & (long) Math.pow(2, j)) > 0) {
            subList.add(items.get(j));
        }
      }
      combinationList.add(subList);
    }
    return combinationList;
  }

}
