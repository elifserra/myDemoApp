package com.mycompany.app;
import java.lang.reflect.Array;
import java.util.*;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    // normal doğru bir case test ediliyor
    public void testNormal() {
        ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(17, 3, 8, 7));
        ArrayList<String> str = new ArrayList<>(Arrays.asList("HelLo", "woRld"));
        assertTrue((new App().lowerCase(array1, array2, 2, str)).equals("hello world 11"));
    }

    // null string arraylist verince
    public void testNullStringArrayList() {
        ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(17, 3, 8, 7));
        ArrayList<String> str = null;
        assertTrue((new App().lowerCase(array1, array2, 2, str)).equals("11"));
    }


    // string arraylistinin elemanlarından biri null olunca
    public void testNullStringElement() {
        ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(17, 3, 8, 7));
        ArrayList<String> str = new ArrayList<>(Arrays.asList(null, "woRld"));
        assertTrue((new App().lowerCase(array1, array2, 2, str)).equals("world 11"));
    }

    // negatif sayı girilmesi, default olarak 0 yazar
    public void testNegativeInt() {
        ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(17, 3, 8, 7));
        ArrayList<String> str = new ArrayList<>(Arrays.asList("HelLo", "woRld"));
        assertTrue((new App().lowerCase(array1, array2, -3, str)).equals("hello world 0"));
    }

    // int sınırların dışında verilirse
    public void testIntOutofBounds() {
        ArrayList<Integer> array1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ArrayList<Integer> array2 = new ArrayList<>(Arrays.asList(17, 3, 8, 7));
        ArrayList<String> str = new ArrayList<>(Arrays.asList("HelLo", "woRld"));
        assertTrue((new App().lowerCase(array1, array2, 5, str)).equals("hello world 0"));
    }

}
