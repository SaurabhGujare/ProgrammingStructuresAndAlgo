package HW11Que7;

import javafx.util.Pair;

import java.util.ArrayList;

/**
 * @author Saurabh Gujare
 * @NUID 001424874
 */
public class Node {
    private String name;
    private ArrayList<Pair<Node, Integer>> connections = new ArrayList<>();
    Node(String name) {
        this.name = name;
    }
    ArrayList<Pair<Node, Integer>> getConnections() {
        return connections;
    }
    void addNode(Node node, int weight) {
        connections.add(new Pair<>(node, weight));
    }
    String getName() {
        return name;
    }
}
