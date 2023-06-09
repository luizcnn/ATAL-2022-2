package org.example.graph.v2.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.example.graph.model.NodeColor;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
public class GraphNode {

  private int weight = Integer.MAX_VALUE;

  @ToString.Exclude
  protected NodeColor nodeColor = NodeColor.WHITE;

  @ToString.Exclude
  private List<GraphEdge> adjacents = new ArrayList<>();

  public void addAdjacent(GraphNode target, int cost) {
    this.getAdjacents().add(
            GraphEdge.builder()
                    .target(target)
                    .cost(cost)
                    .source(this)
                    .build()
    );
    target.getAdjacents().add(
            GraphEdge.builder()
                    .target(this)
                    .cost(cost)
                    .source(target)
                    .build()
    );
  }

}
