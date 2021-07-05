package lib.ui;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject{

    private static final String
        BUTTON_TITLE = "//*[@resource-id = 'org.wikipedia:id/positiveButton']",
        TOPIC_TITLE = "//*[@resource-id='org.wikipedia:id/view_card_header_title'][@text='{SUBSTRING}']";

    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

    private String getResultSearchElement(String substring){
        return TOPIC_TITLE.replace("{SUBSTRING}",substring);
    }

    public WebElement waitForButtonTitleElement(){
        return this.waitForElementPresent(By.xpath(BUTTON_TITLE),"Cannot find article title on this page",15);
    }
        public WebElement waitForTopicTitleElement(String substring){
            String title_result_xpath = getResultSearchElement(substring);
            return this.waitForElementPresent(By.xpath(title_result_xpath), "Cannot find topic title on this page", 15 );
        }
    public String getArticleButtonTitle(){
        WebElement title_element = waitForButtonTitleElement();
        return title_element.getText();
    }
    public void swipeToTopicTitle(String substring){
        String title_result_xpath = getResultSearchElement(substring);
        this.swipeUpToFindElement(
                By.xpath(title_result_xpath), "Cannot find this article", 10
        );
    }
}
