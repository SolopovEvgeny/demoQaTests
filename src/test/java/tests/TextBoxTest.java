package tests;

import models.TextBoxFormModel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TextBoxPage;
import core.BaseTest;

public class TextBoxTest extends BaseTest {
    @Test
    public void testTextBoxSubmit() {
        TextBoxFormModel form = TextBoxFormModel.builder()
                .fullName("John Doe")
                .email("john@example.com")
                .currentAddress("123 Main St")
                .permanentAddress("456 Second Ave")
                .build();
        TextBoxPage textBoxPage = new TextBoxPage(driver);
        textBoxPage.open();
        textBoxPage.fillForm(form);
        textBoxPage.submitForm();

        Assert.assertTrue(textBoxPage.isOutputDisplayed(), "Output should be displayed after form submission");

        // Проверяем, что вывод содержит введенные данные
        String outputText = textBoxPage.getOutputText();
        Assert.assertTrue(outputText.contains("Name:" + form.getFullName()), "Output should contain name");
        Assert.assertTrue(outputText.contains("Email:" + form.getEmail()), "Output should contain email");
        Assert.assertTrue(outputText.contains("Current Address :" + form.getCurrentAddress()), "Output should contain current address");
        Assert.assertTrue(outputText.contains("Permananet Address :" + form.getPermanentAddress()), "Output should contain permanent address");
    }
}
