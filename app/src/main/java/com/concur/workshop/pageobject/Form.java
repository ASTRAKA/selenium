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

    /**
     * this method fill value into nickname field
     *
     * @param nickname to be entered
     */
    public void setNickname(String nickname) {
    }

    /**
     * this method fill value into message field
     *
     * @param message to be entered
     */
    public void setMessage(String message) {
        // TODO: implement
    }

    /**
     * this method clicks Send Message button
     */
    public void sendMessage() {
        // TODO: implement - hint: use click
    }

    /**
     * this method returns text from line specified by index
     *
     * @param lineIndex starts with 1
     * @return text from line specified by index
     */
    public String getLineText(int lineIndex) {
        // TODO: implement - hint: use get text
        return null;
    }

    /**
     * this method return total count of entered messages
     *
     * @return total count of entered messages
     */
    public int getCountOfMessages() {
        // TODO: implement - hint: do not use findElement but search how many p elements are in the DOM
        return 0;
    }
}
