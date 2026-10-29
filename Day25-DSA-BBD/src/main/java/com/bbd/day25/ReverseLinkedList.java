package com.bbd.day25;
// BBD #2 - Reverse LinkedList - 3 pointers - Day 14 builds this
public class ReverseLinkedList {
    static class Node{ int val; Node next; Node(int v){val=v;} }
    public Node reverse(Node head){
        Node prev=null, curr=head, next=null;
        while(curr!=null){
            next = curr.next; // save
            curr.next = prev;  // reverse
            prev = curr;       // move prev
            curr = next;       // move curr
        }
        return prev;
    }
    public static void print(Node h){ while(h!=null){ System.out.print(h.val+" -> "); h=h.next; } System.out.println("null"); }
    public static void main(String[] args){
        Node a = new Node(1); a.next=new Node(2); a.next.next=new Node(3);
        ReverseLinkedList r = new ReverseLinkedList();
        print(a);
        Node rev = r.reverse(a);
        print(rev);
    }
}
