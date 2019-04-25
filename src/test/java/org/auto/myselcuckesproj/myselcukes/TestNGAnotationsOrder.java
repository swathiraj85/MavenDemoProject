package org.auto.myselcuckesproj.myselcukes;

import org.testng.annotations.*;

class TestNGAnotationsOrder
{
 @BeforeSuite
 public static void beforeSuite()
 {
	 System.out.println("Before Suite");
 }
 @BeforeClass
 public static void beforeClass()
 {
	 System.out.println("Before Class");
 }
 @BeforeMethod
 public static void beforeMethod()
 {
	 System.out.println("Before Method");
 }
 @BeforeTest
 public static void beforeTest()
 {
	 System.out.println("Before Test");
 }
 @Test(groups= {"g2","g1"})
 public static void test1()
 {
	 System.out.println("Test 1");
 }
 @AfterTest
 public static void afterTest()
 {
	 System.out.println("After Test");
 }
 @Test(groups= {"g1"})
 public static void test2()
 {
	 System.out.println("Test 2");
 }
 @AfterMethod()
 public static void afterMethod()
 {
	 System.out.println("After Method");
 }
 @AfterClass
 public static void afterClass()
 {
	 System.out.println("After Class");
 }
 @AfterSuite
 public static void afterSuite()
 {
	 System.out.println("After Suite");
 }
}