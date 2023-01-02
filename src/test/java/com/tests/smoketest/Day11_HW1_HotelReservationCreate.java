package com.tests.smoketest;

import com.github.javafaker.Faker;
import com.pages.DefaultPage;
import com.pages.HotelRoomPage;
import com.pages.LoginPage;
import com.utilities.ConfigReader;
import com.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

public class Day11_HW1_HotelReservationCreate {

    LoginPage loginPage = new LoginPage();
    DefaultPage defaultPage = new DefaultPage();
    HotelRoomPage hotelRoomPage = new HotelRoomPage();
    Faker faker = new Faker();

    @BeforeMethod
    public void setUp() {
        Driver.getDriver().get(ConfigReader.getProperty("app_url_login"));

        loginPage.advancedLink.click();
        loginPage.proceedLink.click();


        loginPage.username.sendKeys(ConfigReader.getProperty("manager_username"));
        loginPage.password.sendKeys(ConfigReader.getProperty("manager_password"));

        loginPage.loginButton.click();

        //login basarili oldugunu verify ediyoruz
        Assert.assertTrue(defaultPage.addUserButton.isDisplayed());
    }

}
