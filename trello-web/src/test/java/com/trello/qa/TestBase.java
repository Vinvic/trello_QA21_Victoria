package com.trello.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {

    WebDriver driver;
    @BeforeClass
    public void setUp(){
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        openSite("https://trello.com");
        login("vinnitskyvic@gmail.com","sport1973");


    }

    public void login(String email, String password){
        click(By.cssSelector("[href='/login'] "));
        type(By.cssSelector("[type=email]"),email);
        type(By.cssSelector("[type=password]"),password);
        click(By.id("login"));

    }

    public void click(By locator) {

        driver.findElement(locator).click();
    }

    public void type(By locator,String text){

        driver.findElement(locator).click();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);

    }

    public void openSite(String url) {

        driver.get(url);
    }

    @AfterClass
    public void tearDown(){
     driver.quit();


    }

    public void fillBoardCreationForm(String boardName, String qa) {
         type(By.cssSelector("[data-test-id='header-create-board-title-input']"),boardName);
         click(By.cssSelector("[data-test-id='header-create-board-submit-button']"));

     }

    public void selectCreateBoardFromDropDown() {
         click(By.cssSelector("[data-test-id='header-create-board-button']"));
     }

    public void clickOnPlusButtonOnHeader() {
         click(By.cssSelector("[data-test-id='header-create-menu-button']"));

     }


    public void confirmBoardCreation() {
        click((By.cssSelector("[data-test-id='header-create-board-submit-button']")));



    }

    public int getTeamsCount()  {
       // Thread.sleep(5000);
        new WebDriverWait(driver,5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='_mtkwfAlvk6O3f']/../../..//li")));
          return driver.findElements(By.xpath("//*[@class='_mtkwfAlvk6O3f']/../../..//li")).size();
      }

    public void selectCreateTeamFromDropDown() {
         click(By.cssSelector("[data-test-id='header-create-team-button']"));


     }

    public void fillTeamCreationForm(String teamName, String description) {
        type(By.cssSelector("[data-test-id='header-create-team-name-input']"),teamName);
        type(By.cssSelector("textarea"),description);



    }

    public void clickContinueButton() {
          click(By.cssSelector("[type=submit]"));

      }

    public void  returnToHomePage() throws InterruptedException {
        Thread.sleep(10000);
        click(By.cssSelector("a[href='/']"));
       // Thread.sleep(5000);
        click(By.cssSelector("a[href='/']"));
    }

    protected String getTeamNameFromTeamPage() {
        new WebDriverWait(driver,15)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1")));
          return driver.findElement(By.cssSelector("h1")).getText();
      }

    public boolean isUserLoggedIn() {

        return isElementPresent(new By.ByCssSelector("[data-test-id='header-member-menu-button']"));
    }

    public boolean isElementPresent(By locator){

        return driver.findElements(locator).size()>0;

     }

    public void clickXButton() {
     }

    public void clickOnPlusButtonOnLeftNavMenu() {

        click(By.cssSelector(".icon-add.icon-sm"));
    }
}
