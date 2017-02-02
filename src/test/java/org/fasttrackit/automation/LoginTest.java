package org.fasttrackit.automation;

import junit.framework.Assert;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.internal.Utils;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LoginTest extends TestBase {

        private LoginPage loginPage;

        public LoginTest() {

            loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

        @Test
            public void validLoginTest() {
            openBrowser();

            loginPage.login("eu@fast.com","eu.pass");

            try{
            WebElement logoutBtn = driver.findElement(By.linkText("Logout"));
            logoutBtn.click();
        }
            catch(NoSuchElementException er){
                org.junit.Assert.fail("Could not login.Logout button was not present");
            }
    }

        @Test
            public void invalidPasswordTest() {
            openBrowser();

            loginPage.login("eu@fast.com", "wrongpass");

            WebElement errorElement = driver.findElement(By.className("error-msg"));
                System.out.println(errorElement.getText());
                assertThat(errorElement.getText(), is("Invalid user or password!"));
    }


}
