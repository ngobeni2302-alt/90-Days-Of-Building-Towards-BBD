package com.bbd.day25;
// BBD #5 - Merge Two Sorted LinkedLists
public class MergeTwoSortedLists {
    static class Node{ int val; Node next; Node(int v){val=v;} }
    public Node merge(Node l1, Node l2){
        Node dummy = new Node(-1);
        Node curr = dummy;
        while(l1!=null && l2!=null){
            if(l1.val <= l2.val){ curr.next=l1; l1=l1.next; }
            else { curr.next=l2; l2=l2.next; }
            curr=curr.next;
        }
        curr.next = (l1!=null) ? l1 : l2;
        return dummy.next;
    }
}
