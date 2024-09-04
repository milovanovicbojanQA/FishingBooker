package main.java.com.fishingbooker.pages;

import org.openqa.selenium.By;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import main.java.com.fishingbooker.id.SearchPageID;

import java.util.List;

public class SearchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void searchFishingTour(String destination, int adults, int children) {
        enterDestination(destination);
        selectFirstSearchResult();
        selectDate();
        selectGroupSize(adults, children);
        checkAvailability();
    }

    private void enterDestination(String destination) {
        WebElement searchBox = driver.findElement(By.xpath(SearchPageID.SEARCH_BOX));
        searchBox.sendKeys(destination);
    }

    private void selectFirstSearchResult() {
        WebElement firstResult = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath(SearchPageID.SEARCH_RESULTS)));
        firstResult.click();
    }

    private void selectDate() {
        WebElement datePicker = driver.findElement(By.xpath(SearchPageID.DATE_PICKER));
        datePicker.click();

        List<WebElement> availableDates = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
                By.xpath(SearchPageID.AVAILABLE_DATE)));
        if (!availableDates.isEmpty()) {
            availableDates.get(0).click();
        } else {
            throw new AssertionError("No available dates found.");
        }
    }

    private void selectGroupSize(int adults, int children) {
        WebElement groupSizeDropdownButton = driver.findElement(By.xpath(SearchPageID.GROUP_SIZE_DROPDOWN_BUTTON));
        groupSizeDropdownButton.click();
        
        adjustGroupSize("adults", adults);
        adjustGroupSize("children", children);
    }

    private void adjustGroupSize(String groupType, int desiredSize) {
        String increaseButtonId = SearchPageID.ADULTS_INCREASE;
        String countFieldId = SearchPageID.ADULTS_COUNT;

        if (groupType.equals("children")) {
            increaseButtonId = SearchPageID.CHILDREN_INCREASE;
            countFieldId = SearchPageID.CHILDREN_COUNT;
        }

        WebElement increaseButton = driver.findElement(By.xpath(increaseButtonId));
        int currentCount = Integer.parseInt(driver.findElement(By.xpath(countFieldId)).getText());

        for (int i = currentCount; i < desiredSize; i++) {
            increaseButton.click();
        }
    }

    private void checkAvailability() {
        WebElement checkAvailabilityButton = driver.findElement(By.xpath(SearchPageID.CHECK_AVAILABILITY));
        checkAvailabilityButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(SearchPageID.SEARCH_RESULT)));
    }
}

