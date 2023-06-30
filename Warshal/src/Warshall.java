import java.util.Scanner;
 
public class Warshall
{
    private int V;    
    private boolean[][] tc;
    /* make the transitive closure */
    public void getTC(int[][] graph)
    {
        this.V = graph.length;
        tc = new boolean[V][V];
        for (int i = 0; i < V; i++) 
        {    
            for (int j = 0; j < V; j++) 
                if (graph[i][j] != 0 || i==j){
                    tc[i][j] = true;
                }
                    
        }
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    tc[i][j] = tc[i][j] | (tc[i][k] & tc[k][j]);
                }
            }
        }
    }
    /* Funtion to display the trasitive closure */
    public void displayTC()
    {
        System.out.println("\nTransitive closure :\n");
        System.out.print(" ");
        for (int v = 0; v < V; v++)
           System.out.print("   " + v );
        System.out.println();
        for (int v = 0; v < V; v++) 
        {
            System.out.print(v +" ");
            for (int w = 0; w < V; w++) 
            {
                if (tc[v][w]) 
                    System.out.print("  * ");
                else                  
                    System.out.print("    ");
            }
            System.out.println();
        }
    }    
 
    public static void main (String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Warshall Algorithm Test\n");
        /** Make an object of Warshall class **/
        Warshall w = new Warshall();
 
        /** Accept number of vertices **/
        System.out.println("Enter number of vertices\n");
        int V = scan.nextInt();
 
        /** get graph **/
        System.out.println("\nEnter matrix\n");
        int[][] graph = new int[V][V];
        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                graph[i][j] = scan.nextInt();
 
        w.getTC(graph);
        w.displayTC();
    }
}