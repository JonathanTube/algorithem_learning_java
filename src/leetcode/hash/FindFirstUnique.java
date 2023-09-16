package leetcode.hash;

import java.util.Hashtable;
import java.util.Map;

public class FindFirstUnique {
    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new Hashtable<>();

        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            if(entry.getValue() == 1) return entry.getKey();
        }
        return ' ';
    }

    public static void main(String[] args) {
        FindFirstUnique findFirstUnique = new FindFirstUnique();
        System.out.println(findFirstUnique.firstUniqChar("leetcode"));
    }
}
