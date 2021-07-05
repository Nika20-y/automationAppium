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
    public void testCompareButtonTitle(){
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.skipConfig();
        SearchPageObject.clickForNavbarFixButton();


        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        String button_title = ArticlePageObject.getArticleButtonTitle();

        Assert.assertEquals("We see unexpected title",
                "ВОЙТИ В ВИКИПЕДИЮ",
                button_title);
    }

    @Test
    public void testSwipeArticle(){
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.skipConfig();

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.swipeToTopicTitle("Изображение дня");

    }

    @Test
    public void testAmountOfNotEmptySearch(){
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.skipConfig();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();

        Assert.assertTrue(
                "We found too few results",
                amount_of_search_results>0
        );
    }

    @Test
    public void testAmountOfEmptySearch(){
        SearchPageObject SearchPageObject = new SearchPageObject(driver);
        SearchPageObject.skipConfig();
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("qraydh");
        SearchPageObject.waitForEmptyResultLabel();
        SearchPageObject.assertThereIsNotResultOfSearch();
    }


}
