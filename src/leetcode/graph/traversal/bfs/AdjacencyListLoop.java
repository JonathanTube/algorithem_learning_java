package leetcode.graph.traversal.bfs;

import leetcode.graph.traversal.helper.AdjList;
import leetcode.graph.traversal.helper.Graph;
import leetcode.graph.traversal.helper.Node;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class AdjacencyListLoop {
    /*
     * 0=1->
     * 1=2->3->4->
     * 2=3->
     * 3=4->
     * 4=1->2->
     */
    public List<Integer> bfs(Graph g) {
        List<Integer> result = new ArrayList<>(g.vertices);
        boolean[] visited = new boolean[g.vertices];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < g.vertices; i++) {
            // 处理首节点
            deque.offerLast(i);
            // 首节点，这时队列肯定不为空
            while(!deque.isEmpty()) {
                // 出栈
                int val = deque.pollFirst();
                // 如果访问过，跳过
                if(visited[val]) continue;
                // 设置为访问过
                visited[val] = true;
                // 加入结果
                result.add(val);
                // 将与当前节点有关联的节点依次放入队列中
                // 下一次判断，肯定是队尾，这里是模拟栈，也就是栈顶
                AdjList<Integer> adjList = g.adjListArray[val];
                Node<Integer> node = adjList.head;
                while(node != null) {
                    deque.offerLast(node.val);
                    node = node.next;
                }
            }
        }
        return result;
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
            while (node != null) {
                System.out.print(node.val + "->");
                node = node.next;
            }
            System.out.println();
        }
        new AdjacencyListLoop().bfs(g).forEach(item-> System.out.print(item + ","));
        System.out.println();
    }
}
