package org.fasttrackit.automation;
import com.sdl.selenium.web.SearchType;
import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.form.CheckBox;
import org.fasttrackit.util.TestBase;
import org.testng.annotations.Test;
import org.testng.internal.Utils;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ElementsTest extends TestBase {

    private LoginView loginView = new LoginView();

    @Test
    public void checkboxesTest(){

        openLoginPage();
        loginView.login("eu@fast.com", "eu.pass");

        CheckBox stopProcessCheckbox = new CheckBox().setElPath("//form[1]/div[3]//input");
        CheckBox labelWithEnterCheckbox = new CheckBox().setElPath("//form[1]/div[4]/label/input");

        WebLocator stopProcessLabel = new WebLocator().setText("Stop the process?", SearchType.TRIM);
        WebLocator withEnterLabel = new WebLocator().setText("Label with Enter.", SearchType.TRIM, SearchType.CHILD_NODE);

        stopProcessCheckbox.click();
        labelWithEnterCheckbox.click();

        com.sdl.selenium.web.utils.Utils.sleep(2000);
        stopProcessLabel.click();
        withEnterLabel.click();

        com.sdl.selenium.web.utils.Utils.sleep(2000);
        stopProcessLabel.click();
        withEnterLabel.click();

        assertThat("Stop the process is not selected!", stopProcessCheckbox.isSelected(), is(true));
    }
}
