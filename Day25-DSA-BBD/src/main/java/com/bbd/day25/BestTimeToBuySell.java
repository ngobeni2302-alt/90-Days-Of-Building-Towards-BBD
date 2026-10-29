package com.bbd.day25;
// BBD #6 - Best Time to Buy and Sell Stock - Sliding Window / Greedy - O(n)
public class BestTimeToBuySell {
    public int maxProfit(int[] prices){
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int price : prices){
            if(price < minPrice) minPrice = price;
            else if(price - minPrice > maxProfit) maxProfit = price - minPrice;
        }
        return maxProfit;
    }
    public static void main(String[] args){
        System.out.println(new BestTimeToBuySell().maxProfit(new int[]{7,1,5,3,6,4})); // 5
    }
}
