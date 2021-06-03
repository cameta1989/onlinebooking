package Spicejet;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class spiceendtoend {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Asus\\eclipse-workspace\\Introduction\\Webdrivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();    

		driver.get("https://www.spicejet.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	    System.out.println(driver.getTitle());
	    driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_1")).click();
	    // OriginStation
	    driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
	    driver.findElement(By.cssSelector("a[value='DEL']")).click();     
		// Destination
		driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_ddl_destinationStation1_CTXT']")).click();
	    driver.findElement(By.xpath("(//a[@value='HYD'])[2]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date1']")).click();
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1"))
		{
		     System.out.println("its enabled");
		     Assert.assertTrue(true);
		}
		else
		{
		     Assert.assertTrue(false);
		}
		while(!driver.findElement(By.cssSelector("div[class='ui-datepicker-title'] [class='ui-datepicker-month']")).getText().contains("May"))
		{
		// driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']/span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		System.out.println(driver.findElement(By.cssSelector("div[class='ui-datepicker-title'] [class='ui-datepicker-month']")).getText());
		}
		List<WebElement> dates= driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr//td"));
		int count= dates.size();
		for(int i=0; i<count; i++)
		{
		String txt = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr//td")).get(i).getText();
		if(txt.equalsIgnoreCase("28"))
		{
		driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr//td")).get(i).click();
		System.out.println(txt);
		break;
		}
		}
		// Return Date  Selection
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_view_date2']")).click();
		while(!driver.findElement(By.cssSelector("div[class='ui-datepicker-title'] [class='ui-datepicker-month']")).getText().contains("May"))
		{
		// driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']/span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		System.out.println(driver.findElement(By.cssSelector("div[class='ui-datepicker-title'] [class='ui-datepicker-month']")).getText());
		}
		List<WebElement> MDates= driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr//td"));
		int Mcount= dates.size();
		for(int i=0; i<Mcount; i++)
		{
		String txt = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr//td")).get(i).getText();
		if(txt.equalsIgnoreCase("30"))
		{
		driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr//td")).get(i).click();
		System.out.println(txt);
		break;
		}
		}
		// Select Passengers
		Thread.sleep(4000);
	    driver.findElement(By.xpath(".//*[@id='divpaxinfo']")).click();
	    Thread.sleep(4000);
	    WebElement Adults = driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_Adult']"));
	    Select adultsdrp = new Select(Adults);
	    adultsdrp.selectByValue("2");
	    WebElement childs = driver.findElement(By.xpath("//select[@id='ctl00_mainContent_ddl_Child']"));
	    Select childsdrp = new Select(childs);
	    childsdrp.selectByValue("2");
	    driver.findElement(By.xpath(".//*[@id='divpaxinfo']")).click();
	    System.out.println(driver.findElement(By.xpath(".//*[@id='divpaxinfo']")).getText());
	    //Static Currency Dropdown
	    WebElement Currency =  driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
	    Select currencydrp = new Select(Currency);
	    currencydrp.selectByValue("USD");
		Assert.assertEquals(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")).getAttribute("value"), "USD");
		System.out.println(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")).getAttribute("value"));
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']")).click();
	}

}
