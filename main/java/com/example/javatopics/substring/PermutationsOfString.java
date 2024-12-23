package com.example.javatopics.substring;

public class PermutationsOfString {

    public static void main(String[] args){
        String s = "ABC";
        permute(s,"");
    }

    private static void permute (String str, String result) {

        if(str.length()==0){
            System.out.println(result + " ");
            return;
        }

        for(int i=0;i< str.length();i++){
            char ch = str.charAt(i);

            String subString = str.substring(0,i)+ str.substring(i+1);

            permute(subString,result+ch);
        }

    }
}
