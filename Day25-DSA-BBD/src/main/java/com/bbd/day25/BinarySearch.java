package com.bbd.day25;
// BBD #4 - Binary Search - from Day 13 but BBD interview version
public class BinarySearch {
    // BBD asks: implement without overflow
    public int search(int[] nums, int target){
        int left=0, right=nums.length-1;
        while(left<=right){
            int mid = left + (right-left)/2; // no overflow - BBD checks this!
            if(nums[mid]==target) return mid;
            else if(nums[mid]<target) left=mid+1;
            else right=mid-1;
        }
        return -1;
    }
    public static void main(String[] args){
        BinarySearch b = new BinarySearch();
        System.out.println(b.search(new int[]{-1,0,3,5,9,12}, 9)); // 4
    }
}
