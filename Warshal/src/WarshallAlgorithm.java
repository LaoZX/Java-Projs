import java.util.Arrays;

public class WarshallAlgorithm {
    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 0, 0, 1, 1, 0, 1},
                {0, 0, 1, 0, 0, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 1, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 1, 1, 0}
        };

        int[][] transitiveClosure = computeTransitiveClosure(graph);

        System.out.println("Transitive Closure:");
        for (int[] row : transitiveClosure) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] computeTransitiveClosure(int[][] graph) {
        int n = graph.length;
        int[][] closure = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                closure[i][j] = graph[i][j];
                if(i==j){
                    closure[i][j]=1;
                }
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    closure[i][j] = closure[i][j] | (closure[i][k] & closure[k][j]);
                }
            }
        }

        return closure;
    }
}

