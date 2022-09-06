package tree;


import utils.Graphs;
import utils.Pair;

import java.util.*;

public class BreadthFirstSearch {

    public static void main(String[] args) {
        String start = Graphs.NODE_A;
        Map<String, Set<String>> graph = Graphs.getDefaultGraph();
        Deque<String> deque = new ArrayDeque<>();
        Map<String, Integer> steps = new HashMap<>();
        List<Pair<String, String>> path = new ArrayList<>();
        Set<String> visitedNodes = new HashSet<>();
        graph.get(start).forEach((k) -> {
            computePathAndSteps(deque, steps, path, start, k);
        });

        while (!deque.isEmpty()) {
            String node = deque.pop();
            if (!visitedNodes.contains(node)) {
                visitedNodes.add(node);
                Set<String> neighbors = graph.get(node);
                for (String k : neighbors) {
//                    System.out.println("Neighbor " + k);
                    computePathAndSteps(deque, steps, path, node, k);
                }
//                deque.addAll(graph.get(node));
            }
            System.out.println(node + " _ " + deque);
        }
        System.out.println(steps);
        System.out.println(path);
    }

    static void computePathAndSteps(Deque<String> deque,
                                    Map<String, Integer> steps,
                                    List<Pair<String, String>> path,
                                    String currentNode,
                                    String neighborNode) {
        Integer stepsToNeighbor = steps.get(neighborNode);
        if (stepsToNeighbor == null) {
            stepsToNeighbor = Integer.MAX_VALUE;
        }
        Integer stepsToThisNode = steps.get(currentNode);
        if (stepsToThisNode == null) {
            stepsToThisNode = 0;
        }
        int newStepsToNeighbor = stepsToThisNode + 1;
        if (newStepsToNeighbor <= stepsToNeighbor) {
            path.add(new Pair<>(neighborNode, currentNode));
            steps.put(neighborNode, newStepsToNeighbor);
//                        System.out.println("Added " + k + " " + newStepsToNeighbor);
        }
        deque.addLast(neighborNode);
    }

}