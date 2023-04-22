package org.example.euclidiandist;

import org.example.euclidiandist.model.Point;

import java.util.List;
import java.util.Set;

public interface ClosestPair {

  Set<Point[]> getClosestPair(Point[] points);

  default double euclidianDist(Point first, Point second) {
    final int firstTerm = first.getCoordinateX() - second.getCoordinateX();
    final int secondTerm = first.getCoordinateY() - second.getCoordinateY();
    return Math.sqrt(Math.pow(firstTerm, 2) + Math.pow(secondTerm, 2));
  }

}
