package main.java.com.fishingbooker.id;

public class SearchPageID {

    public static final String SEARCH_BOX = "//*[@id='search-form-input-field']";
    public static final String SEARCH_RESULTS = "//ul[contains(@class, 'search-form-suggestion-0')]//li[1]";
    public static final String DATE_PICKER = "//*[@id='group-size-picker-input']";
    public static final String AVAILABLE_DATE = "//td[@class='day' and not(contains(@class, 'old')) and not(contains(@class, 'new'))]";
    public static final String GROUP_SIZE_DROPDOWN_BUTTON = "//*[@id='group-size-dropdown-button']";  // Dodajte ovaj red
    public static final String ADULTS_INCREASE = "//*[@id='adults-plus']";
    public static final String ADULTS_COUNT = "//*[@id='adults-count']";
    public static final String CHILDREN_INCREASE = "//*[@id='children-plus']";
    public static final String CHILDREN_COUNT = "//*[@id='children-count']";
    public static final String CHECK_AVAILABILITY = "//*[@id='search-form-check-availability-button']";
    public static final String SEARCH_RESULT = "search-result";
}
