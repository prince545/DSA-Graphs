import java.util.*;

public class AllPathsDFS {

    // Define Edge class to represent each directed edge
    static class Edge {
        int src;
        int dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // Function to build the graph as an adjacency list
    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add edges (example graph)
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 5));
        // You can add more edges here to make a complex graph
    }

    // Function to print all paths from src to dest
    public static void printAllPaths(ArrayList<Edge>[] graph, int src, int dest, String path) {
        if (src == dest) {
            System.out.println(path + dest);
            return;
        }

        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            printAllPaths(graph, e.dest, dest, path + src + " -> ");
        }
    }

    // Main method to run the code
    public static void main(String[] args) {
        int V = 6; // Number of vertices
        ArrayList<Edge>[] graph = new ArrayList[V];
        createGraph(graph);

        int source = 0;
        int destination = 5;

        System.out.println("All paths from " + source + " to " + destination + ":");
        printAllPaths(graph, source, destination, "");
    }
}
