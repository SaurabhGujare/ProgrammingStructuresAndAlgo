package RouteCounter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Saurabh Gujare
 * @NUID 001424874
 */
public class RouteCounter {

    // initialize global variables for constants
    public static int size;
    public static int fuel;
    public static int[] cities;
    public static List<Node> visitedList = null;

    // output of program
    public static int noOfPaths = 0;


    public static void main(String[] args) {
        fuel = 7;
        cities = new int[] {1,3,6,2,4};
		/*fuel = 5;
		cities = new int[] {2,6,2,3,4,8};*/
        size = cities.length;

        //initialize root node
        Node root = new Node(cities[0]);

        // add root node to visited
        visitedList = new ArrayList<Node>(){{add(root);}};

        // Find paths starting from root node to other nodes using recursive function.
        List<Node> childrenOfRoot = new ArrayList<Node>();
        for(int idx=1; idx<size; idx++) {
            List<Node> dummyChildrenList =  getPossibleChildren(root, 0, fuel, idx);
            //if the children has path add it to root node.
            if(dummyChildrenList != null) {
                childrenOfRoot.addAll(dummyChildrenList);
            }
        }
        root.setChildren(childrenOfRoot);
        System.out.println(root+" has :"+ noOfPaths);
    }

    //function to get fuel cost
    public static int getFuelCost(int ci, int cj) {
        return Math.abs(ci-cj);
    }

    //function to check whether travel between 2 nodes is possible or not.
    public static boolean isTravelPossible(int ci, int cj, int i, int j,Node newNode, int remFuel) {
        if(i > j || visitedList.contains(newNode)  || getFuelCost(ci, cj) > remFuel) {
            return false;
        }
        return true;
    }

    // Recursive function to find possible path and generate it as a child from root node.
    public static List<Node> getPossibleChildren(Node currentNode, int currentIdx, int remFuel, int nextIdx) {
        List<Node> retNodes = new ArrayList<Node>();
        int ci = cities[currentIdx];
        int cj = cities[nextIdx];
        Node newNode = new Node(cities[nextIdx]);

        // base case to eliminate impossible paths
        if(!isTravelPossible(ci, cj, currentIdx, nextIdx, newNode, remFuel) || ci==cj){
            return null;
        }

        //add new node to visited
        visitedList.add(newNode);

        //base case for adding a possible path: last node in array, or fuel exhausted
        if(nextIdx+1 == size || (remFuel-getFuelCost(ci, cj)) < 0) {
            noOfPaths++;
            return new ArrayList<Node>(){{add(newNode);}};
        }
        //find path recursively if current node is not base case.
        for(int innerIdx=nextIdx+1; innerIdx<size; innerIdx++) {
            List<Node> dummyChildrenList =  getPossibleChildren(newNode, nextIdx, (remFuel-getFuelCost(ci, cj)), innerIdx);
            if(dummyChildrenList != null) {
                retNodes.addAll(dummyChildrenList);
            }
        }
        // add the obtained nodes as children to new node
        newNode.setChildren(retNodes);

        //remove new node from visited as it is appended to current node.
        visitedList.remove(newNode);

        // another case where no single path is found after newNode
        if(retNodes.isEmpty()) {
            noOfPaths++;
        }
        return new ArrayList<Node>(){{add(newNode);}};
    }
}
