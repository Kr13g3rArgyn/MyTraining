package org.example;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main(String[] args ) {
    int [] coins = {1,5,10,20,50,100};
        System.out.println(CoinChange(coins));

    }
    public static int CoinChange(int [] coins){
        int sum = 0;
        for (int coin : coins){
            if (sum+coin <= 500){
                sum+=coin;
            }
            else {
                break;
            }
        }
        return sum;
    }
    public static boolean isPallindrome(String s){
        for(int i = 0; i < s.length()/2; i++){
            if (s.charAt(i) != s.charAt(s.length() - i - 1)){
                return false;
            }
        }
        System.out.println("Sum of couins: ");
        return true;
    }

}


//    String s1= "GAYAG";
//
//        System.out.println(isPallindrome(s1)? true : false);
//}

