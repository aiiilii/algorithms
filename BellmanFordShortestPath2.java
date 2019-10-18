public class BellmanFordShortestPath2{

    public void bellmanFord(int graph[][], int v, int e, int src) {
        int dis[] = new int[v];
        for (int i = 0; i < v; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        dis[src] = 0;

        for (int i = 0; i < v - 1; i++) {
            for (int j = 0; j < e; j++) {
                if (dis[graph[j][0]] + graph[j][2] < dis[graph[j][1]]) {
                    dis[graph[j][1]] = dis[graph[j][0]] + graph[j][2];
                }
            }
        }

        for (int i = 0; i < e; i++) {
            if (dis[graph[i][0]] != Integer.MAX_VALUE && dis[graph[i][0]] + graph[i][2] < dis[graph[i][1]]) {
                System.out.println("Graph contains negative weighted cycle.");
                return;
            }
        }
        System.out.println("Vertex Distance from Source:");
        for (int i = 0; i < v; i++) {
            System.out.println(i + " \t\t " + dis[i]);
        }
    }

    public static void main(String[] args) {
        int v = 5;
        int e = 8;
        int graph[][] = new int[][] { { 0, 1, -1 }, { 0, 2, 4 }, 
                                      { 1, 2, 3 }, { 1, 3, 2 },  
                                      { 1, 4, 2 }, { 3, 2, 5 },  
                                      { 3, 1, 1 }, { 4, 3, -3 } }; 
        BellmanFordShortestPath2 b = new BellmanFordShortestPath2();
        b.bellmanFord(graph, v, e, 0);
    }
}