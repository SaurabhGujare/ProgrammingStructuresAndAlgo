package GraphGeneralized;

import java.util.*;

/**
 * @author Saurabh Gujare
 * @NUID 001424874
 */
public class GraphGeneralized<T> {
    private Map<T, LinkedList<T> > adjacentList;

    GraphGeneralized(){
        this.adjacentList = new HashMap<>();
    }

    public void addVertex(T vertex){
        this.adjacentList.put(vertex, new LinkedList<>());
    }

    public void addEdge(T sourceVertex, T destinationVertex, boolean isBirectional){
        if(!this.adjacentList.containsKey(sourceVertex))
            addVertex(sourceVertex);

        if(!this.adjacentList.containsKey(destinationVertex))
            addVertex(destinationVertex);

        this.adjacentList.get(sourceVertex).add(destinationVertex);

        if(isBirectional==true)
            this.adjacentList.get(destinationVertex).add(sourceVertex);
    }

    // This function gives the count of vertices
    public int getVertexCount(){

        return this.adjacentList.keySet().size();

    }

    // This function gives the count of edges
    public void getEdgesCount(boolean bidirection){
        int count = 0;
        for(T v: this.adjacentList.keySet())
            count+=this.adjacentList.get(v).size();

        if(bidirection)
            count/=2;

        System.out.println("Number of edges are "+count);

    }

    // This function gives whether
    // a vertex is present or not.
    public void hasVertex(T s){

    }

    // This function gives whether an edge is present or not.
    public void hasEdge(T s, T d){

    }

    public void DFS(){

        boolean[] visited = new boolean[getVertexCount()];

        //If it is  connected graph:: accept a vertex 'v' as a input parameter and pass it to the DFS util
        // DFSUtil(v, visited)


        //If it is disconnected graph
        for(T v: this.adjacentList.keySet())
            if(visited[(int)v]==false)
                DFSUtil(v,visited);

    }
    private void DFSUtil(T v, boolean[] visited){
        visited[(int)v] = true;
        System.out.print(v.toString()+" ");

        Iterator<T> iterator = this.adjacentList.get(v).listIterator();
        while (iterator.hasNext()){
            T n = iterator.next();
            if(!visited[(int)n]){
                DFSUtil(n,visited);
            }
        }

    }

    public void BFS(T v){
        boolean[] visited = new boolean[getVertexCount()];

        Queue<T> queue = new LinkedList<>();
        visited[(int)v] = true;
        queue.add(v);

        while(!queue.isEmpty()){
            T vertex= queue.poll();
            System.out.print(vertex.toString()+" ");

            Iterator<T> iterator = this.adjacentList.get(vertex).listIterator();
            while(iterator.hasNext()){
                T adjVertex = iterator.next();
                if(!visited[(int) adjVertex]) {
                    visited[(int) adjVertex] = true;
                    queue.add(adjVertex);
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(T v: this.adjacentList.keySet()){
            sb.append(v.toString()+": ");
            for(T w: this.adjacentList.get(v)){
                sb.append(w.toString()+" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args){
        // Object of graph is created.
        GraphGeneralized<Integer> g = new GraphGeneralized<Integer>();

        // edges are added.
        // Since the graph is bidirectional,
        // so boolean bidirectional is passed as true.
        g.addEdge(0, 1, true);
        g.addEdge(0, 4, true);
        g.addEdge(1, 2, true);
        g.addEdge(1, 3, true);
        g.addEdge(1, 4, true);
        g.addEdge(2, 3, true);
        g.addEdge(3, 4, true);

        // edges are added.
        // Since the graph is directional,
        // so boolean directional is passed as false
//        g.addEdge(0, 1,false);
//        g.addEdge(0, 2,false);
//        g.addEdge(1, 2,false);
//        g.addEdge(2, 0,false);
//        g.addEdge(2, 3,false);
//        g.addEdge(3, 3,false);

        // print the graph.
        System.out.println("Graph:\n"+ g);

        //
        System.out.println("\nThe number of vertices are "+g.getVertexCount());

        //
        g.getEdgesCount(true);

        //
        System.out.println("\nDFS:-> ");
        g.DFS();

        System.out.println("\nBFS:-> ");
        g.BFS(2);

    }
}
