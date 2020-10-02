package com.cybertek.tests.day5_testNG_intro_dropdowns;

import org.testng.annotations.*;

public class TestNG_Introduction {

    @BeforeClass
    public void setUpClass(){
        System.out.println("Before class is running...");
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("After class is running...");
    }

    @BeforeMethod
    public void setUpMethod(){
        System.out.println("Before method is running...");
    }

    @AfterMethod
    public void tearDownMethod(){
        System.out.println("After method is running...");
    }

  @Test
    public  void test1(){
        System.out.println("Test1 is running...");
    }

    @Test
     public void test2() {
         System.out.println("Test2 is running...");
     }

     @Test
     public void test3(){
         System.out.println("Test3 class is running...");
         String str1 = "TestNG";
         String str2 = "TestNG";
         String str3 = "asdfasdf";


     }
}
