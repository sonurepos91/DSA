package com.example.javatopics.array.probs.easy;

public class MaxProductSubArray {


    private static int maxProduct (int[] arr) {

        int max_product=0;
        int curr_max=0;
        int start =0,end=0;
        for(int i=0;i<arr.length;i++){
            curr_max=1;
            for(int j=i;j<arr.length;j++){
                curr_max= curr_max*arr[j];
                if(curr_max>max_product){
                    max_product=curr_max;
                    start=i;
                    end=j;
                }
            }
        }
        for(int i=start;i<=end;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        return max_product;
    }

    private static int maxProductApproach2 (int[] arr) {
        int curr_max= arr[0];
        int curr_min = arr[0];
        int maxProd = arr[0];

        int start=0,end=0;

        for(int i=1;i<arr.length;i++){

           int temp = Math.max(arr[i]*1,Math.max(arr[i]*curr_max,arr[i]*curr_min));
           curr_min = Math.min(arr[i]*1,Math.min(arr[i]*curr_max,arr[i]*curr_min));
           curr_max=temp;
           maxProd= Math.max(curr_max,maxProd);
        }
        System.out.println("i is " + end + " start " + start);
        return maxProd;
    }

    public static void main (String[] args) {

        int arr[] = { -2, 6, -3, -10, 0, 2 };
        // O(n^2)
        System.out.println(maxProduct(arr));
        System.out.println();
        // O(n)
        System.out.println(maxProductApproach2(arr));
    }
}
