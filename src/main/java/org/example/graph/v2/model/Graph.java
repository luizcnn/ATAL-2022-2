package org.example.graph.v2.model;

import lombok.Builder;
import lombok.Data;
import org.example.graph.model.NodeColor;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

@Data
@Builder
public class Graph {

  private int qtdVertex;

  private List<GraphNode> adj;

  public void shortestPathV2(int nodeIndex) {
    final PriorityQueue<GraphEdge> pq = new PriorityQueue<>(qtdVertex, Comparator.comparing(GraphEdge::getCost));
    adj.get(nodeIndex).setWeight(0);
    pq.add(adj.get(nodeIndex).getAdjacents().get(0));

    while (!pq.isEmpty()) {
      final var edge = pq.poll();
      GraphNode node = edge.getSource().getNodeColor().equals(NodeColor.WHITE)
              ? edge.getSource()
              : edge.getTarget();

      for (GraphEdge e : node.getAdjacents()) {
        if (node.getWeight() + e.getCost() < e.getTarget().getWeight()) {
          e.getTarget().setWeight(node.getWeight() + e.getCost());
          pq.add(e);
        }
      }
      node.setNodeColor(NodeColor.BLACK);
    }
    System.out.println(adj);
  }

  public static void main(String[] args) {
    final var nodeA = new GraphNode();
    final var nodeB = new GraphNode();
    final var nodeC = new GraphNode();
    final var nodeD = new GraphNode();
    final var nodeE = new GraphNode();

    nodeA.addAdjacent(nodeB, 6);
    nodeA.addAdjacent(nodeD, 1);
    nodeD.addAdjacent(nodeB, 2);
    nodeD.addAdjacent(nodeE, 1);
    nodeB.addAdjacent(nodeE, 2);
    nodeB.addAdjacent(nodeC, 5);
    nodeC.addAdjacent(nodeE, 5);

    final var graph = Graph.builder()
            .adj(List.of(nodeA, nodeB, nodeC, nodeD, nodeE))
            .qtdVertex(5)
            .build();
    graph.shortestPathV2(0);
  }

}
