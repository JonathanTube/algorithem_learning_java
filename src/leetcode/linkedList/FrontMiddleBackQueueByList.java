package leetcode.linkedList;

import java.util.ArrayList;
import java.util.List;

class FrontMiddleBackQueueByList {
    List<Integer> list;
    public FrontMiddleBackQueueByList() {
        list = new ArrayList<>();
    }
    
    public void pushFront(int val) {
        list.add(0, val);// 在list头部插入
    }
    
    public void pushMiddle(int val) {
        // 如果是[1,2]中间位置是 2 - 1 = 1 / 2 = 0，显然不对
        // 如果是[1,2,3,4,5]中间位置是3，下标是2；（5 - 1）= 4 / 2 = 2;
        // 如果是[1,2,3,4,5,6]中间位置是3，下标是2：(6 - 1) = 5 / 2 = 2;
        // 所以中间位置是：list.size() / 2; 一个列表获取中间位置靠后
        list.add(list.size(), val);
    }
    
    public void pushBack(int val) {
        list.add(val);
    }
    
    public int popFront() {
        if(list.isEmpty()) return -1;
        return list.remove(0);
    }
    
    public int popMiddle() {
        if(list.isEmpty()) return -1;
        int pos = (list.size() - 1) / 2;
        return list.remove(pos);
    }
    
    public int popBack() {
        if(list.isEmpty()) return -1;
        return list.remove(list.size() - 1);
    }

    public static void main(String[] args) {
        FrontMiddleBackQueueByList frontMiddleBackQueueByList = new FrontMiddleBackQueueByList();
        frontMiddleBackQueueByList.pushFront(1);
        frontMiddleBackQueueByList.pushBack(2);
        frontMiddleBackQueueByList.pushMiddle(3);
        frontMiddleBackQueueByList.pushMiddle(4);
    }
}


// [1,4,3,2]
// [4,3,2]; 1
// [4,2]; 3
// [2]; 4;
// [];2
// [];-1
/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */