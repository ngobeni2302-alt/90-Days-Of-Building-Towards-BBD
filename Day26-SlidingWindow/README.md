# Day 26 / 90 - Sliding Window - BBD Interview Core

## 3 Problems:

1. Longest Substring Without Repeating (LeetCode 3) - BBD Medium
   Map char->lastIndex, left jumps to lastIndex+1
   "abcabcbb" -> 3

2. Longest Repeating Character Replacement (LeetCode 424) - BBD Medium-Hard
   window size - maxCount <= k

3. Minimum Window Substring (LeetCode 76) - BBD Hard
   need map + valid counter

### Template:
int left=0; Map window;
for(right=0..n){
  expand window add right
  while invalid shrink left
  update result
}

Run: mvn test
