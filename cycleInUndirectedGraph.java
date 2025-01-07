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
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 3));
        // graph[3].add(new Edge(3, 1));
    }
    
    public static boolean isCycle(ArrayList<Edge> graph[],int curr,boolean  vis[],boolean  rec[]) {
        vis[curr] = true;
        rec[curr] = true;
        for (Edge edge : graph[curr]) {
            if (rec[edge.des] || !vis[edge.des] && isCycle(graph, edge.des, vis, rec)) {
                return true;
            }
        }
        rec[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(v, graph);
        /*
        0 ----->1<----3
                d\  u/
                   2
        */
        boolean vis[] = new boolean[v];
        boolean rec[] = new boolean[v];
        boolean cycle = isCycle(graph, 0, vis, rec);
        System.out.println(cycle);
    }
}
