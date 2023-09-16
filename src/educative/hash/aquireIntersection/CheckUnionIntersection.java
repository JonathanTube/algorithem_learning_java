package educative.hash.aquireIntersection;

import java.util.HashSet;

class CheckUnionIntersection {
    //performs union of two lists
    public static <T> SinglyLinkedList<T> unionWithHashing(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        HashSet<T> set = new HashSet();
        SinglyLinkedList.Node cur1 = list1.getHeadNode();
        // loop until get to the end node
        while(cur1.nextNode != null) {
            // put the node in set
            set.add((T)cur1.data);
            cur1 = cur1.nextNode;
        }
        // handle the list2
        SinglyLinkedList.Node cur2 = list2.getHeadNode();
        while(cur2 != null) {
            if(!set.contains(cur2.data)) {
                cur1.nextNode = cur2;
                cur1 = cur2;
            }
            cur2 = cur2.nextNode;
        }
        // Write -- Your -- Code
        return list1;
    }
    
    //performs intersection between list
    public static <T> SinglyLinkedList<T> intersectionWithHashing(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> result = new SinglyLinkedList<T>();

        HashSet<T> visited = new HashSet<T>();
        //start from the head of list1
        SinglyLinkedList<T>.Node current = list1.getHeadNode();
        //Keep iterating list1
        while (current != null) {
            //Add elements to visited set if they have not been visited
            if (!visited.contains(current.data)) {
                visited.add(current.data);
            }
            current = current.nextNode;
        }
        //now take head of list2
        current = list2.getHeadNode();
        //iterate list2
        while (current != null) {
            //add the elements which have been visited before into the result
            if (visited.contains(current.data)) {
                result.insertAtHead(current.data);
                visited.remove(current.data);
            }
            current = current.nextNode;
        }
        return result;
    }

    public static void main(String[] args) {
//        (4->3, 4->5)
        SinglyLinkedList list1 = new SinglyLinkedList();
        list1.insertAtEnd(4);
        list1.insertAtEnd(3);

        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.insertAtEnd(4);
        list2.insertAtEnd(5);

        SinglyLinkedList list = CheckUnionIntersection.intersectionWithHashing(list1,list2);
        list.printList();
    }
}