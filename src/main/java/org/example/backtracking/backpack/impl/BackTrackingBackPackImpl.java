package org.example.backtracking.backpack.impl;

import org.example.backtracking.backpack.model.Item;
import org.example.backtracking.backpack.BackPack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackTrackingBackPackImpl implements BackPack {

  private int greaterValue = 0;
  private int[] resultList;

  @Override
  public List<Item> getMostValuableSet(List<Item> items, int backPackCapacity) {
    this.resultList = new int[items.size()];
    final var tempResult = new int[items.size()];
    getMostValuableSet(items, backPackCapacity, 0, 0, tempResult);
    return createList(items, resultList);
  }

  private void getMostValuableSet(List<Item> items, int backPackCapacity, int value, int index, int[] tempResult) {
    if (index == items.size()) {
      if (value > greaterValue) {
        this.greaterValue = value;
        this.resultList = Arrays.copyOf(tempResult, items.size());
      }
    } else {
      if (items.get(index).getWeight() <= backPackCapacity) {
        tempResult[index] = 1;
        getMostValuableSet(
                items,
                backPackCapacity - items.get(index).getWeight(),
                value + items.get(index).getValue(),
                index + 1,
                tempResult
        );
      }
      tempResult[index] = 0;
      getMostValuableSet(items, backPackCapacity, value, index + 1, tempResult);
    }
  }

  private List<Item> createList(List<Item> items, int[] resultList) {
    final var result = new ArrayList<Item>();
    for (int i = 0; i < resultList.length; i++) {
      if (resultList[i] > 0) {
        result.add(items.get(i));
      }
    }
    return result;
  }

}
