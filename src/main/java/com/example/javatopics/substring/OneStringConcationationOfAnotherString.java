package com.example.javatopics.substring;

public class OneStringConcationationOfAnotherString {


    private static boolean checkConcat (String str1, String str2) {

        int l1= str1.length();
        int l2 = str2.length();

        if(l1%l2!=0)
            return false;
        int m = l1/l2;

        StringBuilder builder = new StringBuilder();
        while(m>0){
            builder.append(str2);
            m--;
        }
        if(str1.equals(builder.toString()))
            return true;
        return false;
    }


    public static void main(String[] args) {
        String str1 = "abcabcab";
        String str2 = "abc";

        System.out.println(checkConcat(str1, str2));
    }


}
