import java.util.*;

public class DirectedCycleDetection {

    static class Edge {
        int src, dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Sample edges (Directed)
        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1)); // Cycle here (1 -> 2 -> 3 -> 1)
    }

    public static boolean hasCycle(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        boolean[] recStack = new boolean[graph.length]; // recursion stack

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (dfs(graph, visited, recStack, i)) {
                    return true; // cycle detected
                }
            }
        }

        return false;
    }

    public static boolean dfs(ArrayList<Edge>[] graph, boolean[] visited, boolean[] recStack, int curr) {
        visited[curr] = true;
        recStack[curr] = true;

        for (Edge e : graph[curr]) {
            if (!visited[e.dest]) {
                if (dfs(graph, visited, recStack, e.dest)) {
                    return true;
                }
            } else if (recStack[e.dest]) {
                return true; // back edge → cycle
            }
        }

        recStack[curr] = false; // backtrack
        return false;
    }

    public static void main(String[] args) {
        int V = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        if (hasCycle(graph)) {
            System.out.println("Cycle detected in directed graph");
        } else {
            System.out.println("No cycle found");
        }
    }
}
