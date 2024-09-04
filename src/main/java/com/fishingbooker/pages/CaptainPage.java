package main.java.com.fishingbooker.pages;

import org.openqa.selenium.By;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import main.java.com.fishingbooker.id.CaptainPageID;

import java.util.List;

public class CaptainPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public CaptainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectFirstAnglersChoice() {
        List<WebElement> anglersChoiceList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath(CaptainPageID.ANGLERS_CHOICE_LABEL)));

        if (!anglersChoiceList.isEmpty()) {
            WebElement firstAnglersChoice = anglersChoiceList.get(0);
            firstAnglersChoice.click();
            switchToNewWindow();
        } else {
            throw new AssertionError("No Angler's Choice found on the page.");
        }
    }

    private void switchToNewWindow() {
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public void sendMessage(String date, String message) {
        WebElement messageCaptainButton = driver.findElement(By.xpath(CaptainPageID.MESSAGE_CAPTAIN_BUTTON));
        messageCaptainButton.click();

        WebElement groupSizeDropdown = driver.findElement(By.xpath(CaptainPageID.GROUP_SIZE_DROPDOWN));
        groupSizeDropdown.click();
        WebElement groupSizeOption = driver.findElement(By.xpath(CaptainPageID.GROUP_SIZE_OPTION_2));
        groupSizeOption.click();

        WebElement messageDatePicker = driver.findElement(By.xpath(CaptainPageID.MESSAGE_DATE_PICKER));
        messageDatePicker.click();

        List<WebElement> availableDates = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath(CaptainPageID.AVAILABLE_DATE)));

        if (!availableDates.isEmpty()) {
            availableDates.get(availableDates.size() - 1).click();
        } else {
            WebElement nextMonthButton = driver.findElement(By.xpath(CaptainPageID.NEXT_MONTH_BUTTON));
            nextMonthButton.click();

            availableDates = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                    By.xpath(CaptainPageID.AVAILABLE_DATE)));

            if (!availableDates.isEmpty()) {
                availableDates.get(availableDates.size() - 1).click();
            } else {
                throw new AssertionError("No available dates found in the next month.");
            }
        }

        WebElement tripDropdown = driver.findElement(By.xpath(CaptainPageID.TRIP_SELECT_DROPDOWN));
        tripDropdown.click();
        List<WebElement> tripOptions = driver.findElements(By.xpath(CaptainPageID.TRIP_OPTIONS));
        tripOptions.get(tripOptions.size() - 1).click();

        WebElement messageField = driver.findElement(By.xpath(CaptainPageID.MESSAGE_FIELD));
        messageField.sendKeys(message);

        WebElement sendMessageButton = driver.findElement(By.xpath(CaptainPageID.SEND_MESSAGE_BUTTON));
        sendMessageButton.click();

        WebElement successModal = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(CaptainPageID.SUCCESS_MODAL)));

        if (!successModal.isDisplayed()) {
            throw new AssertionError("Success modal not displayed.");
        }
    }
}
