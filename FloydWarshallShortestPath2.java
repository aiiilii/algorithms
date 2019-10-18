// 2nd practice

public class FloydWarshallShortestPath2 {

    final static int inf = 99999;
    final static int v = 4;

    public void floydWarshall(int graph[][]) {
        int dis[][] = new int[v][v];
        int i, j, k;

        for (i = 0; i < v; i++) {
            for (j = 0; j < v; j++) {
                dis[i][j] = graph[i][j];
            }
        }

        for (k = 0; k < v; k++) {
            for (i = 0; i < v; i++) {
                for (j = 0; j < v; j++) {
                    if (dis[i][j] > dis[i][k] + dis[k][j]) {
                        dis[i][j] = dis[i][k] + dis[k][j];
                    }
                }
            }
        }

        printSolution(dis);
    }

    public void printSolution(int dis[][]) {
        System.out.println("The following matrix has the shortest distance between every pair of vertices.");
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (dis[i][j] == inf) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dis[i][j] + "   ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int graph2[][] = { {0, 5, inf, 10},
                          {inf, 0, 3, inf},
                          {inf, inf, 0, 1},
                          {inf, inf, inf, 0}
                        };
        FloydWarshallShortestPath2 b = new FloydWarshallShortestPath2();
        b.floydWarshall(graph2);
    }
}