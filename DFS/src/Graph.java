import java.util.*;

class Graph {
    private LinkedList<Integer> adjLists[];
    private boolean visited[];

    static int[] discovers;
    static int[] finishes;
    static int time = 0;

    // Graph creation
    Graph(int vertices) {
        adjLists = new LinkedList[vertices];
        visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++)
            adjLists[i] = new LinkedList<Integer>();
    }

    // Add edges
    void addEdge(int src, int dest) {
        adjLists[src-1].add(dest);
    }


    void DFS(int vertex) {
        if(visited[vertex-1]) return;
        visited[vertex-1] = true;
        time++;
        discovers[vertex-1]=time;
        System.out.println(vertex + " ");
        Iterator<Integer> ite = adjLists[vertex-1].listIterator();
        while (ite.hasNext()) {
            int adj = ite.next();
            if (!visited[adj-1])
                DFS(adj);
        }
        time++;
        finishes[vertex-1]=time;
    }

    public static void main(String args[]) {
        /*
        1 -> 2,4
        2 -> 5
        3 -> 5,6
        4 -> 2
        5 -> 4
        6 -> 6
        */
        discovers=new int[6];
        finishes = new int[6];
        Graph g = new Graph(6);

        g.addEdge(1, 2);
        g.addEdge(1, 4);
        g.addEdge(2, 5);
        g.addEdge(3, 5);
        g.addEdge(3, 6);
        g.addEdge(4, 2);
        g.addEdge(5, 4);
        g.addEdge(6, 6);
        
        for(int i=1;i<=6;i++){
		    g.DFS(i);//start from 1
	    }

        for(int i=0;i<6;i++){
            System.out.println(i+1 + " discover: " + discovers[i] + " finish: "+ finishes[i]);
        }
    }
}
