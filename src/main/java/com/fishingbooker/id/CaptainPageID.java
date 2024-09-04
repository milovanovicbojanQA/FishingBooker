package main.java.com.fishingbooker.id;

public class CaptainPageID {

    public static final String ANGLERS_CHOICE_LABEL = "//div[contains(@class, 'angler-choice-label')]";
    public static final String MESSAGE_CAPTAIN_BUTTON = "//*[@class='contact-captain']";
    public static final String AVAILABLE_DATE = "//td[@class='day' and not(contains(@class, 'old')) and not(contains(@class, 'new'))]";
    public static final String MESSAGE_DATE_PICKER = "//*[@id='cf-trip-date']";
    public static final String NEXT_MONTH_BUTTON = "//*[@class='datepicker-next']";
    public static final String GROUP_SIZE_DROPDOWN = "//select[@id='groupSizeDropdown']";
    public static final String GROUP_SIZE_OPTION_2 = "//select[@id='groupSizeDropdown']/option[@value='2']";
    public static final String TRIP_SELECT_DROPDOWN = "//select[@id='tripSelectDropdown']";
    public static final String TRIP_OPTIONS = "//select[@id='tripSelectDropdown']/option";
    public static final String MESSAGE_FIELD = "//*[@id='contact-textarea']";
    public static final String SEND_MESSAGE_BUTTON = "//*[@id='send-message']";
    public static final String SUCCESS_MODAL = "//*[@class='success-modal']";
}

