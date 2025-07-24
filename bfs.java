import java.util.*;

public class BFS {
    int vertices;
    LinkedList<Integer>[] adj;

    // Constructor
    public BFS(int v) {
        vertices = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // Method to add an edge
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    // BFS traversal
    void bfs(int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            System.out.print(curr + " ");

            for (int neighbor : adj[curr]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    // Main method to test
    public static void main(String[] args) {
        BFS graph = new BFS(6);
        
        graph.addEdge(1, 3);
        graph.addEdge(1, 5);
        
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);

        System.out.println("BFS starting from node 0:");
        graph.bfs(0);
    }
}
