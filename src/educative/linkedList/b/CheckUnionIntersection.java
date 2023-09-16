package educative.linkedList.b;

import educative.linkedList.b.SinglyLinkedList.Node;

import java.util.HashMap;
import java.util.Map;

class CheckUnionIntersection {
    //performs union of two lists
    public static <T> SinglyLinkedList<T> union(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        // Write -- Your -- Code
        Node cur = list1.getHeadNode();
        while (cur.nextNode != null) {
            cur = cur.nextNode;
        }
        cur.nextNode = list2.getHeadNode();
        list1.removeDuplicatesWithHashing();
        return list1;
    }

    //performs intersection between list
    public static <T> SinglyLinkedList<T> intersection(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> result = new SinglyLinkedList<T>();
        // Write -- Your -- Code
        Map<Object, Integer> map = new HashMap<>();
        Node cur1 = list1.getHeadNode();
        while (cur1.nextNode != null) {
            map.put(cur1.data, map.getOrDefault(cur1.data, 1));
        }
        Node cur2 = list2.getHeadNode();
        while (cur2.nextNode != null) {
            map.put(cur2.data, map.getOrDefault(cur2.data, 1));
        }
        for (Object key : map.keySet()) {
            if (map.get(key) > 1) continue;
            result.insertAtEnd((T) key);
        }
        return result;
    }
}