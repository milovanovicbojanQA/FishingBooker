package main.java.com.fishingbooker.id;

public class SearchPageID {

    public static final String SEARCH_BOX = "//*[@id='search-box']";
    public static final String SEARCH_RESULTS = "//ul[contains(@class, 'search-results')]//li[1]";
    public static final String DATE_PICKER = "//*[@id='date-picker']";
    public static final String AVAILABLE_DATE = "//td[@class='day' and not(contains(@class, 'old')) and not(contains(@class, 'new'))]";
    public static final String ADULTS_INCREASE = "//*[@id='adults-increase']";
    public static final String ADULTS_COUNT = "//*[@id='adults-count']";
    public static final String CHILDREN_INCREASE = "//*[@id='children-increase']";
    public static final String CHILDREN_COUNT = "//*[@id='children-count']";
    public static final String CHECK_AVAILABILITY = "//*[@id='check-availability']";
    public static final String SEARCH_RESULT = "search-result";
}
