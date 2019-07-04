package factory.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.*;

public class PageCalculadora {
    private WebDriver driver;

    @FindBy(xpath = "//div[@class='XRsWPe AOvabd']")
//    @FindBys(@FindBy(className = "AOvabd" ))
    private static List<WebElement> botonesNumeros;

    @FindBy(xpath = "//div[@class='XRsWPe MEdqYd']")
    private static List<WebElement> botonesOperaciones;

    @FindBy(xpath = "//div[@class='XRsWPe UUhRt']")
    private static WebElement botonIgual;

    @FindBy(xpath = "//div[@class='z7BZJb XSNERd']")
    private static WebElement campoResultado;

    public PageCalculadora(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement elemento){
        elemento.click();
    }

    public WebElement numeroEnWebElement(String numero){
        List<WebElement> numeros = getNumeros();
        WebElement numeroEnWebElement;
        switch (numero){
            case "0":
                numeroEnWebElement = numeros.get(9);
                break;
            case "1":
                numeroEnWebElement = numeros.get(6);
                break;
            case "2":
                numeroEnWebElement = numeros.get(7);
                break;
            case "3":
                numeroEnWebElement = numeros.get(8);
                break;
            case "4":
                numeroEnWebElement = numeros.get(3);
                break;
            case "5":
                numeroEnWebElement = numeros.get(4);
                break;
            case "6":
                numeroEnWebElement = numeros.get(5);
                break;
            case "7":
                numeroEnWebElement = numeros.get(0);
                break;
            case "8":
                numeroEnWebElement = numeros.get(1);
                break;
            case "9":
                numeroEnWebElement = numeros.get(2);
                break;
            case ".":
                numeroEnWebElement = numeros.get(10);
                break;
            default:
                numeroEnWebElement = null;
                break;
        }
        return numeroEnWebElement;
    }

    private void ingresarNumero(double num){
        String numero = Double.toString(num);
        for (int i = 0; i < numero.length(); i++) {
            numeroEnWebElement(Character.toString(numero.charAt(i))).click();
        }
    }

    private double dividirNumeros(double numeroUno, double numeroDos){
        ingresarNumero(numeroUno);
        getOperaciones().get(9).click();
        ingresarNumero(numeroDos);
        botonIgual.click();
        return (numeroUno / numeroDos);
    }

    private double multiplicarNumeros(double numeroUno, double numeroDos){
        ingresarNumero(numeroUno);
        getOperaciones().get(10).click();
        ingresarNumero(numeroDos);
        botonIgual.click();
        return (numeroUno * numeroDos);
    }

    private double restarNumeros(double numeroUno, double numeroDos){
        ingresarNumero(numeroUno);
        getOperaciones().get(11).click();
        ingresarNumero(numeroDos);
        botonIgual.click();
        return (numeroUno - numeroDos);
    }

    private double sumarNumeros(double numeroUno, double numeroDos){
        ingresarNumero(numeroUno);
        getOperaciones().get(12).click();
        ingresarNumero(numeroDos);
        botonIgual.click();
        return (numeroUno + numeroDos);
    }

    public double operacionEnCalculadora(double numeroUno, double numeroDos, String operacion){
        double resultado;
        switch (operacion){
            case "1.0":
                resultado = sumarNumeros(numeroUno,numeroDos);
                break;
            case "2.0":
                resultado = restarNumeros(numeroUno,numeroDos);
                break;
            case "3.0":
                resultado = multiplicarNumeros(numeroUno,numeroDos);
                break;
            case "4.0":
                resultado = dividirNumeros(numeroUno,numeroDos);
                break;
            default:
                resultado = 0;
                break;
        }
        return resultado;
    }

    public String getOperacion(String operacion){
        String retorno = "";
        switch(operacion){
            case "1.0":
                retorno = "+";
                break;
            case "2.0":
                retorno = "-";
                break;
            case "3.0":
                retorno = "*";
                break;
            case "4.0":
                retorno = "/";
                break;
        }
        return retorno;
    }

    public List<WebElement> getNumeros() {
        return botonesNumeros;
    }

    public List<WebElement> getOperaciones() {
        return botonesOperaciones;
    }

    public WebElement getResultado() {
        return campoResultado;
    }
}
