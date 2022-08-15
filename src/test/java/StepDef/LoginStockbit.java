package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginStockbit {
    WebDriver driver;
    @Given("I navigate to {string}")
    public void iNavigateTo(String website) throws InterruptedException {
        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
        System.setProperty("webdriver.chrome.driver", dir+"/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(website);
        Thread.sleep(1000);
    }

    @And("I enter {string} into input field having xpath {string}")
    public void iEnterIntoInputFieldHavingXpath(String username, String field_username) {
        driver.findElement(By.xpath(field_username)).sendKeys(username);
        driver.findElement(By.xpath(field_username)).sendKeys(Keys.ENTER);
    }

    @And("I enter {string} into input field having id {string}")
    public void iEnterIntoInputFieldHavingId(String password, String field_password) {
        driver.findElement(By.id(field_password)).sendKeys(password);
    }

    @When("I click on element having id {string}")
    public void iClickOnElementHavingId(String button) {
        driver.findElement(By.id(button)).click();
    }

    @Then("I wait {int} seconds for element having class {string}")
    public void iWaitSecondsForElementHavingClass(int seconds, String avatar) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS) ;

        if(!driver.findElements(By.className("announcement-modal")).isEmpty()){
            driver.findElement(By.className("skip-btn")).click();
        }

        driver.findElement(By.className(avatar)).click();
        String name_user = driver.findElement(By.className("ant-popover-title")).getText();
        System.out.println(name_user);
        driver.close();
        driver.quit();

    }
}
