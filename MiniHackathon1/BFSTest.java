import java.util.LinkedList;
import java.util.Queue;

class Graph {
    private int V; // Number of vertices
    private LinkedList<Integer>[] adjacencyList; // Adjacency list representation

    public Graph(int v) {
        V = v;
        adjacencyList = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adjacencyList[i] = new LinkedList();
        }
    }

    // Add an edge to the graph
    void addEdge(int v, int w) {
        adjacencyList[v].add(w);
    }

    // BFS traversal starting from a given source vertex
    void BFS(int s) {
        // Mark all vertices as not visited
        boolean[] visited = new boolean[V];

        // Create a queue for BFS
        Queue<Integer> queue = new LinkedList<>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while (!queue.isEmpty()) {
            // Dequeue a vertex from the queue and print it
            s = queue.poll();
            System.out.print(s + " ");

            // Get all adjacent vertices of the dequeued vertex s
            // If an adjacent vertex has not been visited, mark it visited and enqueue it
            for (Integer neighbor : adjacencyList[s]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("BFS starting from vertex 2:");
        g.BFS(2);
    }
}
