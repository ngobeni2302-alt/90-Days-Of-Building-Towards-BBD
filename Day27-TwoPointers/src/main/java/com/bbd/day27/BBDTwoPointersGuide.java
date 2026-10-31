package com.bbd.day27;
/*
DAY 27 - TWO POINTERS MASTER

When BBD says two pointers:
1. Array sorted? Use left=0,right=n-1
2. Need O(1) space? Two pointers saves HashMap
3. Triplets? Sort first + outer loop + inner two pointers

BBD Interview Flow for 3Sum:
- Clarify: unique triplets? Can reuse element? Return indices or values?
- Brute: O(n^3) three loops
- Better: Sort O(n log n) + for i + two pointers O(n^2) total O(n^2)
- Code: sort, for i skip duplicate, left=i+1 right=n-1
- Edge: skip duplicates for i, left, right to avoid duplicate triplets
- Complexity: O(n log n) sort + O(n^2) search = O(n^2)

Pattern recognition:
- Sorted array -> two pointers
- Pair sum -> two pointers
- Container water -> move smaller height
- 3Sum -> sort + fixed i + two pointers

Lucky: "bring something to the table" - today you bring O(n^2) optimized from O(n^3)
*/
public class BBDTwoPointersGuide {}
