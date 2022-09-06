package tree;

import utils.Graphs;

import java.util.HashMap;
import java.util.Map;


public class MyGraphSearch {
//    static Integer resultWeight = Integer.MAX_VALUE;
//    static Map<String, String> resultPath = new HashMap<>();


    public static void main(String[] args) {
        String start = Graphs.NODE_A;
        Map<String, Map<String, Integer>> graph = Graphs.getDefaultWeightedGraph();
        Map<String, String> path = new HashMap<>();
        Map<String, Integer> weights = new HashMap<>(graph.get(start));
        Map<String, Integer> todo = new HashMap<>(graph.get(start));
        graph.get(start).forEach((k, v) -> {
            path.put(k, start);
        });
        while (!todo.isEmpty()) {
            String node = ((Map.Entry<String, Integer>) todo.entrySet().toArray()[0]).getKey();
            int weight = todo.remove(node);
            Map<String, Integer> neighbors = new HashMap<>(graph.get(node));
            neighbors.forEach((neighborNode, neighborWeight) -> {
                Integer weightInTodo = todo.get(neighborNode);
                int newWeight = weight + neighborWeight;
                if (weightInTodo == null || newWeight < weightInTodo) {
                    todo.put(neighborNode, newWeight);
                }
                Integer currentWeight = weights.get(neighborNode);
                if (currentWeight == null || newWeight < currentWeight) {
                    weights.put(neighborNode, newWeight);
                    path.put(neighborNode, node);
                }
            });
        }
        System.out.println(path);
        System.out.println(weights);
    }

//    public static void main(String[] args) {
//        String from = Graphs.NODE_A;
//        String to = Graphs.NODE_D;
//        Map<String, Map<String, Integer>> graph = Graphs.getDefaultWeightedGraph();
//        Pair<Map<String, String>, Integer> result = search(from, to, graph);
//        System.out.println(result);
//    }
//
//    static Pair<Map<String, String>, Integer> search(String from, String to, Map<String, Map<String, Integer>> graph) {
//        Map<String, String> path = new HashMap<>();
//        Map<String, Integer> todo = new HashMap<>(graph.get(from));
//        todo.forEach((k, v) -> {
//            path.put(k, from);
//        });
//        System.out.println("Start from: " + from);
//        System.out.println("Path: " + path);
//        System.out.println("TODO: " + todo + '\n');
//
//        while (!todo.isEmpty()) {
//            String currentNode = ((Map.Entry<String, Integer>) todo.entrySet().toArray()[0]).getKey();
//            int currentWeight = todo.remove(currentNode);
//            System.out.println("Current node is: " + currentNode + " current weight: " + currentWeight);
//            if (!currentNode.equals(to)) {
//                Map<String, Integer> neighbors = new HashMap<>(graph.get(currentNode));
//                neighbors.forEach((neighborNode, neighborWeight) -> {
//                    System.out.println("Neighbor: " + neighborNode);
//                    Integer weightInTodo = todo.get(neighborNode);
//                    int newWeight = currentWeight + neighborWeight;
//                    if (weightInTodo == null) {
//                        todo.put(neighborNode, newWeight);
//                        path.put(neighborNode, currentNode);
//                    } else if (newWeight < weightInTodo) {
//                        todo.put(neighborNode, newWeight);
//                        path.put(neighborNode, currentNode);
//                    }
////                    else {
////                        path.remove(currentNode);
////                    }
//                    if (neighborNode.equals(to) && newWeight < resultWeight) {
//                        resultPath = new HashMap<>(path);
//                        resultWeight = newWeight;
//                    }
//                    System.out.println("Path: " + path);
//                    System.out.println("TODO: " + todo + '\n');
//                });
//            }
//
//        }
//        return new Pair<>(normalizePath(resultPath, from, to), resultWeight);
//    }
//
//    static Map<String, String> normalizePath(Map<String, String> resultPath, String from, String to) {
//        Map<String, String> normalizedPath = new HashMap<>();
//        String node = resultPath.get(to);
//        if (node != null) {
//            normalizedPath.put(node, to);
//            while (!node.equals(from)) {
//                String temp = node;
//                node = resultPath.get(node);
//                normalizedPath.put(node, temp);
//            }
//        }
//        return normalizedPath;
//    }
}
