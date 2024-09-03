package main.java.com.fishingbooker.pages;

import org.openqa.selenium.By;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import main.java.com.fishingbooker.id.FilterPageID;

public class FilterPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public FilterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void applyFilters() {
        applyFilter(FilterPageID.REVIEW_SCORE_FILTER, FilterPageID.REVIEW_SCORE_OPTION);
        applyFilter(FilterPageID.FISHING_TYPE_FILTER, FilterPageID.INSHORE_FISHING_OPTION);
        applyFilter(FilterPageID.FISH_TYPE_FILTER, FilterPageID.RED_SNAPPER_OPTION);
    }

    private void applyFilter(String filterId, String optionId) {
        WebElement filterElement = driver.findElement(By.xpath(filterId));
        filterElement.click();

        WebElement optionElement = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath(optionId)));
        optionElement.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(FilterPageID.SEARCH_RESULT)));
    }
}
