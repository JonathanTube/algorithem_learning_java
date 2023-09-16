package spam;

import java.util.HashMap;
import java.util.Map;

//Hash Set  =>  HashSet<Integer> hSet = new HashSet<>();
//HashMap   =>  HashMap<Integer,String> hMap = new HashMap<>();  
//HashTable =>  Hashtable<Integer,String> hTable = new Hashtable<>();  
//Hash Set Functions => {add(), remove(), contains()}
//Hash Map and Table Functions => {put(key,value), get(key), remove(key), containsKey(key), containsValue(value)}
class CheckPair {

  public static String findPair(int[] arr) {
    String result = "";

    Map<Integer, String> map = new HashMap<>();

    for(int i = 0; i < arr.length; i++) {
      for(int j = 0; j < arr.length; j++) {
        Integer sum = arr[i] + arr[j];
        System.out.println(sum);
        String existPair = map.get(sum);
        String newPair = "{" + arr[i] + "," + arr[j] + "}";
        if(existPair != null) return existPair + newPair;
        map.put(sum, newPair);
      }
    }

    // Write - Your - Code   
    return result; 
  }
}