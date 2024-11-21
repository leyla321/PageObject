package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends AbsBasePage {
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#username")
    private WebElement username;

    @FindBy(css = "#email")
    private WebElement email;

    @FindBy(css = "#password")
    private WebElement password;
    @FindBy(css = "#confirm_password")
    private WebElement confirmPassword;

    @FindBy(css = "#birthdate")
    private WebElement birthdate;

    @FindBy(css = "#language_level")
    private WebElement languageLevelList;

    @FindBy(xpath = "//option[@value='intermediate']")
    private WebElement languageLevel;

    @FindBy(xpath = "//input[@type=\"submit\"]")
    private WebElement registrationBtn;

    @FindBy(css = "#output")
    private WebElement output;

    public RegistrationPage registerInTheForm() {
        type(username, "Leyla");
        type(email, "test123@gmail.com");
        type(password, "passwordTest765");
        type(confirmPassword, "passwordTest765");
        type(birthdate, "03.03.2024");
        clickElement(languageLevelList);
        clickElement(languageLevel);
        clickElement(registrationBtn);
        return new RegistrationPage(driver);
    }

    public RegistrationPage passwordValidation() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        String enteredPassword = password.getAttribute("password");
        String enteredConfirmPassword = confirmPassword.getAttribute("confirmPassword");

        Assert.assertEquals("Passwords do not match!", enteredPassword, enteredConfirmPassword);
        System.out.println("Passwords are equal");
        return registrationPage;
    }

    public RegistrationPage dataValidationAfterRegistration() {
        RegistrationPage registrationPage = new RegistrationPage(driver);

        String outputText = output.getText();

        String expectedName = "Имя пользователя: Leyla";
        String expectedEmail = "Электронная почта: test123@gmail.com";
        String expectedBirthdate = "Дата рождения: 2024-03-03";
        String expectedLangLevel = "Уровень языка: intermediate";

        String actualName = output.getAttribute("output");
        String actualMail = output.getAttribute("output");
        String actualBirthdate = output.getAttribute("output");
        String actualLangLevel = output.getAttribute("output");

        Assert.assertTrue("User name is incorrect", outputText.contains(expectedName));
        Assert.assertTrue("Email is incorrect", outputText.contains(expectedEmail));
        Assert.assertTrue("Birthdate is incorrect", outputText.contains(expectedBirthdate));
        Assert.assertTrue("Language level is correct", outputText.contains(expectedLangLevel));

        System.out.println("All data is displayed correctly!");

        return registrationPage;
    }
}
