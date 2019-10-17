// import java.util.*;
// import java.lang.*;
// import java.io.*;

public class FloydWarshallShortestPath{
    final static int inf = 99999;
    final static int v = 4;

    public void floydWarshall(int graph[][]) {
        int dist[][] = new int[v][v];
        int i, j, k;

        for (i = 0; i < v; i++) {
            for (j = 0; j < v; j++) {
                dist[i][j] = graph[i][j];
            } 
        }

        for (k = 0; k < v; k++) {
            for (i = 0; i < v; i++) {
                for (j = 0; j < v; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        printSolution(dist);
    }

    public void printSolution(int dist[][]) {
        System.out.println("The following matrix shows the shortest distances between every pair of vertices");

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (dist[i][j] == inf) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + "   ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int graph[][] = { {0, 5, inf, 10},
                          {inf, 0, 3, inf},
                          {inf, inf, 0, 1},
                          {inf, inf, inf, 0}
                        };
        FloydWarshallShortestPath a = new FloydWarshallShortestPath();

        a.floydWarshall(graph);
    }
}