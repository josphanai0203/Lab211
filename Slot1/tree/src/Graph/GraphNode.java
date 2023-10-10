
package Graph;

import java.util.LinkedList;
import java.util.List;


class GraphNode {
    int data;
    List<GraphNode> neighbors;
    boolean visited;

    public GraphNode(int data) {
        this.data = data;
        this.neighbors = new LinkedList<>();
        this.visited = false;
    }

    public void addNeighbor(GraphNode neighbor) {
        neighbors.add(neighbor);
    }
}
