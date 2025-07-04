package tests;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckBoxPage;

public class CheckBoxTest extends BaseTest {

    @Test
    public void testSelectDesktopCheckbox() {
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);
        checkBoxPage.open();

        //Раскрываем все папки
        checkBoxPage.toggleAllFolders();

        //Выбираем чекбокс десктоп
        checkBoxPage.selectCheckboxByLabel("Desktop");

        //Проверяем результат
        Assert.assertTrue(checkBoxPage.isResultDisplayedFor("Desktop"), "Результат должен содержать `desktop`");
    }

    @Test
    public void testSelectDocumentsCheckbox() {
        CheckBoxPage checkBoxPage = new CheckBoxPage(driver);
        checkBoxPage.open();

        checkBoxPage.toggleAllFolders();
        checkBoxPage.selectCheckboxByLabel("Documents");

        Assert.assertTrue(checkBoxPage.isResultDisplayedFor("Documents"), "Результат должен содержать `documents`");
    }
}
