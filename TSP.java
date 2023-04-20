import java.util.Arrays;

public class TSP {
    private static final int INF = Integer.MAX_VALUE;

    public static int tsp(int[][] graph) {
        int n = graph.length;
        int[][] memo = new int[n][1 << n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return tspHelper(graph, 0, 1, memo);
    }

    private static int tspHelper(int[][] graph, int currCity, int visitedCities, int[][] memo) {
        if (visitedCities == (1 << graph.length) - 1) {
            return graph[currCity][0];
        }
        if (memo[currCity][visitedCities] != -1) {
            return memo[currCity][visitedCities];
        }
        int minDist = INF;
        for (int nextCity = 0; nextCity < graph.length; nextCity++) {
            if ((visitedCities & (1 << nextCity)) == 0) {
                int newVisitedCities = visitedCities | (1 << nextCity);
                int newDist = graph[currCity][nextCity] + tspHelper(graph, nextCity, newVisitedCities, memo);
                minDist = Math.min(minDist, newDist);
            }
        }
        memo[currCity][visitedCities] = minDist;

        return minDist;
    }

    public static void main(String[] args) {
        int[][] graph = {
                { 0, 20, 25, 10 },
                { 20, 0, 15, 25 },
                { 15, 45, 0, 30 },
                { 20, 25, 30, 0 }
        };
        int shortestDist = tsp(graph);
        System.out.println("Shortest distance: " + shortestDist);
    }
}
