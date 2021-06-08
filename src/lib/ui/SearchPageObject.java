package lib.ui;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject{

    private static final String
        SKIP_BUTTON = "//*[@resource-id= 'org.wikipedia:id/fragment_onboarding_skip_button']",
        SEARCH_INIT_ELEMENT = "//*[@resource-id = 'org.wikipedia:id/search_container']",
        SEARCH_INPUT = "//*[@resource-id = 'org.wikipedia:id/search_src_text']",
        SEARCH_BACK_BUTTON = "//*[@class='android.widget.ImageButton']",
        SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[@resource-id='org.wikipedia:id/page_list_item_description'][@text='{SUBSTRING}']",
        TITLE_IMAGE = "//*[@resource-id = 'org.wikipedia:id/view_page_header_image']";


    public SearchPageObject(AppiumDriver driver) {
        super(driver);
    }
//    Templates Methods
    private static String getResultSearchElement(String substring){
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}",substring);
    }
    public void skipConfig(){
        this.waitForElementAndClick(By.xpath(SKIP_BUTTON), "Cannot find and click skip button",5);
    }
    public void initSearchInput(){
        this.waitForElementAndClick(By.xpath(SEARCH_INIT_ELEMENT),"Cannot find and click search init element",5);
        this.waitForElementPresent(By.xpath(SEARCH_INIT_ELEMENT),"Cannot find search input after clicking search init element");
    }

    public void typeSearchLine(String search_line){
        this.waitForElementAndSendKeys(By.xpath(SEARCH_INPUT),search_line, "Cannot find and type into search line",5);

    }
    public void waitForSearchResult(String substring){
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(By.xpath(search_result_xpath), "Cannot find search result");
    }
    public void waitForBackButtonToAppear(){
        this.waitForElementPresent(By.xpath(SEARCH_BACK_BUTTON),"Cannot find search cancel button",5);
    }
    public void waitForBackButtonToDisappear(){
        this.waitForElementNotPresent(By.xpath(SEARCH_BACK_BUTTON),"search cancel button is still present",5);
    }
    public void clickForBackSearch(){
        this.waitForElementAndClick(By.xpath(SEARCH_BACK_BUTTON),"Cannot find and click cancel button",5);
    }
    public void clickByArticleWithSubstring(String substring){
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(By.xpath(search_result_xpath), "Cannot find and click search result",10);
    }
    public void clickForTitleImage(){
        this.waitForElementAndClick(By.xpath(TITLE_IMAGE), "Cannot find and click image",5 );
    }
}
