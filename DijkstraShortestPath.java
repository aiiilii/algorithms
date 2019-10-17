//import java.util.*;
//import java.lang.*;
//import java.io.*;

public class DijkstraShortestPath{

    final static int v = 9;

    public int findMinDistance(int dist[], Boolean vistited[]) {
        int min = Integer.MAX_VALUE;
        int min_index = -1;

        for (int m = 0; m < v; m++) {
            if (vistited[m] == false && dist[m] <= min) {
                min = dist[m];
                min_index = m;
            }
        }
        return min_index;
    }

    public void printSolution(int dist[]) {
        System.out.println("Vertex \t\t  Distance from Source");
        for (int i = 0; i < v; i++) {
            System.out.println(i + " \t\t " + dist[i]);
        }
    }

    public void dijkstra(int graph[][], int src) {
        int dist[] = new int[v];

        Boolean visited[] = new Boolean[v];

        for (int u = 0; u < v; u++) {
            dist[u] = Integer.MAX_VALUE;
            visited[u] = false;
        }

        dist[src] = 0;

        for (int count = 0; count < v - 1; count ++) {
            int i = findMinDistance(dist, visited);
            visited[i] = true;
            for (int j = 0; j < v; j++) {
                // j is not in circle; i to j cannot be same node to same node, which is what = 0 means; src to i cannot have no linkage or else cannot pass through i; 
                // and combined distances should be shorter than direct distance, which sometimes is int max value
                if (!visited[j] && graph[i][j] != 0 && dist[i] != Integer.MAX_VALUE && dist[i] + graph[i][j] < dist[j]) {
                    dist[j] = dist[i] + graph[i][j];
                }
            }
        }
        printSolution(dist);
    }

    public static void main(String[] args) {
        int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
                                      { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
                                      { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
                                      { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
                                      { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
                                      { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
                                      { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
                                      { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
                                      { 0, 0, 2, 0, 0, 0, 6, 7, 0 } 
                                    };
        DijkstraShortestPath t = new DijkstraShortestPath();
        t.dijkstra(graph, 0);
    }

}