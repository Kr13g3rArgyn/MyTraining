package org.example;
import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args){
        int len = 10;
        double[] arr = new double[len];
        for(int i = 0; i < arr.length; i++){
            arr[i] = Math.random() * 100;

        }
        double avg = 0;
        double max = arr[0], min = arr[0];
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
            if (arr[i] > max){
                max = arr[i];
            }
            if(arr[i] < min){
                min = arr[i];
            }
            avg += arr[i]/arr.length;
        }
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] > arr[j+1]){
                    double temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println("Sorting------------------");
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }

        System.out.println("Maximal value: " + max);
        System.out.println("Minimal value: " + min);
        System.out.println("Average value: " + avg);
    }
}
