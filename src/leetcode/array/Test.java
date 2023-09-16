package leetcode.array;

import java.util.LinkedHashMap;
import java.util.Map;

public class Test {
    public static int doSome(int[] arr) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Integer times = map.get(arr[i]);
            map.put(arr[i], times == null ? 1 : times + 1);
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) return key;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(doSome(new int[]{4, 4, 4, 3}));
        System.out.println('9' - '0');
    }
}
