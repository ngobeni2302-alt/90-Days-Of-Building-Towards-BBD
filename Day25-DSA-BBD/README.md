# Day 25 / 90 - DSA Sprint - BBD Interview Patterns

## BBD Grad Interview Top 7:

1. Two Sum - HashMap O(n) - Day 25
2. Reverse LinkedList - 3 pointers - from Day 14 MyLinkedList
3. Valid Parentheses - Stack
4. Binary Search - mid = left + (right-left)/2 overflow-safe - from Day 13
5. Merge Two Sorted Lists - dummy node
6. Best Time to Buy Sell - track min
7. Contains Duplicate - HashSet

### Run:
mvn test
mvn exec:java -Dexec.mainClass="com.bbd.day25.TwoSum"
mvn exec:java -Dexec.mainClass="com.bbd.day25.BBDPatternsCheatsheet"

### BBD Interview Flow:
1. Clarify edge cases
2. Brute force O(n^2)
3. Optimize to O(n) with HashMap/Stack
4. Code
5. Complexity analysis
6. Test

### Next 5 days plan:
Day 26: Sliding Window - Longest Substring Without Repeating
Day 27: Two Pointers - 3Sum
Day 28: Recursion - Fibonacci, Factorial + memoization
Day 29: Sorting - QuickSort implementation
Day 30: Mock Interview - combine all

LinkedIn Day 25:
"Day 25/90 - DSA Sprint. From Spring Boot to algorithms. BBD grad interviews love Two Sum, Reverse LinkedList, Valid Parentheses. Today I cooked 7 patterns in Java. Still bringing to the table. #BBD #DSA #Java"

Commit: git add Day25-DSA-BBD/ && git commit -m "Day 25: DSA sprint - 7 BBD interview patterns - TwoSum, ReverseLL, Stack, BinarySearch"
