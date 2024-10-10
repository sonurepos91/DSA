package com.example.javatopics.array.probs.easy;

public class RotateAnArray {

    private static void rotateArrayByKGivenPositions (int[] arr, int pos) {

        int k=0;
        while(k<pos){
            int temp= arr[arr.length-1];
            for(int i =arr.length-1;i>0;i--){
                arr[i]=arr[i-1];
            }
            arr[0]=temp;
            k++;
        }

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }

    private static void reverseArray (int[] arr) {
        for(int i=0,j=arr.length-1;i<j;i++,j--){
            int temp = arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }

    private static void rightRotateArray (int pos, int[] arr) {

        pos = pos % arr.length;
        for(int i=0;i<arr.length;i++){
            if(i<pos){
                System.out.print(arr[arr.length+i-pos] + " ");
            }else{
                System.out.print(arr[i-pos] + " ");
            }
        }
    }

    public static void main(String[] args){
        int arr[]={2,5,7,8,10};
        int pos =2;

        rotateArrayByKGivenPositions(arr,pos);
        System.out.println();
        reverseArray(arr);
        System.out.println();
        // Here we will actually not reverse the array but will only print it :
        rightRotateArray(pos,arr);
    }
}
