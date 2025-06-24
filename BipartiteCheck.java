import java.util.*;

public class BipartiteCheck {

    public static boolean isBipartite(ArrayList<Integer>[] graph) {
        int V = graph.length;
        int[] color = new int[V];
        Arrays.fill(color, -1); // -1 means unvisited

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!bfsCheck(graph, i, color)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean bfsCheck(ArrayList<Integer>[] graph, int start, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0; // Assign color 0 to start

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int neighbor : graph[node]) {
                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[node]; // Assign opposite color
                    q.add(neighbor);
                } else if (color[neighbor] == color[node]) {
                    return false; // Same color as neighbor → not bipartite
                }
            }
        }

        return true;
    }

    // Example usage
    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] graph = new ArrayList[V];
        for (int i = 0; i < V; i++) graph[i] = new ArrayList<>();

        // Add edges (undirected)
        graph[0].add(1); graph[1].add(0);
        graph[1].add(2); graph[2].add(1);
        graph[2].add(3); graph[3].add(2);
        graph[3].add(4); graph[4].add(3);
        graph[4].add(0); graph[0].add(4); // This creates an odd cycle → not bipartite

        if (isBipartite(graph)) {
            System.out.println("Graph is Bipartite");
        } else {
            System.out.println("Graph is NOT Bipartite");
        }
    }
}