import java.util.*;

public class TopoSortDFS {
    static class Edge {
        int src, dest;
        Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // Build the graph
    static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    // DFS-based Topological Sort
    static void topologicalSort(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                dfs(graph, i, visited, stack);
            }
        }

        // Print result (reverse of finishing times)
        System.out.print("Topological Order: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    static void dfs(ArrayList<Edge>[] graph, int curr, boolean[] visited, Stack<Integer> stack) {
        visited[curr] = true;

        for (Edge e : graph[curr]) {
            if (!visited[e.dest]) {
                dfs(graph, e.dest, visited, stack);
            }
        }

        stack.push(curr); // Add to stack after visiting all neighbors
    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);
        topologicalSort(graph);
    }
}
