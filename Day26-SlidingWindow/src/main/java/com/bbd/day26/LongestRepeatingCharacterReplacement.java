package com.bbd.day26;
import java.util.*;
// BBD Hard Follow-up - Longest Repeating Character Replacement - O(n)
// Given string and k, you can replace k chars to make all same
// Example: "AABABBA", k=1 -> "AABABBA" replace one B -> AAAA -> 4
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k){
        Map<Character,Integer> count = new HashMap<>();
        int left=0, maxCount=0, maxLen=0;
        for(int right=0; right<s.length(); right++){
            char c = s.charAt(right);
            count.put(c, count.getOrDefault(c,0)+1);
            maxCount = Math.max(maxCount, count.get(c));
            // window size - maxCount = chars to replace
            if((right-left+1) - maxCount > k){
                count.put(s.charAt(left), count.get(s.charAt(left))-1);
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
        }
        return maxLen;
    }
    public static void main(String[] args){
        System.out.println(new LongestRepeatingCharacterReplacement().characterReplacement("AABABBA",1)); // 4
    }
}
