import java.util.*;

class Graph {
    class Edge implements Comparable<Edge> {
        int src, dest, weight;
        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    };

  // Union
    class subset {
        int parent, rank;
    };

    int vertices, edges;
    Edge edge[];

    Graph(int v, int e) {
        vertices = v;
        edges = e;
        edge = new Edge[edges];
        for (int i = 0; i < e; ++i)
        edge[i] = new Edge();
    }

    void addEdge(int i, int i_src, int i_dest, int i_weight){
        this.edge[i].src = i_src;
        this.edge[i].dest = i_dest;
        this.edge[i].weight = i_weight;
    }

    int find(subset subsets[], int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    void Union(subset subsets[], int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    void KruskalAlgo() {
        Edge result[] = new Edge[vertices];
        int e = 0;
        int i = 0;
        for (i = 0; i < vertices; ++i)
            result[i] = new Edge();

    // Sorting the edges
        Arrays.sort(edge);
        subset subsets[] = new subset[vertices];
        for (i = 0; i < vertices; ++i)
            subsets[i] = new subset();

        for (int v = 0; v < vertices; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }
        i = 0;
        while (e < vertices - 1) {
            Edge next_edge = new Edge();
            next_edge = edge[i++];
            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);
            if (x != y) {
                result[e++] = next_edge;
                Union(subsets, x, y);
            }
        }
        for (i = 0; i < e; ++i)
            System.out.println(result[i].src + " to " + result[i].dest + " wright: " + result[i].weight);
    }

  public static void main(String[] args) {
    int vertices = 6; // Number of vertices
    int edges = 8; // Number of edges
    Graph G = new Graph(vertices, edges);

    G.addEdge(0, 0, 1, 4);
    G.addEdge(1, 0, 2, 4);
    G.addEdge(2, 1, 2, 2);
    G.addEdge(3, 2, 3, 3);
    G.addEdge(4, 2, 5, 2);
    G.addEdge(5, 2, 4, 7);
    G.addEdge(6, 3, 4, 3);
    G.addEdge(7, 5, 4, 3);
    
    G.KruskalAlgo();
    }
}