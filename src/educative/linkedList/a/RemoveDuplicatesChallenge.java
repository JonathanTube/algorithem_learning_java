package educative.linkedList.a;

import java.util.HashSet;
import java.util.Set;

class RemoveDuplicatesChallenge {
    public static <T> void removeDuplicates(SinglyLinkedList<T> list) {
        Set<T> set = new HashSet<>();
        SinglyLinkedList.Node cur = list.new Node();
        cur.nextNode = list.headNode;
        while (cur != null) {
            T data = (T) cur.data;
            if (set.contains(data)) {
                list.deleteByValue(data);
            } else {
                set.add(data);
            }
            cur = cur.nextNode;
        }
        // Write -- Your -- Code
    }
}