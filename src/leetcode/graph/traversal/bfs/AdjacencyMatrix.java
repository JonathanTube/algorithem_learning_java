package leetcode.graph.traversal.bfs;

import java.util.*;

public class AdjacencyMatrix {
    // 记录遍历的节点
    private static final List<Integer> result = new ArrayList<>();
    public static List<Integer> traversal(int[][] matrix) {
        // 获取节点个数
        int len = matrix.length;
        // 记录已经被访问的节点
        boolean[] visited = new boolean[len];
        /* j==>  0  1  2  3  4
           i=0  [1, 0, 1, 0, 1]
           i=1  [0, 0, 0, 0, 0]
           i=2  [1, 0, 1, 0, 1]
           i=3  [0, 0, 0, 0, 0]
           i=4  [1, 0, 1, 0, 1]
         */
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            // 遍历每一个vertex
            if(visited[i]) continue;
            deque.offerLast(i);// 入队
            visited[i] = true; // 标记已访问
            result.add(i);// 加入结果
            while(!deque.isEmpty()) {
                // 出队
                int val = deque.pollFirst();
                // 遍历关联节点
                for (int j = 0; j < matrix[val].length; j++) {
                    if(matrix[i][j] != 1) continue;
                    if(visited[j]) continue;
                    deque.offerLast(j);
                    visited[j] = true;
                    result.add(j);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int len = 5;
        int[][] matrix = new int[len][len];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(i % 2 == 0 && j % 2 == 0) matrix[i][j] = 1;
            }
        }
        for (int[] arr : matrix) System.out.println(Arrays.toString(arr));

        traversal(matrix).forEach(item-> System.out.print(item + ","));
        System.out.println();
    }
}