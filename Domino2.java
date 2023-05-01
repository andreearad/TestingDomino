package stepsDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import static java.lang.System.out;
import static java.lang.Thread.sleep;

public class Domino2 {
        private WebDriver driver;
        @Before
        public void setup(){
            System.setProperty("webdriver.chrome.driver",
                    System.getProperty("user.dir") +"/src/main/java/driver/chromedriver.exe");
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
        }
        @After
        public void tearDown(){
            driver.quit();
        }

    @Given("deschide site-ul Domino")
    public void deschide_site_ul_Domino() throws InterruptedException {
        driver.get("https://www.domino.ro/");
        sleep(2000);
    }

    @And("aceepta cookies si acceseaza autentificarea")
    public void aceepta_cookies_si_acceseaza_autentificarea() throws InterruptedException {
        driver.findElement(By.xpath("//*[@aria-label='dismiss cookie message']")).click();
        sleep(1000);
        driver.findElement(By.xpath("//*[@src='/images/specific/user1.svg']")).click();
    }

    @Then("introduce email {string}")
    public void introduce_email(String em) {
        driver.findElement(By.xpath("//*[@id='Email']")).sendKeys(em);
        driver.findElement(By.xpath("//*[contains(text(),'Continua')]")).click();
    }

    @Then("introduce parola {string}")
    public void introduce_parola(String ps) {
        driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(ps);
        driver.findElement(By.xpath("//button[contains(text(),'Autentificare')]")).click();
    }


// ------------ SCENARIUL I ----------------

    @Given("cauta apartamente")
    public void cauta_apartamente() throws InterruptedException {
        driver.findElement(By.xpath("//*[@class='level1']")).click();
        sleep(500);
        driver.findElement(By.xpath("//*[@class='glyphicon glyphicon-search']")).click();
    }

    @Then("categorie filtrare {string}")
    public void categorie_filtrare(String lc) throws InterruptedException {
        for (WebElement i : driver.findElements(By.xpath("//*[contains(@class,'ParentTitle')]/div"))){
            if (i.getText().toLowerCase().equalsIgnoreCase(lc)){
                i.click();
            }
        }
    }

    @Then("selectie filtru {string}")
    public void selectie_filtru(String lct) throws InterruptedException {
        for (WebElement i : driver.findElements(By.xpath("//*[contains(@class,'FilterToogle')]"))){
            if (i.getText().toLowerCase().equalsIgnoreCase(lct)){
                i.click();
            }
        }
    }

    @Then("filtreaza dupa {string}") //partea asta nu merge
    public void filtreaza_dupa(String clj) throws InterruptedException {
        for (WebElement i : driver.findElements(By.xpath("//*[contains(@class,'atributes-row')]/div"))){
            if (i.getText().toLowerCase().equalsIgnoreCase(clj)){
                i.findElement(By.xpath("./../div")).click();
            }
        }
    }

    @Then("show result")
    public void show_result() throws InterruptedException {
        driver.findElement(By.xpath("//*[@class='btn btn-black fix-bottom btn-hide']")).click();
        sleep(1000);
        String url = driver.getCurrentUrl();
        out.println(url);
    }

// ------------ SCENARIUL II ----------------

