package HW11Que8;

import java.util.ArrayList;
import javafx.util.Pair;

/**
 * @author Saurabh Gujare
 * @NUID 001424874
 */
public class HW11_SaurabhGujare {
    private ArrayList<Node> nodes;
    private int distance;
​
    HW11_SaurabhGujare() {
        nodes = new ArrayList<>();
    }
​
    ArrayList<Node> getNodes() {
        return nodes;
    }
​
    int getDistance() {
        return distance;
    }
​
    void setDistance(int distance) {
        this.distance = distance;
    }
​
    void addNode(Node node) {
        nodes.add(node);
    }
​
    @Override
    public String toString() {
        StringBuilder nodesString = new StringBuilder();
​
        for (int i = 0; i < nodes.size(); i++) {
            nodesString.append(nodes.get(i).getName());
            if (i != nodes.size() - 1)
                nodesString.append('-');
        }
        return distance + " " + nodesString.toString();
    }

}
