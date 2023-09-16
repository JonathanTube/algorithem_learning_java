package educative.mergeintervals.insertintervals;

import java.util.ArrayList;
import java.util.List;

class IntervalListIntersections {
  
  public static List <Interval> intervalsIntersection(List <Interval> intervalLista, List <Interval> intervalListb) {
    List <Interval> intersections = new ArrayList <>();
    if(intervalLista.size() == 0 || intervalListb.size() == 0) return intersections;

    int aIndex = 0, bIndex = 0, aLen = intervalLista.size(), bLen = intervalListb.size();

    while(aIndex < aLen && bIndex < bLen) {
      Interval a = intervalLista.get(aIndex);
      Interval b = intervalListb.get(bIndex);
      if(a.end < b.start) {
       aIndex ++;
       continue;
      }
      if(b.end < a.start) {
        bIndex ++;
        continue;
      }
      int start = Math.max(a.start,b.start);
      int end = Math.min(a.end,b.end);
      intersections.add(new Interval(start,end));
      if(a.end > b.end) bIndex ++;
      else if(b.end > a.end) aIndex ++;
      else {
        aIndex++;
        bIndex++;
      }
    }
    return intersections;
  }

  public static void main(String[] args) {
//    [[1, 4], [5, 6], [7, 8], [9, 15]] , [[2, 4], [5, 7], [9, 15]]
    List <Interval> intervalLista = new ArrayList<>();
    intervalLista.add(new Interval(1,4));
    intervalLista.add(new Interval(5,6));
    intervalLista.add(new Interval(7,8));
    intervalLista.add(new Interval(9,15));

    List <Interval> intervalListb = new ArrayList<>();
    intervalListb.add(new Interval(2,4));
    intervalListb.add(new Interval(5,7));
    intervalListb.add(new Interval(9,15));

    intervalsIntersection(intervalLista,intervalListb)
            .forEach(item-> System.out.print(String.format("[%s,%s],", item.getStart(),item.getEnd())));
    System.out.println();
  }
}