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
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDown01 {
    WebDriver driver;
    @Before
    public void start(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

   @Test
    public void dropDown() throws InterruptedException {
        WebElement selectOption=driver.findElement(By.id("dropdown"));
       Select options= new Select(selectOption);

//       options.selectByIndex(2);
//
//       options.selectByValue("1");

       options.selectByVisibleText("Option 2");

       List<WebElement> allOptions= options.getOptions();

       for (WebElement option:allOptions){
           System.out.println(option.getText());
       }

       System.out.println(options.getOptions().size()==3 ? true : false);

       int size =allOptions.size();

       if (size==3){
           System.out.println("PASS IFFF");
       }else{
           System.out.println("FAIL IFFF");
       }

       Assert.assertTrue(size==5);

   }
   @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(5);
        driver.close();
   }
}



