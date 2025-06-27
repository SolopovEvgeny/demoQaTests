package tests;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DemoQaHomePage;

public class DemoQaHomePageTest extends BaseTest {
    private static final String[] EXPECTED_CARDS = {
            "Elements",
            "Forms",
            "Alerts, Frame & Windows",
            "Widgets",
            "Interactions",
            "Book Store Application"
    };

    @Test
    public void testAllCardsAreClickable() {
        DemoQaHomePage homePage = new DemoQaHomePage(driver);
        homePage.open();
        for (String cardName : EXPECTED_CARDS) {
            boolean isClickable = homePage.isCardClickable(cardName);
            Assert.assertTrue(isClickable, "Карточка '" + cardName + "' не кликабельна");
        }
    }

    @Test
    public void testCardsNavigation() {
        DemoQaHomePage homePage = new DemoQaHomePage(driver);
        homePage.open();
        for (String cardName : EXPECTED_CARDS) {
            String initialUrl = driver.getCurrentUrl();
            homePage.clickCard(cardName);
            String newUrl = driver.getCurrentUrl();

            Assert.assertNotEquals(newUrl, initialUrl,
                    "Переход по карточке '" + cardName + "' не произошел");

            driver.navigate().back();
        }
    }
}

