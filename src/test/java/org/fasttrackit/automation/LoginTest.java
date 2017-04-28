package org.fasttrackit.automation;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.table.Table;
import org.fasttrackit.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class LoginTest extends TestBase {

      //private LoginPage page;
        private LoginView page = new LoginView();

     /* public LoginTest() {

            page = PageFactory.initElements(driver, LoginPage.class);
    }*/

        @Test
            public void validLoginTest() {
            openLoginPage();

            page.login("eu@fast.com","eu.pass");

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
            openLoginPage();

            page.login("eu@fast.com", "wrongpass");

                WebElement errorElement = driver.findElement(By.className("error-msg"));
                System.out.println(errorElement.getText());
                assertThat(errorElement.getText(), is("Invalid user or password!"));
    }


        @Test
        public void validLoginTestWithMultipleAccountsSetup(){

            openLoginPage();
        }

        @Test(dependsOnMethods = "validLoginTestWithMultipleAccountsSetup", dataProvider = "emailsProvider")
            public void validLoginTestWithDataProvider(String emails, String passwords){

            page.loginWithMultipleAccounts(emails, passwords);

        }

        @DataProvider
            public static Object[][] emailsProvider(){
            return new Object[][] {
                    {"eu@fast.com","eu.pass"},
                    {"tu@fast.com", "tu.pass"},
                    {"el@fast.com",	"el.pass"}
            };
        }
}
