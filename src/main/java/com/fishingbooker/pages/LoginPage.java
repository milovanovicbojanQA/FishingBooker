package main.java.com.fishingbooker.pages;

import org.openqa.selenium.By;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import main.java.com.fishingbooker.id.LoginPageID;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void login(String email, String password) {
        clickLoginButton();
        focusAndInputEmail(email);
        clickContinueWithEmail();
        focusAndInputPassword(password);
        submitLogin();
    }

    private void clickLoginButton() {
        WebElement loginButton = driver.findElement(By.xpath(LoginPageID.LOGIN_BUTTON));
        loginButton.click();
    }

    private void focusAndInputEmail(String email) {
        WebElement emailField = driver.findElement(By.xpath(LoginPageID.EMAIL_FIELD));
        emailField.click();
        emailField.sendKeys(email);
    }

    private void clickContinueWithEmail() {
        WebElement continueWithEmailButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(LoginPageID.CONTINUE_WITH_EMAIL)));
        continueWithEmailButton.click();
    }

    private void focusAndInputPassword(String password) {
        WebElement passwordField = driver.findElement(By.xpath(LoginPageID.PASSWORD_FIELD));
        passwordField.click();
        passwordField.sendKeys(password);
    }

    private void submitLogin() {
        WebElement submitButton = driver.findElement(By.xpath(LoginPageID.SUBMIT_BUTTON));
        submitButton.click();
    }
}
