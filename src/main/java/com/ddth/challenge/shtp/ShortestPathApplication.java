package com.ddth.challenge.shtp;


import com.ddth.challenge.shtp.controller.SHTPController;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.ddth.challenge.shtp.model.ResponseMessage.Edge;
import com.ddth.challenge.shtp.model.ResponseMessage.Vertex;
import com.ddth.challenge.shtp.model.ResponseMessage.Graph;
import com.ddth.challenge.shtp.algorithm.ShortestPath.DijkstraAlgorithm;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import com.ddth.challenge.shtp.algorithm.ShortestPath;
import com.ddth.challenge.shtp.model.ResponseMessage;

@SpringBootApplication
public class ShortestPathApplication {

 public static void main(String[] args) {
  SpringApplication.run(ShortestPathApplication.class, args);
                SpringApplication.run(ResponseMessage.class, args);
                SpringApplication.run(SHTPController.class, args);
                SpringApplication.run(ShortestPath.class, args);

 }

    private List<Vertex> nodes;
    private List<Edge> edges;

    public void testExcute() extend ResponseMessage {
        nodes = new ArrayList<Vertex>();
        edges = new ArrayList<Edge>();
        for (int i = 0; i < 11; i++) {
            Vertex location = new Vertex("Node_" + i, "Node_" + i);
            nodes.add(location);
        }

        addLane("Edge_0", 0, 1, 85);
        addLane("Edge_1", 0, 2, 217);
        addLane("Edge_2", 0, 4, 173);
        addLane("Edge_3", 2, 6, 186);
        addLane("Edge_4", 2, 7, 103);
        addLane("Edge_5", 3, 7, 183);
        addLane("Edge_6", 5, 8, 250);
        addLane("Edge_7", 8, 9, 84);
        addLane("Edge_8", 7, 9, 167);
        addLane("Edge_9", 4, 9, 502);
        addLane("Edge_10", 9, 10, 40);
        addLane("Edge_11", 1, 10, 600);

        // Lets check from location Loc_1 to Loc_10
        Graph graph = new Graph(nodes, edges);
        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(graph);
        dijkstra.execute(nodes.get(0));
        LinkedList<Vertex> path = dijkstra.getPath(nodes.get(10));

        assertNotNull(path);
        assertTrue(path.size() > 0);

        for (Vertex vertex : path) {
            System.out.println(vertex);
        }

    }

    private void addLane(String laneId, int sourceLocNo, int destLocNo,
            int duration) {
        Edge lane = new Edge(laneId,nodes.get(sourceLocNo), nodes.get(destLocNo), duration );
        edges.add(lane);
    }

    private void assertTrue(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
