package com.bbd.day25;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DSATest {
    @Test public void testTwoSum(){ assertArrayEquals(new int[]{0,1}, new TwoSum().twoSum(new int[]{2,7,11,15},9)); }
    @Test public void testValid(){ assertTrue(new ValidParentheses().isValid("()[]{}")); assertFalse(new ValidParentheses().isValid("(]")); }
    @Test public void testBinary(){ assertEquals(4, new BinarySearch().search(new int[]{-1,0,3,5,9,12},9)); }
    @Test public void testProfit(){ assertEquals(5, new BestTimeToBuySell().maxProfit(new int[]{7,1,5,3,6,4})); }
    @Test public void testDup(){ assertTrue(new ContainsDuplicate().containsDuplicate(new int[]{1,2,3,1})); }
}
