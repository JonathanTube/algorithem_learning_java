package hackerrank;

import java.util.HashSet;
import java.util.Set;

public class Pangrams {
    public static String pangrams(String s) {
        // Write your code here
        Set<Character> set = new HashSet<>(26);
        for(int i = 0; i <= 25; i++){
            set.add((char)(97+i));
        }
        System.out.println(s.toLowerCase().toCharArray());
        for(char c : s.toLowerCase().toCharArray()) {
            set.remove(c);
        }

        System.out.println((int)'a');
        System.out.println('a'+1);
        for(char ss : set) {
            System.out.println(ss);
        }
        return set.size() == 0 ? "pangram" : "not pangram";
    }

    public static void main(String[] args) {
        pangrams("We promptly judged antique ivory buckles for the next prize");
    }
}