    @Given("salveaza cautarea")
    public void salveaza_cautarea() throws InterruptedException {
        driver.get("https://www.domino.ro/cautare-detaliata/productcategory/apartamente-vanzari/ultrafilter1/242-596/119-347/68-1106/159-1257");
        sleep(2000);
        driver.findElement(By.xpath("//*[contains(text(),'Salveaza Cautarea')]")).click();
        sleep(1000);
        driver.findElement(By.id("requestnote")).sendKeys("Ma intereseaza aceste criterii de cautare.");
        driver.findElement(By.xpath("//*[contains(text(),'Cauta in continuare')]")).click();
        sleep(500);
    }
    @Given("selecteaza apartamentul")
    public void selecteaza_apartamentul() throws InterruptedException {
        // get url; momentan nu merg pasii deci nu am cum
        // voi revenii
        //driver.get("https://www.domino.ro/cautare-detaliata/productcategory/apartamente-vanzari/ultrafilter1/242-596/119-347/68-1106/159-1257");
        //sleep(2000);
        //driver.findElement(By.xpath("//*[@aria-label='dismiss cookie message']")).click();
        // incercare 1  WebElement element = driver.findElement(By.xpath("//*[@src='/filehandler/ProductFirstFile/500x500/3-camere-mobilat-utilat-parcare-25750-25750.jpg?v=638131040738246261']")); element.sendKeys(Keys.DOWN);
        // incerrcare 2  WebElement element = driver.findElement(By.xpath("//*[@src='/filehandler/ProductFirstFile/500x500/3-camere-mobilat-utilat-parcare-25750-25750.jpg?v=638131040738246261']"));
        // ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        /*incercarea 3  WebElement element = driver.findElement(By.xpath("//*[@src='/filehandler/ProductFirstFile/500x500/3-camere-mobilat-utilat-parcare-25750-25750.jpg?v=638131040738246261']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        actions.click();
        sleep(500); */
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,150)", "");
        //driver.findElement(By.xpath("//*[@id=['DivArroundFrontProductCategoryController']]/div[1]/div[1]/a/img")).click();
        //driver.findElement(By.xpath("//*[@src=['/filehandler/ProductFirstFile/500x500/3-camere-etaj-intermediar-parcare-22907-22907.jpg?v=638174955837450740']")).click();
        driver.findElement(By.xpath("//*[@src='/filehandler/ProductFirstFile/500x500/3-camere-mobilat-utilat-parcare-25750-25750.jpg?v=638131040738246261']")).click();
        sleep(1000);
    }

    @Given("afiseaza detalii si adauga la favorite")
    public void afiseaza_detalii_si_adauga_la_favorite() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,50)", "");
        sleep(500);
        js.executeScript("window.scrollBy(0,50)", "");
        sleep(500);
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
        sleep(1000);
        js.executeScript("window.scrollBy(0,200)", "");
        driver.findElement(By.xpath("//*[@id='favoritesnote']")).sendKeys("Imi place acest apartament, de tinut minte.");
        sleep(1000);
        js.executeScript("window.scrollBy(0,90)", "");
        driver.findElement(By.xpath("//*[contains(text(),'Adauga nota')]")).click();
        sleep(1000);
        driver.findElement(By.xpath("//*[contains(text(),'Inchide')]")).click();
        sleep(1000);
    }
    @Then("alege alt apartament si ascunde")
    public void alege_alt_apartament_si_ascunde() throws InterruptedException {
        driver. navigate(). back();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        sleep(500);
        js.executeScript("window.scrollBy(0,450)", "");
        driver.findElement(By.xpath("//*[@src='/filehandler/ProductFirstFile/500x500/2-camere-mobilat-utilat-parcare-25749-25749.jpg?v=638131028183913145']")).click();
        sleep(1000);
        driver.findElement(By.id("xzoom-fancy")).click();
        sleep(1200);
        js.executeScript("window.scrollBy(0,100)", "");
        sleep(500);
        driver.findElement(By.xpath("//*[@title='Close']")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Ascunde')]")).click();
        sleep(1000);
        js.executeScript("window.scrollBy(0,100)", "");
        sleep(1000);
        driver.findElement(By.xpath("//*[contains(text(),'Inchide')]")).click();
        driver. navigate(). back();
    }

    @Then("ia legatura si proprietarul si raporteaza pret gresit")
    public void ia_legatura_si_proprietarul_si_raporteaza_pret_gresit() throws InterruptedException {
        driver.findElement(By.xpath("//*[@src='/filehandler/ProductFirstFile/500x500/3-camere-mobilat-utilat-parcare-23801-23801.jpg?v=638030060490990543']")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,120)", "");
        driver.findElement(By.xpath("//*[@id='TelefonProprietar']")).click();
        sleep(1000);
        driver.findElement(By.xpath("//*[contains(text(),'Pret Gresit')]")).click();
        sleep(1200);
        //driver.findElement(By.xpath("//*[contains(text(),'Anuleaza')]")).click();
        //xpath 2 rezultate
        driver.findElement(By.xpath("//*[@id='AlertWrongPrice']/button[2]")).click();
        sleep(1200);
        driver. navigate(). back();
        sleep(1200);
    }

    @Then("raporteaza vandut si ascunde")
    public void raporteaza_vandut_si_ascunde() throws InterruptedException {
        driver.findElement(By.xpath("//*[@src='/filehandler/ProductFirstFile/500x500/2-camere-decomandat-parcare-boxa-14062-14062.jpg?v=638023922018656610']")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,120)", "");
        driver.findElement(By.xpath("//*[contains(text(),'Vandut')]")).click();
        sleep(1200);
        driver.findElement(By.xpath("//*[contains(text(),'Anuleaza')]")).click();
        sleep(1200);
        driver.findElement(By.xpath("//*[contains(text(),'Ascunde')]")).click();
        sleep(1200);
        js.executeScript("window.scrollBy(0,100)", "");
        sleep(1200);
        driver.findElement(By.id("hiddensnote")).sendKeys("Stiu ca este vandut.");
        sleep(600);
        driver.findElement(By.xpath("//*[contains(text(),'Inchide')]")).click();
        driver. navigate(). back();
    }

    @Then("sorteaza crescator anunturile")
    public void sorteaza_crescator_anunturile() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        js.executeScript("window.scrollBy(0,-5000)", "");
        driver.findElement(By.id("SortBy2")).click();
        sleep(800);
        driver.findElement(By.xpath("//*[contains(text(),'Pret Crescator')]")).click();
        sleep(800);
    }

    @Then("alege si adauga la favorite")
    public void alege_si_adauga_la_favorite() throws InterruptedException {
        driver.findElement(By.xpath("//*[@src='/filehandler/ProductFirstFile/500x500/2-camere-mobilat-utilat-parcare-20239-20239.jpg?v=637895235739348699']")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,120)", "");
        sleep(500);
        driver.findElement(By.id("xzoom-fancy")).click();
        sleep(600);
        js.executeScript("window.scrollBy(0,100)", "");
        sleep(600);
        driver.findElement(By.xpath("//*[@title='Close']")).click();
        sleep(500);
        //*[@title='Close']//driver.findElement(By.xpath("//*[@id='fancybox-container-2']/div[3]/div/a[2]")).click();
        //sleep(600);
        //driver.findElement(By.xpath("//*[@id='fancybox-container-2']/div[3]/div/a[7]")).click();
        //sleep(600);
        //driver.findElement(By.xpath("//*[@id='fancybox-container-2']/div[2]/div[2]/button[4]/svg")).click();
        driver.findElement(By.xpath("//*[contains(text(),'Favorit')]")).click();
        sleep(1000);
        js.executeScript("window.scrollBy(0,200)", "");
        driver.findElement(By.xpath("//*[@id='favoritesnote']")).sendKeys("Doresc sa fac o oferta!");
        sleep(1000);
        js.executeScript("window.scrollBy(0,90)", "");
        driver.findElement(By.xpath("//*[contains(text(),'Adauga nota')]")).click();
        sleep(1000);
        driver.findElement(By.xpath("//*[contains(text(),'Inchide')]")).click();
        sleep(1000);
    }


