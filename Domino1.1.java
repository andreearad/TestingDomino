package stepsDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
        sleep(2000);
        driver.findElement(By.xpath("//*[@aria-label='dismiss cookie message']")).click();
        sleep(1000);
    }
    @And("click authentication button")
    public void click_authentication_button() {
        driver.findElement(By.xpath("//*[@src='/images/specific/user1.svg']")).click();
    }

    @Then("enter email {string} and continue")
    public void enter_email_and_continue(String em) {
        driver.findElement(By.xpath("//*[@id='Email']")).sendKeys(em);
        driver.findElement(By.xpath("//*[contains(text(),'Continua')]")).click();
    }

    @Then("enter password {string} and continue")
    public void enter_password_and_continue(String ps) {
       driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(ps);
    }

//-----------Enter search crieteria---------
   @And("click home and search appartments")
    public void click_home_and_search_appartments() {
       driver.findElement(By.xpath("//*[@class='level1']")).click();
       driver.findElement(By.xpath("//*[@class='glyphicon glyphicon-search']")).click();
   }
    @Then("open localization list")
    public void open_localization_list() throws InterruptedException {
       driver.findElement(By.xpath("//*[contains(text(),'Localizare')]")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Localitate')]")).click();
        sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,100)", "");
    }
    @Then("select city")
    public void select_city() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='atributeultrafiltrationcategory_2']/div[2]/div/div[2]/div[2]/div[1]/div/div[1]/label/span")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,150)", "");
        sleep(1000);
    }
    @Then("select neighborhood")
    public void select_neighborhood() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,70)", "");
        driver.findElement(By.xpath("//*[@id='atributeultrafiltrationcategory_2']/div[3]/div/div[1]")).click();
        js.executeScript("window.scrollBy(0,20)", "");
        driver.findElement(By.xpath("//*[@id='atributeultrafiltrationcategory_2']/div[3]/div/div[2]/div[3]/div[3]/div/div[1]/label/span")).click();
        sleep(1000);
    }
    @Then("select compartment and number of rooms")
    public void select_compartment_and_number_of_rooms() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,50)", "");
        driver.findElement(By.xpath("//*[text()[contains(.,'Compartimentare si anexe')]]")).click();
        sleep(1000);
        js.executeScript("window.scrollBy(0,100)", "");
        driver.findElement(By.xpath("//*[text()[contains(.,'Numar Camere Decomandate')]]")).click();
        sleep(1000);
        js.executeScript("window.scrollBy(0,100)", "");
        driver.findElement(By.xpath("//*[@id='atributeultrafiltrationcategory_8']/div[5]/div/div[2]/div[2]/div[2]/div/div[1]/label/span")).click();
        sleep(1000);
    }
    @Then("select finish and finished appartments")
    public void select_finish_and_finished_appartments() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)", "");
        driver.findElement(By.xpath("//*[@id=\"atributeultrafiltrationcategory_16\"]/div[1]/div[1]/div")).click();
        sleep(1000);
        js.executeScript("window.scrollBy(0,220)", "");
        sleep(1000);
        driver.findElement(By.xpath("//*[contains(text(),'Stare Finisaje Interioare')]")).click();
        sleep(1000);
        js.executeScript("window.scrollBy(0,180)", "");
        sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"atributeultrafiltrationcategory_16\"]/div[3]/div/div[2]/div[2]/div[4]/div/div[1]/label/span")).click();
        sleep(2000);
    }
    @Then("show results")
    public void show_results() throws InterruptedException {
        driver.findElement(By.xpath("//*[@class='btn btn-black fix-bottom btn-hide']")).click();
        sleep(1000);
        String url = driver.getCurrentUrl();
        System.out.println(url);
        throw new io.cucumber.java.PendingException();
    }


