package user;

import base.BaseTests;
import base.BaseTests2;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.UserListsPage;

import static org.testng.Assert.assertEquals;

public class ListsTests extends BaseTests2 {
   WebDriver driver;

    @Test
    public void testListCreation(){
        String LstName = "List 1";
        UserListsPage lst= homePage.clickListButton();
        lst.clickCreateListButton();
        lst.insertListName(LstName);
        lst.clickCreateButton();
        assertEquals(lst.getFirstListName(),LstName);
    }

    @Test
    public void testPrivacyModification() {
        String mode = "Public";
        UserListsPage lst= new UserListsPage(driver);
        lst.hoverToMore();
        lst.clickManageListButton();
        lst.selectPrivacy(mode);
        lst.clickSaveListButton();
        assertEquals(lst.getFirstListPrivacy(),mode);

    }
}