package org.example.bruteforce.euclidiandist;

import org.example.bruteforce.euclidiandist.model.Point;

import java.util.Set;

public interface ClosestPair {

  Set<Point[]> getClosestPair(Point[] points);

  default double euclidianDist(Point first, Point second) {
    final int firstTerm = first.getCoordinateX() - second.getCoordinateX();
    final int secondTerm = first.getCoordinateY() - second.getCoordinateY();
    return Math.sqrt(Math.pow(firstTerm, 2) + Math.pow(secondTerm, 2));
  }

}
