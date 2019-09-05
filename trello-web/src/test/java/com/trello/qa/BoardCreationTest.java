package com.trello.qa;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class BoardCreationTest extends TestBase {

    @Test
    public void testBoardCreation()
    {

      clickOnPlusButtonOnHeader();
      selectCreateBoardFromDropDown();
      fillBoardCreationForm("QA21-1","qa");




    }


}
