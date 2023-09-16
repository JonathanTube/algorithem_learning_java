package educative.mergeintervals.insertintervals;

import java.util.ArrayList;
import java.util.List;

public class InsertIntervals {
    public static List<Interval> insertInterval(List<Interval> existingIntervals, Interval newInterval) {
        List<Interval> output = new ArrayList<>();
        int i = 0;
        for(; i < existingIntervals.size(); i++) {
            Interval item = existingIntervals.get(i);
            if(item.end < newInterval.start) output.add(item);
            else break;
        }

        output.add(newInterval);

        for(;i < existingIntervals.size(); i++) {
            Interval item = existingIntervals.get(i);
            Interval last = output.get(output.size() - 1);
            if(item.start > last.end) {
                output.add(item);
                continue;
            }
            int start = Math.min(last.start, item.start);
            int end = Math.max(last.end, item.end);
            last.start = start;
            last.end = end;
        }
        return output;
    }

    public static void main(String[] args) {
        List<Interval> existingIntervals = new ArrayList<>();
        existingIntervals.add(new Interval(1,2));
        existingIntervals.add(new Interval(3,4));
        existingIntervals.add(new Interval(5,8));
        existingIntervals.add(new Interval(9,15));
        insertInterval(existingIntervals, new Interval(2,5)).forEach(item-> System.out.print("[" + item.start + "," + item.end + "] "));
        System.out.println();
    }
}
