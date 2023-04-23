package org.example.backpack;

import org.example.backpack.impl.BFBackPackImpl;
import org.example.backpack.impl.BackTrackingBackPackImpl;
import org.example.backpack.model.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BackPackTest {

  private BackPack backPack;

  @BeforeEach
  public void setup() {
    this.backPack = new BackTrackingBackPackImpl();
  }

  @Test
  public void shouldGetAnEmptySetIfIsNotPossiblePutAnythingInBackPack() {
    //arrange
    final var items = List.of(
            new Item(1, 20, 30),
            new Item(2, 34, 48)
    );

    //act
    final var result = backPack.getMostValuableSet(items, 16);

    assertNotNull(result);
    assertTrue(result.isEmpty());
  }

  @Test
  public void shouldGetMostValuableSetOfItems() {
    //arrange
    final var items = buildItems();

    //act
    final var result = backPack.getMostValuableSet(items, 16);

    assertNotNull(result);
    assertEquals(2, result.size());
    assertEquals(15, result.stream().reduce(0, (partialWeight, element) -> partialWeight + element.getWeight(), Integer::sum));
    assertEquals(80, result.stream().reduce(0, (partialWeight, element) -> partialWeight + element.getValue(), Integer::sum));
  }

  @Test
  public void shouldGenerateAllCombinationsForAnInputListOfItems() {
    //arrange
    final var items = buildRandomItems();

    //act

    final var result  = BFBackPackImpl.getAllCombinations(new ArrayList<>(items));

    //asserts
    assertEquals(Math.pow(2, items.size()) - 1, result.size());
  }

  private List<Item> buildItems() {
    return List.of(
            new Item(0, 2, 20),
            new Item(1, 5, 30),
            new Item(2, 10, 50),
            new Item(3, 5, 10)
    );
  }

  private List<Item> buildRandomItems() {
    final int size = 5;
    final var result = new ArrayList<Item>();

    for (int i = 0; i < size; i++) {
      final var weight = Math.round(Math.random() * 100);
      final var price = Math.round(Math.random() * 100);
      result.add(new Item(i, (int) weight, (int) price));
    }
    return result;
  }

}