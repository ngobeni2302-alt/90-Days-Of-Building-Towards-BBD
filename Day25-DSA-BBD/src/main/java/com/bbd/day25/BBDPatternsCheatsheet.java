package com.bbd.day25;
// Day 25 Cheatsheet - What BBD asks in Grad Interviews

/*
PATTERN 1: HashMap
- TwoSum, Contains Duplicate
- Trick: value -> index map, check need = target - current
- Time: O(n), Space: O(n)

PATTERN 2: Two Pointers / 3 Pointers
- Reverse LinkedList, Merge Two Lists
- Trick: prev, curr, next - draw it
- BBD: "Reverse your Day14 MyLinkedList"

PATTERN 3: Stack
- Valid Parentheses
- Trick: push open, pop on close and check match
- BBD loves: "How would you validate JSON brackets?"

PATTERN 4: Binary Search
- mid = left + (right-left)/2 (NOT (left+right)/2 overflow!)
- BBD checks overflow knowledge

PATTERN 5: Sliding Window / Greedy
- Best Time Buy Sell
- Trick: track minPrice, calculate profit

HOW TO ANSWER IN BBD INTERVIEW:
1. Clarify: "Can array be empty? Sorted?"
2. Brute force first: O(n^2)
3. Optimize: "Can we use HashMap to make O(n)?"
4. Code + edge cases
5. Complexity: O(n) time, O(n) space

Lucky quote still: "if you want to work at BBD, you need to know how to cook. You need to bring something to the table."
Today you bring DSA to the table.
*/
public class BBDPatternsCheatsheet {}
