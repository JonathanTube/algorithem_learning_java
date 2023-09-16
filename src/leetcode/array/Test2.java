package leetcode.array;

public class Test2 {
    public static int secondHighest(String s) {
        int[] arr = new int[10];
        for (int i = 0; i < s.toCharArray().length; i++) {
            char c = s.charAt(i);
            int index = c - '0';
            if (index < 0 || index > 9) continue;
            arr[index] = 1;
        }
        int pos = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 1) pos++;
            if (pos == 2) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(secondHighest("ck077"));
    }
}
