package com.bbd.day27;
// Day 27 - Two Sum Sorted (Two Pointers) - O(n) - BBD asks: "What if array is sorted?"
// nums sorted, find two that sum to target, return 1-indexed (LeetCode 167)
public class TwoSumSorted {
    public int[] twoSum(int[] nums, int target){
        int left=0, right=nums.length-1;
        while(left<right){
            int sum = nums[left]+nums[right];
            if(sum==target) return new int[]{left+1, right+1};
            else if(sum<target) left++;
            else right--;
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args){
        TwoSumSorted s = new TwoSumSorted();
        int[] r = s.twoSum(new int[]{2,7,11,15}, 9);
        System.out.println(r[0]+","+r[1]); // 1,2
    }
}
