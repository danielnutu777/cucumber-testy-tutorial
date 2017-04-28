package org.fasttrackit.automation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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
    public String getStatusMessage2(){
        String msg2 = statusMsg.getText();
        System.out.println(msg2);
        return msg2;
    }
    public void changePass(String current, String newP, String repeat){
        currentPassword.sendKeys(current);
        newPassword.sendKeys(newP);
        repeatPassword.sendKeys(repeat);
        saveBtn.click();

    }
    public void clearPass(){
        currentPassword.clear();
        newPassword.clear();
        repeatPassword.clear();
    }
}
