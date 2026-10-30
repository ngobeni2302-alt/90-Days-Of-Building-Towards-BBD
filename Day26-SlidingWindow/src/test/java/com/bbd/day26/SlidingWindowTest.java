package com.bbd.day26;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class SlidingWindowTest {
    @Test public void testLongest(){
        LongestSubstringWithoutRepeating s = new LongestSubstringWithoutRepeating();
        assertEquals(3, s.lengthOfLongestSubstring("abcabcbb"));
        assertEquals(1, s.lengthOfLongestSubstring("bbbbb"));
        assertEquals(3, s.lengthOfLongestSubstring("pwwkew"));
    }
    @Test public void testReplacement(){
        assertEquals(4, new LongestRepeatingCharacterReplacement().characterReplacement("AABABBA",1));
    }
    @Test public void testMinWindow(){
        assertEquals("BANC", new MinimumWindowSubstring().minWindow("ADOBECODEBANC","ABC"));
    }
}
