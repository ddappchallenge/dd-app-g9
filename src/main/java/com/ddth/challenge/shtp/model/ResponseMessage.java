package com.ddth.challenge.shtp.model;

import java.util.List;

public class ResponseMessage {

    public void setMessage(String lastestMessage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setStatus(String ok) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public class Vertex {
    private final String id;
    private final String name;

    public Vertex(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vertex other = (Vertex) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return name;
        }
    }
    
    public class Edge  {
    private final String id;
    private final Vertex source;
    private final Vertex destination;
    private final int weight;

    public Edge(String id, Vertex source, Vertex destination, int weight) {
        this.id = id;
        this.source = source;
        this.destination = destination;
        this.weight = weight;
        }

    public String getId() {
        return id;
        }
    public Vertex getDestination() {
        return destination;
        }

    public Vertex getSource() {
        return source;
        }
    public int getWeight() {
        return weight;
        }

    @Override
    public String toString() {
        return source + " " + destination;
        }
    }
    
    public class Graph {
    private final List<Vertex> vertexes;
    private final List<Edge> edges;

    public Graph(List<Vertex> vertexes, List<Edge> edges) {
        this.vertexes = vertexes;
        this.edges = edges;
        }

    public List<Vertex> getVertexes() {
        return vertexes;
        }

    public List<Edge> getEdges() {
        return edges;
        }
    }
}