// ------------ SCENARIUL III ----------------

    @Given("acceseaza contul meu")
    public void acceseaza_contul_meu() throws InterruptedException {
        // getter de la finalul background-ului
        // driver.get("https://www.domino.ro/vanzari/apartamente-vanzari/2-camere-mobilat-utilat-parcare-20239");
        driver.findElement(By.xpath("//*[contains(text(),'Oferte salvate')]")).click();
        sleep(1000);
        throw new io.cucumber.java.PendingException();
    }
    @Given("sterge anunturile ascunse")
    public void sterge_anunturile_ascunse() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='Hiddens']")).click();
        // id-ul pentru a sterge un anunt, se incrementeaza de cate ori este adaugat in lista
        //cred ca este numarul de cate ori a fost adaugat la favorite
        sleep(1000);
        //driver.findElement(By.xpath("//*[contains(text(),'Sterge')]")).click();
        driver.findElement(By.xpath("//*[@id='714']")).click();
        driver.switchTo().alert().accept();
        out.println("Waiting for 1 sec..");
        sleep(1_000);
        sleep(1000);
        driver.findElement(By.xpath("//*[@id='715']")).click();
        driver.switchTo().alert().accept();
        out.println("Waiting for 1 sec..");
        sleep(1_000);
        // driver. navigate(). back();
    }
    @Then("sterge cautarea")
    public void sterge_cautarea() throws InterruptedException {
        driver.findElement(By.id("Requests")).click();
        //de verificat ca e ok
        sleep(1000);
        driver.findElement(By.xpath("//*[contains(text(),'Sterge')]")).click();
        sleep(1000);
        driver. navigate(). back();
    }
    @Then("sterge anunutul favorit")
    public void sterge_anunutul_favorit() throws InterruptedException {
        driver.findElement(By.xpath("//*[contains(text(),'Favorite')]")).click();
        sleep(1000);
        //driver.findElement(By.xpath("//*[contains(text(),'Sterge')]")).click();
        //sleep(1000);
        driver.findElement(By.xpath("//*[@id='5810']")).click();
        driver.switchTo().alert().accept();
        out.println("Waiting for 1 sec..");
        sleep(1_000);
        sleep(1000);
        //driver. navigate(). back();
        //de modificat, id se incrementeaza
    }
    @Then("ia legatura cu vanzatorul si raporteaza vandut")
    public void ia_legatura_cu_vanzatorul_si_raporteaza_vandut() throws InterruptedException {
        driver.findElement(By.xpath("src='/filehandler/ProductFirstFile/500x500/2-camere-mobilat-utilat-parcare-20239-20239.jpg?v=637895235739348699'")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,120)", "");
        driver.findElement(By.xpath("//*[@id='TelefonProprietar']")).click();
        sleep(1000);
        driver.findElement(By.xpath("//*[contains(text(),'Vandut')]")).click();
        sleep(1200);
        driver.findElement(By.xpath("//*[contains(text(),'Anuleaza')]")).click();
        sleep(1200);
    }



}
