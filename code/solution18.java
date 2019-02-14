/* https://www.hackerrank.com/contests/recode-4/challenges/ls-meal */

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String order = sc.next();
        int c, p;
        c = p = -1;
        
        /* swap first cake with last pie */
        for(int i=0;i<order.length();i++){
            if(order.charAt(i) == 'c'){
                c=i;
                break;
            }
        }
        
        for(int i=order.length()-1;i>=0;i--){
            if(order.charAt(i) == 'p'){
                p=i;
                break;
            }
        }
        
        if(p == -1 || c == -1)
            System.out.println(0);
        else {
            
            long taste = 0;
            int prev = 0;
            char[] ch = order.toCharArray();
            
            if(p > c) {
                ch[c] = 'p';
                ch[p] = 'c';
            }
            
            for(int i=0;i<order.length();i++)
                if(ch[i] == 'c') prev++;
                else taste += prev;
            
            prev = 0;
            for(int i=order.length()-1;i>=0;i--)
                if(ch[i] == 'p') prev++;
                else taste += prev;
            
            System.out.println(taste);
        }
    }
}
