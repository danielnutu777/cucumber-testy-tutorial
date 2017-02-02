package org.fasttrackit.automation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePasswordPage {

    @FindBy(name = "password")
    private WebElement currentPassword;
    @FindBy(name = "newPassword")
    private WebElement newPassword;
    @FindBy(name = "newPasswordRepeat")
    private WebElement repeatPassword;
    @FindBy(xpath = "//*[@id='preferences-win']//button[normalize-space(text())='Save']")
    public WebElement saveBtn;
    @FindBy(className = "status-msg")
    private WebElement statusMsg;
    @FindBy(xpath = "//*[@id='preferences-win']/form//div/div[2]/div[4]")
    private WebElement confirmationMsg;

    public void changePassword(String currentPass, String newPass, String repeatNewPass) {
        currentPassword.sendKeys(currentPass);
        newPassword.sendKeys(newPass);
        repeatPassword.sendKeys(repeatNewPass);
        saveBtn.click();
    }
    public String getStatusMessage() {
        String msg = statusMsg.getText();
        System.out.println(msg);
        return msg;
    }
}
