package leetcode.mergeintervals;

import java.util.Arrays;

class InsertIntervals {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] result = new int[intervals.length + 1][2];

        int len = 0;
        
        int i = 0;
        int j = 0;

        for(;i < intervals.length; i++) {
            int[] arr = intervals[i];
            if(arr[1] >= newInterval[0]) break;
            result[j++] = arr;
            len ++;
    }

        // add new interval
        result[j++] = newInterval;
        len ++;

        for(; i < intervals.length; i++) {
            int[] last = result[len - 1];
            int[] arr = intervals[i];
            if(arr[0] > last[1]) {
                result[j++] = arr;
                len ++;
                continue;
            }
            int start = Math.min(arr[0], last[0]);
            int end = Math.max(arr[1], last[1]);
            last[0] = start;
            last[1] = end;
        }
        return Arrays.copyOf(result, len);
    }

    public static void main(String[] args) {
        int[][] arr= {{1,3},{6,9}};
        int[][] newArr = insert(arr, new int[]{2,5});
        for (int i = 0; i < newArr.length; i++) {
            int[] item = newArr[i];
            System.out.print(String.format("[%s,%s]\t", item[0],item[1]));
        }
        System.out.println();
    }
}