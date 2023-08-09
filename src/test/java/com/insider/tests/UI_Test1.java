package com.insider.tests;

import com.insider.pages.UseInsiderPage;
import com.insider.utilities.ConfigurationReader;
import com.insider.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UI_Test1 extends UseInsiderPage {


    @BeforeMethod
    public void setupMethod() {
        Driver.getDriver().get(ConfigurationReader.getProperty("homepage"));
    }

    @Test
    //Test Automation
    //1. Visit https://useinsider.com/ and check Insider home page is opened or not

    public void test1() {
        String expectedTitle = "#1 Leader in Individualized, Cross-Channel CX — Insider";
        String actualTitle = Driver.getDriver().getTitle();
        System.out.println("actualTitle = " + actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

}
