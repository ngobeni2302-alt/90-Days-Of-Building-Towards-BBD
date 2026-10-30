package com.bbd.day26;
import java.util.*;
// BBD Classic - Sliding Window with HashMap - O(n)
// Longest Substring Without Repeating Characters
// Example: "abcabcbb" -> "abc" -> 3
public class LongestSubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String s){
        Map<Character,Integer> map = new HashMap<>(); // char -> last index
        int left=0, max=0;
        for(int right=0; right<s.length(); right++){
            char c = s.charAt(right);
            if(map.containsKey(c) && map.get(c) >= left){
                left = map.get(c) + 1; // move left past duplicate
            }
            map.put(c, right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
    // Return actual substring too - BBD follow-up
    public String longestSubstring(String s){
        Map<Character,Integer> map = new HashMap<>();
        int left=0, max=0, start=0;
        for(int right=0; right<s.length(); right++){
            char c = s.charAt(right);
            if(map.containsKey(c) && map.get(c) >= left) left = map.get(c)+1;
            map.put(c,right);
            if(right-left+1 > max){ max = right-left+1; start=left; }
        }
        return s.substring(start, start+max);
    }
    public static void main(String[] args){
        LongestSubstringWithoutRepeating sol = new LongestSubstringWithoutRepeating();
        System.out.println(sol.lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(sol.lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println(sol.longestSubstring("pwwkew")); // wke
    }
}
