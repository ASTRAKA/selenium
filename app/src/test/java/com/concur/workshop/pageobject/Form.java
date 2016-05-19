package com.concur.workshop.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * @author AndrejS
 */
public class Form {

    private WebDriver driver;

    public Form(WebDriver driver) {
        this.driver = driver;
    }

    public void setNickname(String nickname) {
        driver.findElement(By.xpath("//input[@name='nickname']")).sendKeys(nickname);
    }

    public void setMessage(String message) {
        driver.findElement(By.xpath("//textarea[@name='text']")).sendKeys(message);
    }

    public void sendMessage() {
        driver.findElement(By.xpath("//input[@name='send_message']")).click();
    }

    public String getLineText(int lineIndex) {
        return driver.findElement(By.xpath("//p[" + lineIndex + "]")).getText();
    }
}
