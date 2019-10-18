public class DijkstraShortestPath2 {

    final static int v = 9;

    public void dijkstra(int graph[][], int src) {
        int dis[] = new int[v];
        Boolean visited[] = new Boolean[v];

        for (int u = 0; u < v; u++) {
            dis[u] = Integer.MAX_VALUE;
            visited[u] = false;
        }
        dis[src] = 0;

        for (int count = 0; count < v - 1; count ++) {
            int i = findMinDistance(dis, visited);
            visited[i] = true;
            for (int j= 0; j < v; j++) {
                if (!visited[j] && graph[i][j] != 0 && dis[i] != Integer.MAX_VALUE && dis[i] + graph[i][j] < dis[j]) {
                    dis[j] = dis[i]  + graph[i][j];
                }
            }
        }
        printSolution(dis);
    }

    public int findMinDistance(int dis[], Boolean visited[]) {
        int min = Integer.MAX_VALUE;
        int minAdjacent = -1;

        for (int m = 0; m < v; m++) {
            if (visited[m] == false && dis[m] <= min) {
                min = dis[m];
                minAdjacent = m;
            }
        }
        return minAdjacent;
    }

    public void printSolution(int dis[]) {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < v; i++) {
            System.out.println(i + " \t\t " + dis[i]);
        }
    }

    public static void main(String[] args) {
        int graph2[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, 
                                      { 4, 0, 8, 0, 0, 0, 0, 11, 0 }, 
                                      { 0, 8, 0, 7, 0, 4, 0, 0, 2 }, 
                                      { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, 
                                      { 0, 0, 0, 9, 0, 10, 0, 0, 0 }, 
                                      { 0, 0, 4, 14, 10, 0, 2, 0, 0 }, 
                                      { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, 
                                      { 8, 11, 0, 0, 0, 0, 1, 0, 7 }, 
                                      { 0, 0, 2, 0, 0, 0, 6, 7, 0 } 
                                    };
        DijkstraShortestPath2 d = new DijkstraShortestPath2();
        d.dijkstra(graph2, 3);
    }
}