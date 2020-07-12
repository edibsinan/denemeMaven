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

public class DropDown {
    WebDriver driver;
   @Before
    public void sutUp(){
       WebDriverManager.chromedriver().setup();
       driver=new ChromeDriver();
       driver.get("https://the-internet.herokuapp.com/dropdown");
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
   }
   @Test
    public void dropDown(){
       WebElement selectElement=driver.findElement(By.id("dropdown"));
       Select options= new Select(selectElement);
       String firstSelectOption=options.getFirstSelectedOption().getText();
//       System.out.println("first Select Option : "+firstSelectOption);

       //There are 3 ways to identify dropDown element
       //1. Find by index   2. Find by value 3. Find by visible text
       options.selectByIndex(1);
        //2. Find by value
       options.selectByValue("2");
       //3. Find by visible text
       options.selectByVisibleText("Option 1");

       List<WebElement>allOptions= options.getOptions();
       for (WebElement option:allOptions){
           System.out.println(option.getText());
       }

       System.out.println(options.getOptions().size()==4 ? true : false);
//       OR

       int size=allOptions.size();
       if (size==3){
           System.out.println("True");
       }else{
           System.out.println("False");
       }

       Assert.assertTrue(size==3);
   }




   @After
    public void tearDown(){
       driver.close();
   }
}
