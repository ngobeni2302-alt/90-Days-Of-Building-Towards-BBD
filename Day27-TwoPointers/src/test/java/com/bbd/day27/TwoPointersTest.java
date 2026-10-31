package com.bbd.day27;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
public class TwoPointersTest {
    @Test public void testTwoSumSorted(){ assertArrayEquals(new int[]{1,2}, new TwoSumSorted().twoSum(new int[]{2,7,11,15},9)); }
    @Test public void testThreeSum(){
        List<List<Integer>> r = new ThreeSum().threeSum(new int[]{-1,0,1,2,-1,-4});
        assertEquals(2, r.size());
    }
    @Test public void testContainer(){ assertEquals(49, new ContainerWithMostWater().maxArea(new int[]{1,8,6,2,5,4,8,3,7})); }
    @Test public void testRemoveDup(){ int[] nums={0,0,1,1,1,2,2,3,3,4}; assertEquals(5, new RemoveDuplicatesSorted().removeDuplicates(nums)); }
}
