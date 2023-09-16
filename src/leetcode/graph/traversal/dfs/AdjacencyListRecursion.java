package leetcode.graph.traversal.dfs;

import leetcode.graph.traversal.helper.AdjList;
import leetcode.graph.traversal.helper.Graph;
import leetcode.graph.traversal.helper.Node;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyListRecursion {
    /*
     * 0=1->
     * 1=2->3->4->
     * 2=3->
     * 3=4->
     * 4=1->2->
     */
    public List<Integer> dfs(Graph g) {
        List<Integer> result = new ArrayList<>(g.vertices);
        boolean[] visited = new boolean[g.vertices];
        // 循环每个顶点
        for(int i = 0; i < g.vertices; i++) {
            recursion(g, i, visited, result);
        }
        return result;
    }

    public void recursion(Graph g,int val, boolean[] visited, List<Integer> result) {
        // 处理当前顶点
        if(visited[val]) return;
        // 访问过的节点一定要跳过
        visited[val] = true;
        result.add(val);
        // 获取当前节点的邻接表(adjacency list)的头结点
        Node<Integer> node = g.adjListArray[val].head;
        // 遍历领接表中的节点
        while(node!= null) {
            recursion(g, node.val,visited, result);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        int len = 5;
        Graph g = new Graph(len);
        g.addEdge(0,3);
        g.addEdge(1,2);
        g.addEdge(1,3);
        g.addEdge(1,4);
        g.addEdge(2,3);
        g.addEdge(4,1);
        g.addEdge(4,2);
        for (int i = 0; i < g.vertices; i++) {
            System.out.print(String.format("%s=", i));
            AdjList<Integer> adjList = g.adjListArray[i];
            Node<Integer> node = adjList.head;
            while(node != null) {
                System.out.print(node.val + ",");
                node = node.next;
            }
            System.out.println();
        }
        new AdjacencyListRecursion().dfs(g).forEach(item-> System.out.print(item + ","));
        System.out.println();
    }
}
