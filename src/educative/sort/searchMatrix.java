package educative.sort;

class SearchMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0) return false;
//        if(matrix.length == 1 && matrix[0].length == 1) return matrix[0][0] == target;

        int rows = matrix.length; // 1
        int cols = matrix[0].length; // 2

        int left = 0; // 0
        int right = rows * cols - 1; // 1
        while(left <= right) {
            int mid = (left + right) / 2; // 1
            int i = mid / cols; // 0
            int j = mid % cols;// 1

            System.out.println("matrix["+i+"]["+j+"]=" + matrix[i][j]);
            if(matrix[i][j] == target) return true;

            if(matrix[i][j] < target) left = mid +1; // 1
            else right = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] arr = {{-1,3}};
        int[][] arr = {{1,4},{2,5}};
        System.out.println(searchMatrix(arr, 2));
    }
}