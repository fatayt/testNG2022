package com.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Day09_C1_TestNGAnnotation {
    @BeforeMethod
    public void setUp(){
        System.out.println("before kullandik");
    }
    @AfterMethod
public void tearnDown(){
        System.out.println("After kullandik");
    }
    @Test
    public void test1(){
        System.out.println("test1");
    }
    @Test(enabled = false)
    public void test2(){
        System.out.println("test2");
    }
    @Ignore
    @Test
    public void test3(){
        System.out.println("test3");
    }
    @Test(priority = -3)
    public void test4(){
        System.out.println("test4");
    }    @Test
    public void test5(){
        System.out.println("test5");
    }    @Test(priority = 2)
    public void test6(){
        System.out.println("test6");
    }    @Test (priority = 1)
    public void test7(){
        System.out.println("test7");
    }


}