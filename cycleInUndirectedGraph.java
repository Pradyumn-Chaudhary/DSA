import java.util.*;

public class cycleInUndirectedGraph {
    static class Edge {
        int src;
        int des;

        Edge(int src, int des) {
            this.src = src;
            this.des = des;
        }
    }

    public static void createGraph(int v, ArrayList<Edge> graph[]) {
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1));
        graph[1].add(new Edge(1, 0));

        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 1));

        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 2));

        graph[3].add(new Edge(3, 1));
        graph[1].add(new Edge(1, 3));
    }

    public static boolean isCycle(ArrayList<Edge> graph[], int curr, boolean vis[], int parent) {
        vis[curr] = true;

        for (Edge edge : graph[curr]) {
            int neighbor = edge.des;

            if (!vis[neighbor]) {
                // If the neighbor is not visited, continue DFS
                if (isCycle(graph, neighbor, vis, curr)) {
                    return true;
                }
            } else if (neighbor != parent) {
                // If the neighbor is visited and is not the parent, it's a cycle
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(v, graph);

        /*
        0 -----> 1 <---- 3
                |       /
                ------ 2
        */

        boolean vis[] = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                if (isCycle(graph, i, vis, -1)) {
                    System.out.println("Cycle detected");
                    return;
                }
            }
        }
        System.out.println("No cycle detected");
    }
}
