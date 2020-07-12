package com.techproed;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Assertions {

    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
    }

    @Test
    public void titleTest() {

        String actualTitle = driver.getTitle();
        String expectedResult = "Google";

        Assert.assertEquals(expectedResult,actualTitle);

//        if (actualTitle.equals(expectedResult)) {
//            System.out.println("PASS");
//        } else {
//            System.out.println("FAIL");
//            System.out.println("actualTitle is: "+actualTitle);
//            System.out.println("expectedResult is: "+expectedResult);
//        }
    }

    @Test
    public void imageTest(){


        WebElement googleImg=driver.findElement(By.id("hplogo"));

        Assert.assertTrue(googleImg.isDisplayed());
//        Assert.assertFalse(googleImg.isDisplayed());


//        if (googleImg.isDisplayed()){
//            System.out.println("PASS");
//        }else {
//            System.out.println("FAIL");
//        }
    }

    @Test
    public void gmailLinkTest () {


        WebElement gmailLink=driver.findElement(By.linkText("Gmail"));

        Assert.assertTrue(gmailLink.isDisplayed());
//        Assert.assertFalse(gmailLink.isDisplayed());
//        if (gmailLink.isDisplayed()){
//            System.out.println("PASS");
//        }else{
//            System.out.println("FAIL");
//        }

    }
    @After
    public void tearDown(){
        driver.close();
    }

}
