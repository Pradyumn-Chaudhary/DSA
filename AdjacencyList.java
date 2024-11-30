import java.util.*;
public class AdjacencyList {
    static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int src, int dest,int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void createGraph(int v, ArrayList<Edge> graph[]) {
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 2, 2));
        graph[1].add(new Edge(1, 2, 10));
        graph[1].add(new Edge(1, 3, 0));
        graph[2].add(new Edge(2, 0, 2));
        graph[2].add(new Edge(2, 1, 10));
        graph[2].add(new Edge(2, 3, -1));
        graph[3].add(new Edge(3, 1, 0));
        graph[3].add(new Edge(3, 2, -1));
    }

    public static void printAdjacencyList(int v, ArrayList<Edge> graph[]) {
        for (int i = 0; i < v; i++) {
            for (Edge edge : graph[i]) {
                System.out.print(edge.src + " -> " + edge.dest + "(" + edge.wt + "), ");
            }
            System.out.println();
        }
    }
    
    public static void printNeighbour(int s,ArrayList<Edge> graph[]) {
        if (s >= graph.length) {
            System.out.println("Invalid");
            return;
        }
        System.out.println("Neighbour of " + s + " is :");
        for (Edge edge : graph[s]) {
            System.out.println(edge.dest + ", (" + edge.wt + ")");
        }
    }
    public static void main(String args[]) {
        int v = 4;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(v, graph);
        printAdjacencyList(v, graph);
        printNeighbour(2,graph);
    }
}
