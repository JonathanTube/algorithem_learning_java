package leetcode.graph.topologicalsort;

import java.util.*;

public class TopologicalSort {
    private static List<Integer> topologicalSort(int vertices, int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int[] inDegrees = new int[vertices];
        // 统计入度
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if(matrix[i][j] == 1) inDegrees[j] ++;
            }
        }
        // 在队列中的，肯定都是入度为0的vertex
        Queue<Integer> queue = new LinkedList<>();
        // 入度为0的节点入队
        for (int i = 0; i < inDegrees.length; i++) {
           if(inDegrees[i] == 0) queue.offer(i);
        }
        //bfs
        while(!queue.isEmpty()) {
            int i = queue.poll();
            result.add(i);
            for (int j = 0; j < vertices; j++) {
                int edgeFlag = matrix[i][j];
                if(edgeFlag == 1) { // 有边
                    // 将关联节点的入度-1
                    inDegrees[j] --;
                    // 入度为0了，加入队列
                    if(inDegrees[j] == 0) queue.offer(j);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int vertices = 5;
        int[][] matrix = new int[vertices][vertices];
        // 0 = 1,2,3
        // 1 = 4
        // 2 = 4
        // 3 = 1
        matrix[0][1] = 1;
        matrix[0][2] = 1;
        matrix[0][3] = 1;
        matrix[1][4] = 1;
        matrix[2][4] = 1;
        matrix[3][1] = 1;
//        matrix[3][0] = 1; 有换的话就无法输出了
        for (int[] arr : matrix) System.out.println(Arrays.toString(arr));

        topologicalSort(vertices,matrix).forEach(item-> System.out.print(item + ","));
        System.out.println();
    }
}