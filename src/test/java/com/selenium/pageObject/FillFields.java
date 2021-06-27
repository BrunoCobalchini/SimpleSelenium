package com.selenium.pageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Run here
public class FillFields {

	private final static String LINK = "https://www.grocerycrud.com/demo/bootstrap_theme";
	private static WebDriver driver = new ChromeDriver();

	public static void main(String[] args) throws InterruptedException {

		// Opening browser on the expected URL
		driver = getWinChromeDriver();
		driver.get(LINK);

		// Validating the elements
		WebElement element = driver.findElement(By.id("switch-version-select"));
		element.click();
		element.sendKeys(Keys.DOWN);
		element.sendKeys(Keys.ENTER);

		// Clicking on "add"
		element = driver.findElement(By.xpath("//*[@id=\"gcrud-search-form\"]/div[1]/div[1]/a"));
		element.click();

		// Filling the fields, Name
		element = driver.findElement(By.id("field-customerName"));
		element.sendKeys("Teste Sicredi");

		// Filling the fields, Last name
		element = driver.findElement(By.id("field-contactLastName"));
		element.sendKeys("Teste");

		// Filling the fields, Contact First Name
		element = driver.findElement(By.id("field-contactFirstName"));
		element.sendKeys("seu nome");

		// Filling the fields, Phone
		element = driver.findElement(By.id("field-phone"));
		element.sendKeys("51 9999-9999");

		// Filling the fields, AddressLine1
		element = driver.findElement(By.id("field-addressLine1"));
		element.sendKeys("Av Assis Brasil, 3970");

		// Filling the fields, AddressLine2
		element = driver.findElement(By.id("field-addressLine2"));
		element.sendKeys("Torre D");

		// Filling the fields, City
		element = driver.findElement(By.id("field-city"));
		element.sendKeys("Porto Alegre");

		// Filling the fields, State
		element = driver.findElement(By.id("field-state"));
		element.sendKeys("RS");

		// Filling the fields, PostalCode
		element = driver.findElement(By.id("field-postalCode"));
		element.sendKeys("91000-000");

		// Filling the fields, Country
		element = driver.findElement(By.id("field-country"));
		element.sendKeys("Brasil");

		// Filling the fields, from Employer
		element = driver.findElement(By.xpath("//*[@id=\"field_salesRepEmployeeNumber_chosen\"]/a/div/b"));
		element.click();
		element = driver.findElement(By.xpath("//*[@id=\"field_salesRepEmployeeNumber_chosen\"]/div/div/input"));
		element.click();
		element.sendKeys("Fixter");
		element.sendKeys(Keys.ENTER);
		element.sendKeys(Keys.TAB);

		// Filling the fields, from CreditLimit
		element = driver.findElement(By.id("field-creditLimit"));
		element.sendKeys("200");

		// Clicking on Save
		element = driver.findElement(By.id("form-button-save"));
		element.click();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

		// Asserting a easy text success
		boolean assertTest = driver.getPageSource().contains("report-success");

		if (assertTest == true) {
			System.out.println("The text is present");
		} else {
			System.out.println("The text is not present");
		}

	}

	public static WebDriver getWinChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
		driver.manage().window().maximize();
		return driver;
	}

}