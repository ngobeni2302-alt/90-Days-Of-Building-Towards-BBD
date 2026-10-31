package com.bbd.day27;
// BBD Favorite - Container With Most Water - Two Pointers O(n)
// Height array, find two lines that hold most water: area = min(height[l],height[r]) * (r-l)
public class ContainerWithMostWater {
    public int maxArea(int[] height){
        int left=0, right=height.length-1, max=0;
        while(left<right){
            int area = Math.min(height[left], height[right]) * (right-left);
            max = Math.max(max, area);
            if(height[left] < height[right]) left++;
            else right--;
        }
        return max;
    }
    public static void main(String[] args){
        System.out.println(new ContainerWithMostWater().maxArea(new int[]{1,8,6,2,5,4,8,3,7})); // 49
    }
}
