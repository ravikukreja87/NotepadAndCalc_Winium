package calculator;
import org.openqa.selenium.By;
import org.openqa.selenium.winium.WiniumDriver;
public class Calculator {
	private WiniumDriver app;
	public Calculator(WiniumDriver app) {
		this.app = app;
	}
	protected int add(int firstNumber, int secondNumber) {
		return compute("Plus", firstNumber, secondNumber);
	}
	protected int subtract(int firstNumber, int secondNumber) {
		return compute("Minus", firstNumber, secondNumber);
	}
	protected int multiply(int firstNumber, int secondNumber) {
		return compute("Multiply by", firstNumber, secondNumber);
	}
	protected int divide(int firstNumber, int secondNumber) {
		return compute("Divide by", firstNumber, secondNumber);
	}
	private int compute(String type, int firstNumber, int secondNumber) {
		app.findElementByName(convert(firstNumber)).click();
		app.findElementByName(type).click();
		app.findElementByName(convert(secondNumber)).click();
		app.findElementByName("Equals").click();
		String results1 = app.findElementById("CalculatorResults").getAttribute("Name");
		Double result = Double.parseDouble(results1.substring(11).trim());
		app.findElement(By.id("Close")).click();
		return result.intValue();
	}
	private static final String[] numNames = { "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
			"Nine" };
	public String convert(int number) {
		return numNames[number];
	}
}