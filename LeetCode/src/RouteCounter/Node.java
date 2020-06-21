package RouteCounter;

/**
 * @author Saurabh Gujare
 * @NUID 001424874
 */
import java.util.ArrayList;
import java.util.List;

public class Node {

    private int nodeValue;
    private List<Node> children = new ArrayList<>();

    public Node(int nodeValue) {
        this.nodeValue = nodeValue;
    }

    /**
     * @return the children
     */
    public List<Node> getChildren() {
        return children;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(List<Node> children) {
        this.children = children;
    }
}

