import java.util.*;

class Edge {
    int src, dest, wt;

    public Edge(int s, int d, int w) {
        this.src = s;
        this.dest = d;
        this.wt = w;
    }
}

public class Classroom {
    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];

        // Initialize each vertex's list
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add edges based on the diagram
        graph[0].add(new Edge(0, 1, 5));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 3, 3));

        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 2));

        graph[3].add(new Edge(3, 4, 1));

        // Print the graph
        for (int i = 0; i < V; i++) {
            System.out.print("Vertex " + i + ": ");
            for (Edge e : graph[i]) {
                System.out.print("-> (" + e.dest + ", wt: " + e.wt + ") ");
            }
            System.out.println();
        }
    }
}