// ------   Make a favorite list  ---------

    @Given("click on appartemnt")
    public void click_on_appartemnt() throws InterruptedException {
        driver.get("https://www.domino.ro/cautare-detaliata/productcategory/apartamente-vanzari/ultrafilter1/242-596/119-347/68-1106/159-1257");
        sleep(2000);
        driver.findElement(By.xpath("//*[@aria-label='dismiss cookie message']")).click();
        driver.findElement(By.xpath("//*[@src='/filehandler/ProductFirstFile/500x500/3-camere-mobilat-utilat-parcare-25750-25750.jpg?v=638131040738246261']")).click();
        sleep(500);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,50)", "");
        sleep(500);
        js.executeScript("window.scrollBy(0,50)", "");
        sleep(500);

    }
    @And("open the details and add to favorite")
    public void open_the_details_and_add_to_favorite() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,150)", "");
        sleep(500);
        js.executeScript("window.scrollBy(0,100)", "");
        sleep(500);
        driver.findElement(By.xpath("//*[contains(text(),'Detalii compartimentare')]")).click();
        js.executeScript("window.scrollBy(0,100)", "");
        sleep(1000);
        driver.findElement(By.xpath("//*[contains(text(),'Detalii suprafete')]")).click();
        js.executeScript("window.scrollBy(0,50)", "");
        sleep(500);
        js.executeScript("window.scrollBy(0,100)", "");
        sleep(500);
        js.executeScript("window.scrollBy(0,400)", "");
        sleep(1000);
        js.executeScript("window.scrollTo(0, 10)", "");
        js.executeScript("window.scrollBy(0,100)", "");
        driver.findElement(By.xpath("//*[contains(text(),'Favorit')]")).click();
        //nu stiu de ce se comporta ca si cand nu e logat, deci cand am realizar ca in scenatriul 2 nu mai era
        //am pus in background
        enter_email_and_continue("andreea_rad@icloud.com");
        enter_password_and_continue("Domino123");
        driver.findElement(By.xpath("//button[contains(text(),'Autentificare')]")).click();
        //String url2 = driver.getCurrentUrl();
        //System.out.println(url2);
        driver.findElement(By.xpath("//*[contains(text(),'Favorit')]")).click();
        js.executeScript("window.scrollBy(0,200)", "");
        driver.findElement(By.xpath("//*[@id='favoritesnote']")).sendKeys("Imi place acest apartament.");
        sleep(500);
        js.executeScript("window.scrollBy(0,100)", "");
        driver.findElement(By.xpath("//*[contains(text(),'Adauga nota')]")).click();
        sleep(1000);
        driver.findElement(By.xpath("//*[contains(text(),'Inchide')]")).click();
        sleep(1000);


    }
    @Then("go back and click on another")
    public void go_back_and_click_on_another() throws InterruptedException {
        // driver. navigate(). back();
        // nu mai pot merge inapoi, intrucat au fost paginile in plus cu relogarea
        driver.get("https://www.domino.ro/cautare-detaliata/productcategory/apartamente-vanzari/ultrafilter1/242-596/119-347/68-1106/159-1257");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        sleep(500);
        js.executeScript("window.scrollBy(0,350)", "");
        driver.findElement(By.xpath("//*[@src='/filehandler/ProductFirstFile/500x500/2-camere-mobilat-utilat-parcare-25749-25749.jpg?v=638131028183913145']")).click();
        sleep(1000);
    }
    @Then("get the owners phone numer and report as sold")
    public void get_the_owners_phone_numer_and_report_as_sold() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,120)", "");
        driver.findElement(By.xpath("//*[@id='TelefonProprietar']")).click();
        sleep(500);
        driver.findElement(By.xpath("//*[contains(text(),'Vandut')]")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Anuleaza')]")).click();
        driver. navigate(). back();
    }
    @Then("find another appartemnt and favorite")
    public void find_another_appartemnt_and_favorite() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("go to favorites list")
    public void go_to_favorites_list() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("select favorite appartment")
    public void select_favorite_appartment() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }


}
