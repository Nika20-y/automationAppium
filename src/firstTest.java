import lib.coreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MainPageObject;
import lib.ui.SearchPageObject;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class firstTest extends coreTestCase {
    private MainPageObject MainPageObject;

    protected void setUp() throws Exception{
        super.setUp();

        MainPageObject = new MainPageObject(driver);
    }

    @Test
    public void testSearch(){

//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[@resource-id= 'org.wikipedia:id/fragment_onboarding_skip_button']"),
//                "Cannot find skip button",
//                5);
//
//        MainPageObject.waitForElementAndClick(
//                By.xpath("//*[@resource-id = 'org.wikipedia:id/search_container']"),
//                "Cannot find 'Search Wikipedia' input",
//                5
//        );
//        MainPageObject.waitForElementAndSendKeys(
//                By.xpath("//*[@resource-id = 'org.wikipedia:id/search_src_text']"),
//                "Java",
//                "Cannot find search input",
//                5
//        );
//        MainPageObject.waitForElementAndClick(
//                By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]"),
//                "Cannot find 'Search Wikipedia' input",
//                5
//        );
//        MainPageObject.waitForElementPresent(
//                By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_description'][@text='Object-oriented programming language']"),
//                "Cannot find 'Object-oriented programming language' topic searching by 'Java'",
//                15
//        );

        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.skipConfig();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForSearchResult("язык программирования");
    }

    @Test
    public void testCancelSearch(){
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.skipConfig();
        SearchPageObject.initSearchInput();
        SearchPageObject.waitForBackButtonToAppear();
        SearchPageObject.clickForBackSearch();
        SearchPageObject.waitForBackButtonToDisappear();
    }
    @Test
    public void testCompareArticleTitle(){
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.skipConfig();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("язык программирования");
        SearchPageObject.clickForTitleImage();
        SearchPageObject.clickForBackSearch();


        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        String article_title = ArticlePageObject.getArticleTitle();

        Assert.assertEquals("We see unexpected title",
                "язык программирования",
                article_title);


    }


}
