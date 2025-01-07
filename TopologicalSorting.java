import java.util.*;

public class TopologicalSorting {
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
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }

    // Topological Sorting can only performed for Directed Acyclic Graphs(DAGs)
    public static void topologicalSorting(int curr, ArrayList<Edge> graph[], boolean vis[], Stack<Integer> s) {
        vis[curr] = true;
        for (Edge edge : graph[curr]) {
            if (!vis[edge.des]) {
                topologicalSorting(edge.des, graph, vis, s);
            }
        }
        s.push(curr);
    }
    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(v, graph);
        boolean vis[] = new boolean[v];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                topologicalSorting(i, graph, vis, s);
            }
        }
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }
}
