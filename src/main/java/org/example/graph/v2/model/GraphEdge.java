package org.example.graph.v2.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GraphEdge {

  private GraphNode source;

  private GraphNode target;

  private int cost;

}
