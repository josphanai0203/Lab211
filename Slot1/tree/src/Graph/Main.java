
package Graph;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
public static void main(String[] args) {
        // Create a sample graph
        GraphNode nodeA = new GraphNode(1);
        GraphNode nodeB = new GraphNode(2);
        GraphNode nodeC = new GraphNode(3);
        GraphNode nodeD = new GraphNode(4);
        GraphNode nodeE = new GraphNode(5);

        nodeA.addNeighbor(nodeD);
        nodeA.addNeighbor(nodeC);
        nodeA.addNeighbor(nodeB);
        nodeB.addNeighbor(nodeD);
        nodeC.addNeighbor(nodeE);
//
//        System.out.println("Depth-First Search (DFS) using recursion:");
//        DepthFirstSearch.dfs(nodeA);
         System.out.println("Breadth-First Search (BFS) using recursion:");
        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(nodeA);
        BreadthFirstSearchWithRecursion.bfsRecursive(queue);
    }

}
