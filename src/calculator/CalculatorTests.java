package calculator;
import java.net.URL;
import java.net.MalformedURLException;
import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
public class CalculatorTests {
    private WiniumDriver app = null;
    private DesktopOptions options;
    private String CALC_PATH = "C:\\Windows\\System32\\calc.exe";
    private String WINIUM_PATH = "http://localhost:9999";
    Calculator calc;

    @Before
    public void startCalculator() throws MalformedURLException {
        options = new DesktopOptions();
        options.setApplicationPath(CALC_PATH);
        app = new WiniumDriver(new URL(WINIUM_PATH), options);
        calc = new Calculator(app);
    }

    @Test
    public void add() {
        assertThat(calc.add(7, 5), is(12));
    }

    @Test
    public void subtract() {
        assertThat(calc.subtract(7, 5), is(2));
    }

    @Test
    public void multiply() {
        assertThat(calc.multiply(7, 5), is(35));
    }

    @Test
    public void divide() {
        assertThat(calc.divide(7, 5), is(1));
    }
}