package leetcode.graph.traversal.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        // 从每个节点开始，dfs遍历所有节点
        // 这里为什么要从每个节点dfs遍历
        // 因为会有孤岛，没有联通的节点
        for (int i = 0; i < len; i++) dfs(matrix, i, visited);
        return result;
    }

    /**
     * @param matrix 这里为什么要传递matrix，因为要根据这个matrix查找关联节点
     * @param i 这里的i代表的是顶点vertex
     * @param visited 访问过的节点，防止重复访问形成环
     */
    private static void dfs(int[][] matrix, int i, boolean[] visited) {
        // 访问过了，跳过
        if(visited[i]) return;
        // 没有访问过，加入到list
        result.add(i);
        // 设置为访问过
        visited[i] = true;
        // 从当前节点，纵向扫描数组
        for (int j = 0; j < matrix[i].length; j++) {
            // 如果没有边，跳过
            if(matrix[i][j] != 1) continue;
            // 如果下个节点已经访问过了，跳过
            if(visited[j]) continue;
            dfs(matrix, j, visited);
        }
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