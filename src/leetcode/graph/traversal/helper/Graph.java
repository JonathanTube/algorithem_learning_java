package leetcode.graph.traversal.helper;

    /**
     * 图
     */
    public class Graph {
        public int vertices;
        public AdjList<Integer>[] adjListArray;
        public Graph(int vertices) {
            this.vertices = vertices;
            adjListArray = new AdjList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjListArray[i] = new AdjList<>();
            }
        }

        public void addEdge(int start, int end) {
            if(start > vertices - 1) return;
            adjListArray[start].addLast(end);
        }
    }