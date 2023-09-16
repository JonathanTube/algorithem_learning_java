package leetcode.graph.topologicalsort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CanCourseFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 构建邻接表
        List<Integer>[] adjacencyList = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        // 记录节点的入度
        int[] inDegrees = new int[numCourses];
        // 填充领接表
        for (int i = 0; i < prerequisites.length; i++) {
            int[] edge = prerequisites[i];
            int from = edge[1]; // 根据题意，后面一个是先决课程
            int to = edge[0];
            adjacencyList[from].add(to);
            // 记录节点的入度
            inDegrees[to]++;
        }
        // 队列
        Queue<Integer> queue = new LinkedList<>();
        // 将入度为0的节点入队列
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) queue.offer(i);
        }
        int pollCount = 0;
        // BFS
        while (!queue.isEmpty()) {
            // 出队
            int prev = queue.poll();
            // 出队数量 + 1 (已经遍历过的数量)
            // 拿到该节点的领接表
            List<Integer> aList = adjacencyList[prev];
            for (int cur : aList) {
                // 领接表中的入度-1
                inDegrees[cur]--;
                // 判断领接表中的节点的入度,是否为0
                if (inDegrees[cur] == 0) queue.offer(cur);
            }
        }
        return pollCount == numCourses;
    }

    public static void main(String[] args) {
        CanCourseFinish ts = new CanCourseFinish();
        int[][] arr = new int[][]{{1, 0}};
        System.out.println(ts.canFinish(2, arr));
    }
}
