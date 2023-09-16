package educative.graph.dfs;

import educative.stack.sort.Stack;

class CheckDFS {
    public static String bfs(Graph g) {
        if (g.vertices < 1) return "";
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[g.vertices];

        Stack<Integer> stack = new Stack<>(g.vertices);

        for (int i = 0; i < g.vertices; i++) {
            stack.push(i);
            while (!stack.isEmpty()) {
                int val = stack.pop();
                if (visited[val]) continue;

                visited[val] = true;
                sb.append(val);

                DoublyLinkedList<Integer> list = g.adjacencyList[val];
                if (list.isEmpty()) continue;

                DoublyLinkedList<Integer>.Node node = list.headNode;
                while (node != null) {
                    stack.push(node.data);
                    node = node.nextNode;
                }
            }
        }
        return sb.toString();
    }

    public static void main(String args[]) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        g.addEdge(2, 3);
        g.addEdge(3, 2);
        g.addEdge(4, 1);
        System.out.println("Graph1:");
        g.printGraph();
        System.out.println("BFS traversal of Graph1 : " + bfs(g));
        System.out.println();
    }
}