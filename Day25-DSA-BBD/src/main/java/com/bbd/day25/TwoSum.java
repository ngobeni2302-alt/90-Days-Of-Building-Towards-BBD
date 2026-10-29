package com.bbd.day25;
import java.util.*;
// BBD #1 - Two Sum - HashMap O(n)
// Given array and target, return indices that sum to target
public class TwoSum {
    public int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>(); // value -> index
        for(int i=0;i<nums.length;i++){
            int need = target - nums[i];
            if(map.containsKey(need)){
                return new int[]{map.get(need), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }
    public static void main(String[] args){
        TwoSum s = new TwoSum();
        System.out.println(Arrays.toString(s.twoSum(new int[]{2,7,11,15}, 9))); // [0,1]
    }
}
