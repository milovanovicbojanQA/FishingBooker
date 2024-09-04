package main.java.com.fishingbooker.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import main.java.com.fishingbooker.pages.CaptainPage;
import main.java.com.fishingbooker.pages.FilterPage;
import main.java.com.fishingbooker.pages.LoginPage;
import main.java.com.fishingbooker.pages.SearchPage;

public class FishingBookerAutomation {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/usr/local/Caskroom/chromedriver/128.0.6613.119/chromedriver-mac-x64/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://qahiringtask.dev.fishingbooker.com//");

            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("bojantest@gmail.com", "bojantest123!");

            SearchPage searchPage = new SearchPage(driver);
            searchPage.searchFishingTour("Florida", 4, 2);

            FilterPage filterPage = new FilterPage(driver);
            filterPage.applyFilters();

            CaptainPage captainPage = new CaptainPage(driver);
            captainPage.selectFirstAnglersChoice();
            captainPage.sendMessage("Radujem se pecanju, Bojan");

        } finally {
            driver.quit();
        }
    }
}


