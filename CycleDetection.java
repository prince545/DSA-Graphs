import java.util.*;

public class CycleDetection {

    static class Edge {
        int src, dest;

        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // Add undirected edges
        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 0));

        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 1));

        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 2));

        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 3));

        // Uncomment this to add a cycle: 4 - 0
        // graph[4].add(new Edge(4, 0));
        // graph[0].add(new Edge(0, 4));
    }

    public static boolean hasCycle(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (dfs(graph, visited, i, -1)) {
                    return true; // cycle found
                }
            }
        }
        return false; // no cycle found
    }

    public static boolean dfs(ArrayList<Edge>[] graph, boolean[] visited, int curr, int parent) {
        visited[curr] = true;

        for (Edge e : graph[curr]) {
            if (!visited[e.dest]) {
                if (dfs(graph, visited, e.dest, curr)) {
                    return true;
                }
            } else if (e.dest != parent) {
                return true; // visited and not parent → cycle
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);

        System.out.println("Cycle exists: " + hasCycle(graph));
    }
}
