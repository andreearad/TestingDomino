package stepsDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static java.lang.Thread.sleep;

public class Domino1 {
    private WebDriver driver;
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") +"/src/main/java/driver/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }
    @After
    public void tearDown(){
        driver.quit();
    }
// --------- Log-in Domino.ro -----------
    @Given("open Domino website")
    public void open_domino_website() throws InterruptedException {
        driver.get("https://www.domino.ro/");
        throw new io.cucumber.java.PendingException();
    }
    @Then("click authentication button")
    public void click_authentication_button() {
        driver.findElement(By.xpath("//*[@src='/images/specific/user1.svg']")).click();
        driver.findElement(By.xpath("//*[@id=\"FullContentHtml\"]/body/div[2]/div[2]/div/div/section/form/div[5]/button")).click();
        throw new io.cucumber.java.PendingException();
    }


    @Then("enter email {string} and continue")
    public void enter_email_and_continue(String em) {
        driver.findElement(By.xpath("//*[@id='Email']")).sendKeys(em);
        driver.findElement(By.xpath("//*[@fdprocessedid='xdzecn']")).click();

        throw new io.cucumber.java.PendingException();
    }

    @Then("enter password {string} and continue")
    public void enter_password_and_continue(String ps) {
        driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(ps);
        throw new io.cucumber.java.PendingException();
    }

//-----------Enter search crieteria---------
   @Then("click home and search appartments")
    public void click_home_and_search_appartments() {
        driver.findElement(By.xpath("//*[@class='level1']")).click();
        driver.findElement(By.xpath("//*[@class='glyphicon glyphicon-search']")).click();
        throw new io.cucumber.java.PendingException();
    }
    @Then("open localization list")
    public void open_localization_list() {
       driver.findElement(By.xpath("//*[@id='selectedcountermain_2']")).click();

        throw new io.cucumber.java.PendingException();
    }
    @Then("select city")
    public void select_city() {
        driver.findElement(By.xpath("//*[@id='selectedcounter_242']")).click();
        driver.findElement(By.xpath("//*[@id='check_242596']")).click();
        throw new io.cucumber.java.PendingException();
    }
    @Then("select neighborhood")
    public void select_neighborhood() {
        driver.findElement(By.xpath("//*[@id='selectedcounter_119']")).click();
        driver.findElement(By.xpath("//*[@id='check_119347']")).click();
        throw new io.cucumber.java.PendingException();
    }
    @Then("select compartment and number of rooms")
    public void select_compartment_and_number_of_rooms() {
        driver.findElement(By.xpath("//*[@id='selectedcountermain_8']")).click();
        driver.findElement(By.xpath("//*[@id='selectedcounter_62']")).click();
        driver.findElement(By.xpath("//*[@id='check_62372']")).click();
        throw new io.cucumber.java.PendingException();
    }
    @Then("select finish and finished appartments")
    public void select_finish_and_finished_appartments() {
        driver.findElement(By.xpath("//*[@id='selectedcountermain_16']")).click();
        driver.findElement(By.xpath("//*[@id='selectedcounter_156']")).click();
        driver.findElement(By.xpath("///*[@id='check_156957']")).click();
        throw new io.cucumber.java.PendingException();
    }
    @Then("show results")
    public void show_results() {
        driver.findElement(By.xpath("//*[@class='btn btn-black fix-bottom btn-hide']")).click();
        throw new io.cucumber.java.PendingException();
    }

}
