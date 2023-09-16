package educative.graph.cycled;

import java.util.Arrays;

class CheckCycle {
    public static boolean detectCycle(Graph g){
        int num_of_vertices = g.vertices;
        boolean[] visited = new boolean [num_of_vertices];
        boolean[] stackFlag = new boolean[num_of_vertices];
        for (int i = 0; i < num_of_vertices; i++) {
            System.out.println(String.format("i=%s", i));
            System.out.print(String.format("\t====================visited=%s", Arrays.toString(visited)));
            System.out.print(String.format("\t====================stackFlag=%s\n", Arrays.toString(stackFlag)));
            if (cyclic(g, i, visited, stackFlag)) return true;
        }
        return false;
    }
    public static boolean cyclic(Graph g, int v, boolean[] visited, boolean[] stackFlag) {
        System.out.print(String.format("\t\tv=%s", v));
        System.out.print(String.format("\tvisited=%s", Arrays.toString(visited)));
        System.out.print(String.format("\tstackFlag=%s\n", Arrays.toString(stackFlag)));
        if (stackFlag[v]) return true;
        if (visited[v]) return false;
        visited[v] = true;
        stackFlag[v] = true;
        DoublyLinkedList<Integer>.Node temp = g.adjacencyList[v] == null ? null : g.adjacencyList[v].headNode;
        while (temp != null) {
            if(cyclic(g, temp.data, visited, stackFlag))  return true;
            temp = temp.nextNode;
        }
        stackFlag[v] = false;
        return false;
    }

    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(2,3);
        g.addEdge(3,0);
        g.printGraph();
        System.out.println(detectCycle(g));
    }

}