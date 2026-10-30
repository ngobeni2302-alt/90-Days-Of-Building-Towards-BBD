package com.bbd.day26;
import java.util.*;
// BBD Expert - Minimum Window Substring - O(n)
// Find smallest window in s that contains all chars of t
// s="ADOBECODEBANC", t="ABC" -> "BANC"
public class MinimumWindowSubstring {
    public String minWindow(String s, String t){
        if(t.length() > s.length()) return "";
        Map<Character,Integer> need = new HashMap<>();
        for(char c : t.toCharArray()) need.put(c, need.getOrDefault(c,0)+1);
        Map<Character,Integer> window = new HashMap<>();
        int left=0, valid=0, start=0, minLen=Integer.MAX_VALUE;
        for(int right=0; right<s.length(); right++){
            char c = s.charAt(right);
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c,0)+1);
                if(window.get(c).equals(need.get(c))) valid++;
            }
            while(valid == need.size()){
                if(right-left+1 < minLen){ minLen=right-left+1; start=left; }
                char d = s.charAt(left);
                left++;
                if(need.containsKey(d)){
                    if(window.get(d).equals(need.get(d))) valid--;
                    window.put(d, window.get(d)-1);
                }
            }
        }
        return minLen==Integer.MAX_VALUE ? "" : s.substring(start, start+minLen);
    }
}
