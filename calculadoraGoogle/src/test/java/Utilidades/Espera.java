package Utilidades;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Espera {

    WebDriver driver;

    public Espera(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement esperarElementoEsperaExplicita(By locator, int tiempo){
        WebElement webElement = null;

        try{
            WebDriverWait espera = new WebDriverWait(driver, tiempo);
            webElement = espera.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println(String.format("Error: %s",e));
        }

        return webElement;
    }

    public WebElement esperarElementoEsperaFluida(By locator, int frecuencia, int tiempo){
        WebElement webElement = null;

        try{
            Wait<WebDriver> espera = new FluentWait<>(driver)
                    .pollingEvery(Duration.ofSeconds(frecuencia))
                    .withTimeout(Duration.ofSeconds(tiempo))
                    .ignoring(NoSuchElementException.class);

            webElement = espera.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception e) {
            System.out.println(String.format("Error: %s",e));
        }

        return webElement;
    }
}
