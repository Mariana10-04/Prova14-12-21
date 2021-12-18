package com.prova_1412.prova_1412.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class  TestSelenium {
    private WebDriver driver;

    private String alertMessage;
    private String id;

    @BeforeAll
    public static void setupDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    void displaysContactWhenRegistere() {

        driver.get("http://localhost:3000");
        driver.findElement(By.id("fornecedores")).click();
        driver.findElement(By.id("create")).click();
        driver.findElement(By.id("outlined-required")).sendKeys("TesteCaraii");
        driver.findElement(By.id("salvar")).click();
        WebDriverWait wait = new WebDriverWait(driver, 15);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        driver.navigate().refresh();
        Assertions.assertThat(driver.findElement(By.id("nome")).isDisplayed());
        String text = driver.findElement(By.id("nome")).getText();
        Assertions.assertThat(text).isEqualTo("Nome: TesteCaraii");
    }
}