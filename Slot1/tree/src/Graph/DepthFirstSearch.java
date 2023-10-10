package Graph;

public class DepthFirstSearch {

    public static void dfs(GraphNode node) {
        if (node == null) {
            return;
        }

        // Visit the current node
        System.out.print(node.data + " ");
        node.visited = true;

        // Recursively visit unvisited neighbors
        for (GraphNode neighbor : node.neighbors) {
            if (!neighbor.visited) {
                dfs(neighbor);
            }
        }
    }
}
