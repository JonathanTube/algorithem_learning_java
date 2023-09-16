package educative.queue;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryArr {
    public static void main(String[] args) {
        int number = 3;
        String[] result = new String[number];
        Queue<String> queue = new LinkedList<>();

        queue.add("1");
        // queue = [1]
        // queue = [], i = 0; result[0] = 1; queue = ["00", "01"]
        // queue = ["00", "01"], i = 1; result[1] = "01"
        for (int i = 0; i < number; i++) {
//            result[i] = queue.poll();
            String s1 = result[i] + "0";
            String s2 = result[i] + "1";
            queue.add(s1);
            queue.add(s2);
        }
        for (int i = 0; i < result.length; i++)
            System.out.print(result[i] + " ");
    }
}
