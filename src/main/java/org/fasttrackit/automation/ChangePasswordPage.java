package org.fasttrackit.automation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePasswordPage {

    @FindBy(name = "password")
    private WebElement currentPassword;
    @FindBy(name = "newPassword")
    private WebElement newPassword;
    @FindBy(name = "newPasswordRepeat")
    private WebElement repeatPassword;

    public void changePassword(String currentPass, String newPass, String repeatNewPass) {
        currentPassword.sendKeys(currentPass);
        newPassword.sendKeys(newPass);
        repeatPassword.sendKeys(repeatNewPass);
    }
}
