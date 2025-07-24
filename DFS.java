import java.util.*;

public class DFS {
    int vertices;
    List<Integer>[] adj;

    // Constructor
    public DFS(int v) {
        vertices = v;
        adj = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    // Method to add an edge (undirected)
    void addEdge(int v, int w) {
        adj[v].add(w);
       // Remove if you want directed graph
    }

    // DFS traversal starting from 'start' node
    void dfs(int start) {
        boolean[] visited = new boolean[vertices];
        System.out.println("DFS starting from node " + start + ":");
        dfsUtil(start, visited);
    }

    // Helper function for DFS
    void dfsUtil(int node, boolean[] visited) {
        visited[node] = true;
        System.out.print(node + " ");

        for (int neighbor : adj[node]) {
            if (!visited[neighbor]) {
                dfsUtil(neighbor, visited);
            }
        }
    }

    // Main method to test
    public static void main(String[] args) {
        DFS graph = new DFS(6);
        
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);

        graph.dfs(0);
    }
}
import java.util.*;

class Edge {
    int dest;

    Edge(int dest) {
        this.dest = dest;
    }
}

public class DFSExample {

    public static void dfs(List<Edge>[] graph, int curr, boolean[] vis) {
        // Visit
        System.out.print(curr + " ");
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.dest]) {
                dfs(graph, e.dest, vis);
            }
        }
    }

    public static void main(String[] args) {
        int V = 5; // Example number of vertices
        List<Edge>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        // Example graph edges
        graph[0].add(new Edge(1));
        graph[0].add(new Edge(2));
        graph[1].add(new Edge(3));
        graph[2].add(new Edge(4));

        boolean[] vis = new boolean[V];
        dfs(graph, 0, vis);
    }
}
