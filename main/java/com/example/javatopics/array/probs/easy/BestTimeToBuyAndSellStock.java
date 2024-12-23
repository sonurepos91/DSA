package com.example.javatopics.array.probs.easy;

/*
 a) Use Kadane's Algorithim
* */
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args){
        int[] prices = {7,1,5,3,6,4};
        // O(n^2)
        System.out.println(isProfitThere(prices));

        System.out.println();
        // Kadanes Algorithm : O(n)
        System.out.println(isProfitPossible(prices));

    }

    private static int isProfitPossible (int[] prices) {
        int curr_min=prices[0];
        int maxProfit =0;

        for(int i=1;i<prices.length;i++){
            curr_min = Math.min(curr_min,prices[i]);

            maxProfit =Math.max(maxProfit,prices[i]-curr_min);
        }
        return maxProfit;
    }

    private static int isProfitThere (int[] prices) {

        int curr_max=0;
        int max=0;

        for(int i=0;i< prices.length;i++){
            curr_max= prices[i];
            for(int j=i;j<prices.length;j++){
                curr_max=Math.max(curr_max,prices[j]);
            }
            max = Math.max(max,curr_max-prices[i]);
        }
        return max;
    }
}
