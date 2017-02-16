package org.fasttrackit.automation;
import org.fasttrackit.util.TestBase;
import org.testng.annotations.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ElementsTest extends TestBase {



    @Test
    public void checkboxesTest(){

        openLoginPage();
        loginView.login("eu@fast.com", "eu.pass");

        page.stopProcessCheckbox.click();
        page.labelWithEnterCheckbox.click();

        com.sdl.selenium.web.utils.Utils.sleep(2000);
        page.stopProcessLabel.click();
        page.withEnterLabel.click();

        com.sdl.selenium.web.utils.Utils.sleep(2000);
        page.stopProcessLabel.click();
        page.withEnterLabel.click();

        assertThat("Stop the process is not selected!", page.stopProcessCheckbox.isSelected(), is(true));
        assertThat("Label with Enter.", page.stopProcessCheckbox.isSelected(), is(true));
    }

    @Test
    public void dropDownTest(){
        openLoginPage();
        loginView.login("eu@fast.com", "eu.pass");

        page.autoOption.click();
        page.manualOption.click();
    }

}
