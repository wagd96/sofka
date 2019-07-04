package factory.pages;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class PageGoogle {
    private WebDriver driver;

    @FindBy(xpath = "//input[@name='q']")
    private static WebElement campoBuscar;

    @FindBy(name = "btnK")
    private static WebElement botonBuscar;



    public PageGoogle(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    Function<WebDriver,Boolean> finish  = new Function<WebDriver, Boolean>() {
        public Boolean apply(WebDriver driver) {
            System.out.println("Todavía no he cargado :c");
            return campoBuscar.isDisplayed();
        }
    };

    public void buscarConGoogle(String texto) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .pollingEvery(Duration.ofSeconds(1))
                .withTimeout(Duration.ofSeconds(20))
                .ignoring(NullPointerException.class);
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        WebElement campoBuscar =
        wait.until(finish);
        campoBuscar.click();
        campoBuscar.sendKeys(texto);
//        Thread.sleep(500);
        botonBuscar.click();
    }

    public void esperaExplicita(){

    }

    public WebElement getCampoBuscar() {
        return campoBuscar;
    }
}
