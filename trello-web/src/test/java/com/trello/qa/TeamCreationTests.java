package com.trello.qa;


import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TeamCreationTests extends TestBase {
    @BeforeClass
    public void ensurePreconditionLogin(){
     if(!isUserLoggedIn()){
         login("vinnitskyvic@gmail.com","sport1973");
     }
    }
    @BeforeMethod
    public void isOnHomePage() throws InterruptedException {
      if (!isTherePersonalBoards()){
      returnToHomePage();
        }

    }

    public boolean isTherePersonalBoards() {
        return isElementPresent(By.xpath("//*[@class='icon-lg icon-member']/../../.."));
    }

    @Test
    public void testTeamCreationFromPlusButtonOnHeader() throws InterruptedException {
        int before = getTeamsCount();
        clickOnPlusButtonOnHeader();
        selectCreateTeamFromDropDown();
        String teamName = "QA21-"+System.currentTimeMillis();
        fillTeamCreationForm(teamName, "descr QA 21");
        clickContinueButton();
        String createdTeamName = getTeamNameFromTeamPage();
        returnToHomePage();
        int after = getTeamsCount();
        Assert.assertEquals(after, before + 1);
        Assert.assertEquals(createdTeamName.toLowerCase(), teamName.toLowerCase());

    }

  @Test
    public void testTeamCreationFromLeftNavMenu() throws InterruptedException {
        int before = getTeamsCount();
        clickOnPlusButtonOnLeftNavMenu();
        fillTeamCreationForm("h", "g");
        clickContinueButton();
        String createdTeamName = getTeamNameFromTeamPage();
        returnToHomePage();
        int after = getTeamsCount();

        Assert.assertEquals(after,before+1);
        Assert.assertEquals(createdTeamName, "h");


    }


    @Test(enabled = false)
    public void testTeamCuncellCreationFromPlusButtonOnHeader() {
        clickOnPlusButtonOnHeader();
        selectCreateTeamFromDropDown();
        fillTeamCreationForm("QA21", "descr QA 21");
        clickXButton();

        Assert.assertTrue(isUserLoggedIn());
    }


}


