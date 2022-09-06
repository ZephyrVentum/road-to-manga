package utils;

import java.util.*;

public class Graphs {
    public static final String NODE_A = "A";
    public static final String NODE_B = "B";
    public static final String NODE_C = "C";
    public static final String NODE_D = "D";
    public static final String NODE_E = "E";
    public static final String NODE_F = "F";
    public static final String NODE_G = "G";

    public static Map<String, Set<String>> getDefaultGraph() {
        Map<String, Set<String>> graph = new HashMap<>();
        Set<String> nodeA = new HashSet<>();
        Collections.addAll(nodeA, NODE_B, NODE_G, NODE_C);
        graph.put(NODE_A, nodeA);
        Set<String> nodeB = new HashSet<>();
        Collections.addAll(nodeB, NODE_E);
        graph.put(NODE_B, nodeB);
        Set<String> nodeG = new HashSet<>();
        Collections.addAll(nodeG, NODE_E, NODE_C);
        graph.put(NODE_G, nodeG);
        Set<String> nodeC = new HashSet<>();
        Collections.addAll(nodeC, NODE_D);
        graph.put(NODE_C, nodeC);
        Set<String> nodeE = new HashSet<>();
        Collections.addAll(nodeE, NODE_C, NODE_F);
        graph.put(NODE_E, nodeE);
        Set<String> nodeF = new HashSet<>();
        Collections.addAll(nodeF, NODE_D);
        graph.put(NODE_F, nodeF);
        Set<String> nodeD = new HashSet<>();
        graph.put(NODE_D, nodeD);
        return graph;
    }

    public static Map<String, Map<String, Integer>> getDefaultWeightedGraph() {
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        Map<String, Integer> nodeA = new HashMap<>();
        nodeA.put(NODE_B, 2);
        nodeA.put(NODE_C, 4);
        graph.put(NODE_A, nodeA);
        Map<String, Integer> nodeB = new HashMap<>();
        nodeB.put(NODE_E, 3);
        nodeB.put(NODE_C, 1);
        graph.put(NODE_B, nodeB);
        Map<String, Integer> nodeC = new HashMap<>();
        nodeC.put(NODE_E, 4);
        nodeC.put(NODE_F, 3);
        nodeC.put(NODE_D, 8);
        graph.put(NODE_C, nodeC);
        Map<String, Integer> nodeD = new HashMap<>();
        graph.put(NODE_D, nodeD);
        Map<String, Integer> nodeE = new HashMap<>();
        nodeE.put(NODE_F, 2);
        graph.put(NODE_E, nodeE);
        Map<String, Integer> nodeF = new HashMap<>();
        nodeF.put(NODE_D, 1);
        graph.put(NODE_F, nodeF);
        return graph;
    }

    public static Map<String, Map<String, Integer>> getNegativeShortWeightedGraph() {
        Map<String, Map<String, Integer>> graph = new HashMap<>();
        Map<String, Integer> nodeA = new HashMap<>();
        nodeA.put(NODE_B, 5);
        nodeA.put(NODE_C, 0);
        graph.put(NODE_A, nodeA);
        Map<String, Integer> nodeB = new HashMap<>();
        nodeB.put(NODE_C, -7);
        graph.put(NODE_B, nodeB);
        Map<String, Integer> nodeC = new HashMap<>();
        nodeC.put(NODE_D, 35);
        graph.put(NODE_C, nodeC);
        Map<String, Integer> nodeD = new HashMap<>();
        graph.put(NODE_D, nodeD);
        return graph;
    }
}

