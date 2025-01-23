import java.util.ArrayList;

class cycleInDirectedGraph {

    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public static void createGraph(int v, ArrayList<Edge> graph[]) {
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 0));
    }

    public static boolean cycleDirected(boolean vis[], boolean recursionStack[], int curr, ArrayList<Edge> graph[]) {
        vis[curr] = true;
        recursionStack[curr] = true;
        for (Edge e : graph[curr]) {
            if (recursionStack[e.dest]) {
                return true;
            }
            if (!vis[e.dest]) {
                if (cycleDirected(vis, recursionStack, e.dest, graph)) {
                    return true;
                }
            }
        }
        recursionStack[curr] = false;
        return false;
    }

    public static void main(String[] args) {
        int v = 4;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(v, graph);

        boolean vis[] = new boolean[v];
        boolean recursionStack[] = new boolean[v];

        boolean isCycle = false;

        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                if (cycleDirected(vis, recursionStack, i, graph)) {
                    isCycle = true;
                    break;
                }
            }
        }
        if (isCycle) {
            System.out.println("Cycle Detected");
        } else {
            System.out.println("No Cycle Detected");
        }
    }
}