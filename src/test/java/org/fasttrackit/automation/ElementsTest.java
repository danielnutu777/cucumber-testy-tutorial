package org.fasttrackit.automation;
import com.sdl.selenium.bootstrap.button.Upload;
import com.sdl.selenium.bootstrap.button.UploadFile;
import com.sdl.selenium.bootstrap.form.DatePicker;
import com.sdl.selenium.bootstrap.form.Form;
import com.sdl.selenium.bootstrap.form.MultiSelect;
import com.sdl.selenium.web.utils.PropertiesReader;
import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.util.TestBase;
import org.testng.annotations.Test;

import java.util.Locale;

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

        //page.tech.select("Manual");
    }

    @Test
    public void dropDownComponentTest() {
        openLoginPage();
        loginView.login("eu@fast.com", "eu.pass");

        DropDown dropDown = new DropDown();
        dropDown.select("Manual");

        Utils.sleep(500);
        dropDown.select("Manual");

        MultiSelect source = new MultiSelect().setClasses("multiselect");//setLabel("Source:");
        source.select("Tomatoes", "Mozzarella");

        DatePicker datePicker = new DatePicker();
        datePicker.setDate("9", "Apr", "2017");

        Utils.sleep(2000);

        datePicker.select("11/03/2016", "dd/MM/yyyy", Locale.ENGLISH);
    }


    private Form form = new Form("Form Title");
    private UploadFile uploadFile = new UploadFile(form);

    @Test
    public void uploadTest(){
        openLoginPage();
        loginView.login("eu@fast.com", "eu.pass");

       uploadFile.upload(PropertiesReader.RESOURCES_DIRECTORY_PATH + "\\feature\\login\\login.feature");

    }
}
