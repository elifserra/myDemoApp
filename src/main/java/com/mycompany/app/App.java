package com.mycompany.app;

import java.util.*;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(13);
        a.add(12);
        a.add(11);
        a.add(10);

        System.out.println(search(a, 13));

        System.out.println( "Hello World!" );
    }
    public static boolean search(ArrayList<Integer> array, int a) {
        System.out.println("Inside search");
        if(array == null) return false;

        for (int i : array) {
            if (i == a) {
                return true;
            }
        }

        return false;
    }
}
