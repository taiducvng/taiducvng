package com.tuhalang.bot.service;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class CommonService {

    protected WebDriver initDriver() {
        //version là version chrome trên máy của bạn
        WebDriverManager.chromedriver().version("86.0.4240.111").setup();
        File profile = new File("src/main/resources/profile");
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless");
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--user-data-dir="+profile.getAbsolutePath());
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }

    protected void sleep(Long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}