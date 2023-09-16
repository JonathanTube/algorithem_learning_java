package educative.hash.removeduplicatedNodes;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class RemoveDuplicatesChallenge {
    public static <T> void removeDuplicates(SinglyLinkedList<T> list) {
        SinglyLinkedList.Node dummyHead = list.new Node();
        dummyHead.nextNode = list.headNode;
        SinglyLinkedList.Node cur = dummyHead;

        Set<T> set = new HashSet<>();

        while(cur != null && cur.nextNode != null) {
            T value = (T) cur.nextNode.data;
            if(set.contains(value)) {
                // remove it
                cur.nextNode = cur.nextNode.nextNode;
            }else {
                set.add(value);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4};
        Arrays.stream(Arrays.copyOf(arr, 2)).forEach(item-> System.out.println(item));
    }
}