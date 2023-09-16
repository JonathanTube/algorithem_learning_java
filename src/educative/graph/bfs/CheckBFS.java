package educative.graph.bfs;

class CheckBFS {
    public static String bfs(Graph g){
        if (g.vertices < 1) return "";
        StringBuilder result = new StringBuilder();
        boolean[] visited = new boolean[g.vertices];
        for(int i=0;i<g.vertices && !visited[i];i++) result.append(bfsVisit(g, i, visited));
        return result.toString();
    }
    public static String bfsVisit(Graph g, int source, boolean[] visited) {
        StringBuilder result = new StringBuilder();
        Queue<Integer> queue = new Queue<>(g.vertices);
        queue.enqueue(source);
        visited[source] = true;
        while (!queue.isEmpty()) {
            int current_node = queue.dequeue();
            result.append(current_node);
            if(g.adjacencyList[current_node] == null) continue;
            DoublyLinkedList<Integer>.Node temp = g.adjacencyList[current_node].headNode;
            while (temp != null) {
                if (!visited[temp.data]) {
                    queue.enqueue(temp.data);
                    visited[temp.data] = true; //Visit the current Node
                }
                temp = temp.nextNode;
            }
        }
        return result.toString();
    }
    public static void main(String args[]) {
        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
        System.out.println("Graph1:");
        g.printGraph();
        System.out.println("BFS traversal of Graph1 : " + bfs(g));
        System.out.println();

        Graph g2 = new Graph(5);
        g2.addEdge(0,1);
        g2.addEdge(0,4);
        g2.addEdge(1,2);
        g2.addEdge(3,4);
        System.out.println("Graph2:");
        g2.printGraph();
        System.out.println("BFS traversal of Graph2 : " + bfs(g2));
  }
}