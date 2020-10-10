// Code to illustrate Backtracking in JAVA
// Here the example used is Permuation of Strings
// We will print all the permuations of Strings, the core algorithm at work here is backtracking

import java.util.*;
import java.io.*;

class Permutations{

    // This set will store all the permutations of the given string
    // I have used Set here to avoid repetitions in cases of strings which might have duplicate letters
    static Set<String> stringPermutations = new HashSet<>();

    // Main idea of this function is to keep one variable fixed and keep swapping the rest 
    // until we have completed the cycle.
    private static void backtrack(String str, int l, int r){
        if(l == r){
            stringPermutations.add(str);
        }
        else{
            for(int i=l; i<=r; i++){
                str = swap(str, i, l);
                backtrack(str, l+1, r);
                str = swap(str, i, l);
            }
        }
    }

    private static String swap(String str, int x, int y){
        StringBuilder sb = new StringBuilder(str); 
        sb.setCharAt(x, str.charAt(y)); 
        sb.setCharAt(y, str.charAt(x)); 
        return sb.toString(); 
    }

    public static void main(String[] args){
        String str = "cat";
        backtrack(str, 0, str.length()-1);
        System.out.println("Below are the permutations for string : "+ str);
        for(String p : stringPermutations){
            System.out.print(p + " ");
        }      
}

}


