package notepad;

import java.io.File;
import java.net.URL;
import java.util.UUID;

import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Notepad {

	CharSequence fileName;

	@Test
	public void notepadOperation() {

		DesktopOptions options = new DesktopOptions();
		options.setApplicationPath("C:\\WINDOWS\\system32\\notepad.exe");
		try {
			WiniumDriver driver = new WiniumDriver(new URL("http://localhost:9999"), options);
			driver.findElementByClassName("Edit").sendKeys("This is sample test");
			driver.findElementById("Close").click();
			driver.findElementByName("Save").click();
			fileName = UUID.randomUUID().toString().substring(0, 6) + ".txt";
			driver.findElementById("1001").sendKeys(fileName);
			driver.findElementByName("Save").click();
			driver.close();
			Assert.assertTrue(assertFileName(), "File does not exists");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public boolean assertFileName() {
		File expName = new File(System.getProperty("user.home") + "/Desktop/" + fileName);
		if (expName.exists())
			return true;
		else
			return false;
	}
}