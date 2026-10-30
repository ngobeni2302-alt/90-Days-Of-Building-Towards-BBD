package com.bbd.day26;
/*
DAY 26 - SLIDING WINDOW MASTER - BBD Pattern

Template BBD expects:

int left=0, result=0;
Map<> window = new HashMap<>();
for(int right=0; right<n; right++){
    // 1. Expand window: add s[right] to window
    // 2. While window invalid: shrink from left
    // 3. Update result
}

3 BBD QUESTIONS:
1. Longest Substring Without Repeating - left jumps to map.get(c)+1
2. Longest Repeating Replacement - track maxCount, window-maxCount <= k
3. Minimum Window - need map + valid count

BBD Interview Trick: Always ask:
- Can string be empty?
- All same char?
- Upper/lower case?
- O(n) time, O(k) space where k=charset

Draw it: left pointer, right pointer, window [left, right]
Example "abcabcbb":
right=0 a [a] max=1
right=1 b [ab] max=2
right=2 c [abc] max=3
right=3 a duplicate -> left=1 [bca] max=3

Lucky: "if you want to work at BBD, you need to know how to cook." Today you cook sliding windows.
*/
public class BBDSlidingWindowGuide {}
