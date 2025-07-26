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
