package org.example.bruteforce.euclidiandist.impl;

import org.example.bruteforce.euclidiandist.ClosestPair;
import org.example.bruteforce.euclidiandist.model.Point;

import java.util.HashSet;
import java.util.Set;

public class BFClosestPairImpl implements ClosestPair {

  @Override
  public Set<Point[]> getClosestPair(Point[] points) {
    final Set<Point[]> result = new HashSet<>();
    double MIN_DIST = Double.MAX_VALUE;

    for(int i = 0; i < points.length; i++) {
      for(int j = i + 1; j < points.length; j++) {
        final var dist = euclidianDist(points[i], points[j]);
        if (dist < MIN_DIST) {
          MIN_DIST = dist;
          result.clear();
          result.add(new Point[]{points[i], points[j]});
        } else if (dist == MIN_DIST) {
          result.add(new Point[]{points[i], points[j]});
        }
      }
    }
    return result;
  }

}
