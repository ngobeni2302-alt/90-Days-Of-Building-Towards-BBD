package com.bbd.day25;
import java.util.*;
// BBD #7 - Contains Duplicate - HashSet O(n)
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums){
        Set<Integer> seen = new HashSet<>();
        for(int n : nums){
            if(!seen.add(n)) return true; // add returns false if already exists
        }
        return false;
    }
}
