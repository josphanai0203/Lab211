
package Graph;

import java.util.Queue;

public class BreadthFirstSearchWithRecursion {
    private static GraphNode parent;
    public static void bfsRecursive(Queue<GraphNode> queue) {
        if (queue.isEmpty()) {
            return;
        }

        GraphNode node = queue.poll();
        if (node.visited) {
            bfsRecursive(queue); // Skip visited nodes
        } else {
            System.out.print(node.data + " ");
            if (parent != null) {
                System.out.println(", Parent: " + parent.data);
            } else {
                System.out.println(", Root node");
            }
            // Visit the current node
            node.visited = true;

            // Add unvisited neighbors to the queue
            for (GraphNode neighbor : node.neighbors) {
                parent = node;
                if (!neighbor.visited) {
                    queue.add(neighbor);
                }
            }

            bfsRecursive(queue); // Continue with the next node in the queue
        }
    }}
