package com.bbd.day27;
// BBD Easy-Med - Remove Duplicates from Sorted Array - Two Pointers O(n) - return k
public class RemoveDuplicatesSorted {
    public int removeDuplicates(int[] nums){
        if(nums.length==0) return 0;
        int write=1; // where to write next unique
        for(int read=1; read<nums.length; read++){
            if(nums[read]!=nums[read-1]){
                nums[write]=nums[read];
                write++;
            }
        }
        return write;
    }
}
