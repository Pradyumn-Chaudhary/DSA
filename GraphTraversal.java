import java.util.*;

public class GraphTraversal {
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
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));
        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));
        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));
        graph[6].add(new Edge(6, 5));
    }

    public static void printList(int v, ArrayList<Edge> graph[]) {
        System.out.println("Adjacency List:");
        for (int i = 0; i < v; i++) {
            for (Edge edge : graph[i]) {
                System.out.println(edge.src + " -> " + edge.des);
            }
        }
    }

    public static void printNeighbour(int s, ArrayList<Edge> graph[]) {
        if (s >= graph.length) {
            System.out.println("Invalid");
            return;
        }
        System.out.println("Neighbours of " + s + " is:");
        for (Edge edge : graph[s]) {
            System.out.println(edge.des);
        }
    }

    public static void BFS(int v, ArrayList<Edge> graph[], int start) {
        if (v < 1 || start >= v) {
            return;
        }
        System.out.println("Breadth First Search");
        Queue<Integer> queue = new LinkedList<>();
        boolean arr[] = new boolean[v];
        queue.add(start);
        arr[start] = true;
        while (!queue.isEmpty()) {
            System.out.print(queue.peek());
            for (Edge edge : graph[queue.peek()]) {
                if (arr[edge.des] == false) {
                    queue.add(edge.des);
                    arr[edge.des] = true;
                }
            }
            queue.remove();
            if (!queue.isEmpty()) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    public static void DFS(int v, ArrayList<Edge> graph[], int start) {
        if (v < 1 || start >= v) {
            return;
        }
        System.out.println("Depth First Search:");
        Stack<Integer> stack = new Stack<>();
        boolean arr[] = new boolean[v];
        stack.push(start);
        arr[start] = true;
        while (!stack.isEmpty()) {
            int temp = stack.pop();
            System.out.print(temp);
            for (Edge edge : graph[temp]) {
                if (arr[edge.des] == false) {
                    stack.push(edge.des);
                    arr[edge.des] = true;
                }
            }
            if (!stack.isEmpty()) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    public static void DFSrecursive(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        System.out.print(curr + " ");
        vis[curr] = true;
        for (Edge edge : graph[curr]) {
            if (vis[edge.des] == false) {
                DFSrecursive(graph, edge.des, vis);
           }
        }
    }
    public static void main(String[] args) {
        int v = 7;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(v, graph);
        /*
             _ 1 --- 3 _
            /        |  \
          0          |   5 --- 6
           \         | /
            2 -------4
        */
        // printList(v, graph);
        // printNeighbour(5, graph);
        BFS(v, graph,0);
        DFS(v, graph, 0);
        boolean vis[] = new boolean[v];
        DFSrecursive(graph, 0, vis);
        System.out.println();
    }
}
