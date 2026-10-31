package com.bbd.day27;
import java.util.*;
// BBD Classic - 3Sum - O(n^2) - MUST SORT FIRST
// Find all unique triplets that sum to 0
// [-1,0,1,2,-1,-4] -> [[-1,-1,2],[-1,0,1]]
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums); // BBD checks if you sort first!
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<nums.length-2; i++){
            if(i>0 && nums[i]==nums[i-1]) continue; // skip duplicate i
            int left=i+1, right=nums.length-1, target=-nums[i];
            while(left<right){
                int sum = nums[left]+nums[right];
                if(sum==target){
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while(left<right && nums[left]==nums[left+1]) left++; // skip dup left
                    while(left<right && nums[right]==nums[right-1]) right--; // skip dup right
                    left++; right--;
                } else if(sum<target) left++;
                else right--;
            }
        }
        return res;
    }
    public static void main(String[] args){
        System.out.println(new ThreeSum().threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
