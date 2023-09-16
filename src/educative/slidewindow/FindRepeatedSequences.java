package educative.slidewindow;

import java.util.HashSet;
import java.util.Set;

public class FindRepeatedSequences{

   public static Set<String> findRepeatedSequences(String s, int k) {
      Set<String> set = new HashSet<>();
      Set<String> hash = new HashSet<>();
      for(int i = 0; i + k <= s.length(); i++) {
         String temp = s.substring(i, i + k);
         System.out.println(temp);
         if(hash.isEmpty()) hash.add(temp);
         else if(hash.contains(temp)) set.add(temp);
      }   
      return set;
   }

   public static void main(String[] args) {
      findRepeatedSequences("AAAAACCCCCAAAAACCCCCC",8);
      StringBuilder sb = new StringBuilder("abcdefg");
      sb.delete(0,1);
      System.out.println(sb.toString());
   }
}