package tree;

import utils.Graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Dijkstra {
    public static void main(String[] args) {

        String start = Graphs.NODE_A;
        Map<String, String> path = new HashMap<>();
        Map<String, Map<String, Integer>> graph = Graphs.getNegativeShortWeightedGraph();
        Map<String, Integer> weights = new HashMap<>(graph.get(start));
        HashSet<String> visitedNodes = new HashSet<>();
        graph.get(start).forEach((k, v) -> {
            path.put(k, start);
        });

        while (true) {
            String node = getUnvisitedNodeWithMinWeight(weights, visitedNodes);
            if (node.isEmpty()) {
                break;
            } else {
                visitedNodes.add(node);
                int weight = weights.get(node);
                for (Map.Entry<String, Integer> entry : graph.get(node).entrySet()) {
                    String k = entry.getKey();
                    Integer v = entry.getValue();
                    int newWeight = v + weight;
                    Integer currentWeight = weights.get(k);
                    if (currentWeight == null || newWeight < currentWeight) {
                        weights.put(k, newWeight);
                        path.put(k, node);
                    }
                }
            }
        }
        System.out.println(path);
        System.out.println(weights);
    }

    static String getUnvisitedNodeWithMinWeight(Map<String, Integer> weights, HashSet<String> visitedNodes) {
        String minNode = "";
        int min = Integer.MAX_VALUE;
        for (Map.Entry<String, Integer> entry : weights.entrySet()) {
            String k = entry.getKey();
            Integer v = entry.getValue();
            if (!visitedNodes.contains(k) && v < min) {
                min = v;
                minNode = k;
            }
        }
        return minNode;
    }
}