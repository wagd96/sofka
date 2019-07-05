import Utilidades.Utilidades;
import factory.DriverFactory;
import factory.pages.PageCalculadora;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.opentest4j.AssertionFailedError;

public class TestCalculadora {

    WebDriver driver;
    PageCalculadora pageCalculadora;
    Utilidades utilidad;
    private static final Logger log = LogManager.getLogger(TestCalculadora.class.getName());


    @BeforeEach
    public void setup() {
//        log = Logger.getLogger(TestCalculadora.class);
        log.info("Inicia la prueba");

        driver = DriverFactory.getDriver("chrome", false, false, false, true);
        driver.navigate().to("https://www.google.com/search?rlz=1C1CHBD_esCO853CO853&ei=a9ITXaihIM6K5wLcrrWoAw&q=calculadora+google&oq=calculadora+google&gs_l=psy-ab.3..0l10.852867.859275..859728...1.0..1.472.3302.0j18j4-1......0....1..gws-wiz.......0i71j0i67j0i131j35i39.L0XLFK2cdIg");

        pageCalculadora = new PageCalculadora(driver);
        utilidad = new Utilidades();
    }

    @RepeatedTest(20)
    public void testOperaciones() {
        double numeroUno, numeroDos, resultado;
        String operacion;

        operacion = Double.toString(utilidad.decimalAleatorio(1, 4, 0));
        numeroUno = utilidad.decimalAleatorio(5, 56.98501, 5);
        numeroDos = utilidad.decimalAleatorio(3, 4);

        resultado = pageCalculadora.operacionEnCalculadora(numeroUno, numeroDos, operacion);

        try {
            Assertions.assertEquals(Double.parseDouble(pageCalculadora.getResultado().getText()), resultado, 0.0001);
            log.info(String.format("Prueba exitosa. %s %s %s = %s", numeroUno, pageCalculadora.getOperacion(operacion), numeroDos, resultado));
        } catch (AssertionFailedError failedError) {
            log.warn(String.format("El test falló. Error: %s", failedError.getMessage()));
            Assertions.fail();
        }
    }

    @AfterEach
    public void close() {
        log.info("Termina la prueba\n");
        driver.quit();
    }
}
