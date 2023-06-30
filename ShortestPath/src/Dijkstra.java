import java.util.Arrays;

public class Dijkstra {

  private static final int INF = Integer.MAX_VALUE;

  public static void dijkstra(int[][] graph, int source) {
    int n = graph.length;
    int[] dist = new int[n];            // array to store shortest distances
    int[] pares = new int[n];            //predecessor
    boolean[] visited = new boolean[n]; // array to mark visited nodes
    Arrays.fill(dist, INF);             // initialize distances as infinity
    dist[source] = 0;                   // distance from source to source is 0
    pares[source] = source;

    for (int i = 0; i < n - 1; i++) {
      // select the vertex with the minimum distance
      int u = extractMin(dist, visited);
      visited[u] = true; // mark the vertex as visited

      // relaxation
      for (int v = 0; v < n; v++) {
        if (
          !visited[v] &&
          graph[u][v] != 0 &&
          dist[u] != INF &&
          dist[u] + graph[u][v] < dist[v]
        ) {
          pares[v]=u;
          dist[v] = dist[u] + graph[u][v];
        }
      }
    }
    printDistances(dist, source, pares); // print the shortest distances
  }

  // find the vertex with the minimum distance
  private static int extractMin(int[] dist, boolean[] visited) {
    int minDist = INF;
    int minVertex = -1;
    for (int i = 0; i < dist.length; i++) {
      if (!visited[i] && dist[i] < minDist) {
        minDist = dist[i];
        minVertex = i;
      }
    }
    return minVertex;
  }

  // print the shortest distances
  private static void printDistances(int[] dist, int source, int[] pred) {
    System.out.println("Shortest path:");
    for (int i = 0; i < dist.length; i++) {
      System.out.println("Source: "+ source + " to Vertex " + i + "\'s distance: " + dist[i] + "   predecessor: "+ pred[i]);
    }
  }

  public static void main(String[] args) {
    int[][] graph = {
      { 0, 5, 0, 0, 9, 0, 0, 8 },
      { 0, 0, 12,15,0, 0, 0, 4 },
      { 0, 0, 0, 3, 0, 0, 11,0 },
      { 0, 0, 0, 0, 0, 0, 9, 0 },
      { 0, 0, 0, 0, 0, 4, 20,5 },
      { 0, 0, 1, 0, 0, 0, 13,0 },
      { 0, 0, 0, 0, 0, 0, 0, 0 },
      { 0, 0, 7, 0, 0, 6, 0, 0 },
    };
    dijkstra(graph, 0);
  }
}
