# Day 27 / 90 - Two Pointers + 3Sum - BBD Core

## Problems:
1. TwoSum Sorted - left=0,right=n-1 move based on sum<target
2. 3Sum - sort first! O(n^2) - BBD loves duplicate skip
3. Container With Most Water - move smaller height
4. Remove Duplicates Sorted - write pointer

## BBD Trick for 3Sum:
- Sort first (BBD checks)
- Skip duplicate i: if i>0 && nums[i]==nums[i-1] continue
- Skip duplicate left/right after found

Run: mvn test

LinkedIn: "Day 27/90 - Two Pointers. 3Sum from O(n^3) to O(n^2) by sorting first + two pointers. BBD loves duplicate skipping. Still cooking."

Commit: git add Day27-TwoPointers/ && git commit -m "Day 27: Two pointers - 3Sum O(n^2), Container Water, sorted TwoSum"
