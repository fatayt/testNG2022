package com.tests.smoketest;

import com.github.javafaker.Faker;
import com.pages.DefaultPage;
import com.pages.HotelReservationPage;
import com.pages.HotelRoomPage;
import com.pages.LoginPage;
import com.utilities.ConfigReader;
import com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day11_HW1_HotelReservationCreate {

    LoginPage loginPage = new LoginPage();
    DefaultPage defaultPage = new DefaultPage();
    HotelRoomPage hotelRoomPage = new HotelRoomPage();
    HotelReservationPage hotelReservationPage = new HotelReservationPage();
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

    @Test
    public void hotelReservationCreate() throws InterruptedException {
        //hotel managemente click yap
        defaultPage.hotelManagement.click();

        // Room reservations click yap
        defaultPage.roomreservations.click();
       // Thread.sleep(5000);

        // Add room reservation click yap
        hotelReservationPage.addRoomReservation.click();

        // zorunlu butun alanlari doldurun
        // id hotel dropdown
        Select selectFirst = new Select(hotelReservationPage.idFirstDropDown);
        selectFirst.selectByIndex(1);

        // id hotelroom dropdown
        Select selectSecond = new Select(hotelReservationPage.idSecondDropDown);
        selectSecond.selectByIndex(9);

        //price
        hotelReservationPage.price.sendKeys("1200");
        Thread.sleep(3000);
        //DateStart
        hotelReservationPage.dateStart.sendKeys("02/01/2023");
        Thread.sleep(3000);
        //DateEnd
        hotelReservationPage.dateEnd.sendKeys("01/08/2023");

        //adultAmount
        hotelReservationPage.adultAmount.sendKeys("2");

        //childrenAmount
        hotelReservationPage.childrenAmount.sendKeys("3");

        //ContactNameSurname
        hotelReservationPage.contactNameSurname.sendKeys(faker.name().lastName());

        //ContactPhone
        hotelReservationPage.contactPhone.sendKeys(faker.phoneNumber().cellPhone());

        //contactEmail
        hotelReservationPage.contactEmail.sendKeys(faker.internet().emailAddress());

        //notes
        hotelReservationPage.notes.sendKeys("I want to be treated like a king");
        Thread.sleep(3000);
        //approved
        hotelReservationPage.approved.click();
        Thread.sleep(3000);
        //isPaid
        hotelReservationPage.isPaid.click();
        Thread.sleep(3000);

        //submit
        hotelReservationPage.submit.click();
        Thread.sleep(5000);

        //reservasyonu verify et
        System.out.println(hotelReservationPage.popupText.getText());
        hotelReservationPage.footer.click();
        Thread.sleep(5000);
        Assert.assertFalse(hotelReservationPage.popupText.getText().contains("RoomReservation was inserted successfully"));

       //popup Ok click
        hotelReservationPage.ok.click();














    }

}
