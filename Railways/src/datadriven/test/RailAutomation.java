package datadriven.test;

	import java.io.File;
	import java.util.ArrayList;
	import java.util.Iterator;
	import java.util.concurrent.TimeUnit;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.Alert;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.service.DriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;

	import utility.TrainUtil;


	public class RailAutomation {
		
		 public static WebDriver driver;
		
		@BeforeMethod
		public void setup() {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\user1\\Downloads\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			
			driver.get("http://hectronicafms.com/lfms/index.php");
			driver.findElement(By.id("name")).sendKeys("superadmin");
			driver.findElement(By.id("contact")).sendKeys("superadmin12");
			driver.findElement(By.name("login")).click();
			
			
			
			
			
		}
		 



		@DataProvider
		public static Iterator<Object[]> gettraindata() {
			ArrayList<Object[]>Traindata = TrainUtil.getDataFromExcel1();
			return Traindata.iterator();
		}
		
		@Test(priority =1, dataProvider="gettraindata")
		
		
		public void railadd(String Date, String storagetank, String flowmeter, String shift, String fromtime, String tilltime, String shiftmanager, String operator, String atg, String locono, String locoshed, String fuelpoint, String trainno, String traintype, String locopilotid, String locopilotname, String Inward, String Preset, String Fuelstarttime, String Fuelendtime, String Qtyissued, String OpenReading, String CloseReading, String TransactionDate, String VegaT) throws Exception 
		{
			
			driver.findElement(By.xpath("//a[@href='../fueldelivery/index.php']")).click();
			driver.findElement(By.xpath("//html//div[@id='employee_table']/input[1]")).click();
			
			driver.findElement(By.xpath("//input[@id='date']")).sendKeys(Date);
			
			
			WebElement listbox = driver.findElement(By.id("storage_tank"));
			if (storagetank!=null)
			{
			String str = storagetank.substring(0, 1);
			Select s=new Select(listbox);
			s.selectByValue(str);
			}
			
			driver.findElement(By.id("flow_meter")).clear();
			if(flowmeter!=null)
			{	
				String flo= flowmeter.substring(0, 1);
				driver.findElement(By.id("flow_meter")).sendKeys(flo);	
			}
			
			
			WebElement listbox1 = driver.findElement(By.id("select_shift"));
			if(shift!=null)
			{	
				String shi = shift.substring(0, 1);
				Select se=new Select(listbox1);
				se.selectByValue(shi);
			}
			
			
			
			driver.findElement(By.id("from_time")).sendKeys(fromtime);
			
			
			driver.findElement(By.id("till_time")).sendKeys(tilltime);
			
			driver.findElement(By.id("shift_manager")).clear();
			driver.findElement(By.id("shift_manager")).sendKeys(shiftmanager);
			
			driver.findElement(By.id("operator_name")).clear();
			driver.findElement(By.id("operator_name")).sendKeys(operator);
			
			driver.findElement(By.id("atg_start_reading")).clear();
			if(atg!=null)
			{
				String atg1 = atg.replaceAll("[^0-9]", "");
				
				driver.findElement(By.id("atg_start_reading")).sendKeys(atg1);	
			}
			
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,400)");
			
			driver.findElement(By.id("loco_no")).clear();
			if(locono!=null)
			{
				String loco = locono.replaceAll("[^0-9]", "");
				driver.findElement(By.id("loco_no")).sendKeys(loco);	
		
			}
			
			
			driver.findElement(By.id("loco_shed")).clear();
			driver.findElement(By.id("loco_shed")).sendKeys(locoshed);
			
			WebElement listbox2 = driver.findElement(By.id("fuel_point"));
			if(fuelpoint!=null)
			{
				String fuel = fuelpoint.substring(0, 1);
				Select list=new Select(listbox2);
				list.selectByValue(fuel);	
				
			}
			
			
			driver.findElement(By.id("train_no")).clear();
			if(trainno!=null)
			{
				String train = trainno.replaceAll("[^0-9]", "");
				driver.findElement(By.id("train_no")).sendKeys(train);	
			}
			
			//Thread.sleep(2000);
			WebElement listbox3 = driver.findElement(By.id("train_type"));
			Select list3=new Select(listbox3);
			list3.selectByVisibleText(traintype);
			
			driver.findElement(By.id("loco_pilot_id_no")).clear();
			driver.findElement(By.id("loco_pilot_id_no")).sendKeys(locopilotid);
			
			driver.findElement(By.id("loco_pilot_name")).clear();
			driver.findElement(By.id("loco_pilot_name")).sendKeys(locopilotname);
			
			driver.findElement(By.id("inward_balance")).clear();
			if(Inward!=null)
			{
				String balance = Inward.replaceAll("[^0-9]","");
				driver.findElement(By.id("inward_balance")).sendKeys(balance);	
			}
			
			
			driver.findElement(By.id("preset")).clear();
			if(Preset!=null)
			{
				String pre = Preset.replaceAll("[^0-9]", "");
				driver.findElement(By.id("preset")).sendKeys(pre);	
			}
			
			
			
			driver.findElement(By.id("fuelling_start_time")).sendKeys(Fuelstarttime);
			
			
			driver.findElement(By.id("fuelling_stop_time")).sendKeys(Fuelendtime);
			
			driver.findElement(By.id("quantity_issued")).clear();
			if(Qtyissued!=null)
			{
				
				String qty = Qtyissued.substring(0, 4);
				driver.findElement(By.id("quantity_issued")).sendKeys(qty);	
			}
			
			
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,400)");
			
			Thread.sleep(2000);
			driver.findElement(By.id("opening_reading")).clear();
			if(OpenReading!=null)
			{
				
				String reading = OpenReading.replaceAll("[^0-9]", "");
				driver.findElement(By.id("opening_reading")).sendKeys(reading);	
			}
			
			
			driver.findElement(By.id("closing_reading")).clear();
			if(CloseReading!=null)
			{
				String close = CloseReading.replaceAll("[^0-9]", "");
				driver.findElement(By.id("closing_reading")).sendKeys(close);	
			}
			
			
			
			driver.findElement(By.id("transaction_date")).sendKeys(TransactionDate);
			
			driver.findElement(By.id("vegat_srno")).clear();
			driver.findElement(By.id("vegat_srno")).sendKeys(VegaT);
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//input[@id='button_action']")).click();
			
			Thread.sleep(2000);
			Alert alert = driver.switchTo().alert();
			alert.accept();
			}

		@Test(priority = 2)
		public static void shift()
		{
			
			
			driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
			
			
		}
		
		

	@Test(priority =3)
	public static void shiftadd() throws Exception
	{
		
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		driver.findElement(By.xpath("//html//div[@id='employee_table']/input[1]")).click();
		
		WebElement listbox = driver.findElement(By.id("select_shift"));
		Select list=new Select(listbox);
		list.selectByValue("1");
		
		driver.findElement(By.xpath("//input[@id='button_action']")).click();
		
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	@Test(priority = 4)
	public static void shiftview() throws Exception
	{
		
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		driver.findElement(By.xpath("//tr//td[7]//button[1]")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@type='button'][contains(text(),'Close')]")).click();
	}

	@Test(priority = 5)
	public static void shiftdel() throws Exception
	{
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		driver.findElement(By.xpath("//tr//td[9]//button[1]")).click();
		
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		Thread.sleep(2000);
		
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
	}

	@Test (priority = 6)
	public static void configuration() throws Exception
	{
		mousehover();
		
	}

	@Test(priority = 7)
	public static void flowmeter() throws Exception
	{
		mousehover();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@href='../flowmeter/index.php']")).click();
		Thread.sleep(2000);
		
	}

	@Test (priority = 8)
	public static void flowmeterconfiguration() throws Exception
	{
		
		mousehover();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@href='../flowmeter/index.php']")).click();
		
		driver.findElement(By.xpath("//input[@value='ADD']")).click();
		
		driver.findElement(By.id("flow_meter_no")).sendKeys("1");
		
		driver.findElement(By.id("flow_meter_sr_no")).sendKeys("VT-1909");
		
		driver.findElement(By.id("flow_meter_make")).sendKeys("ISOL");
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,400)");
		
		//driver.findElement(By.xpath("//input[@id='button_action']")).click();
		
		driver.findElement(By.id("button_action")).click();
		
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
	}

	@Test(priority = 9)
	public static void flowmeterview() throws Exception
	{
		mousehover();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='../flowmeter/index.php']")).click();
		
		driver.findElement(By.xpath("//html//td[5]/button[1]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@type='button'][contains(text(),'Close')]")).click();
		
	}

	@Test(priority = 10)
	public static void flowmeterdel() throws Exception
	{
		mousehover();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@href='../flowmeter/index.php']")).click();
		
		driver.findElement(By.xpath("//html//td[7]/button[1]")).click();
		
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		Thread.sleep(2000);
		
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		
	}
	@Test (priority = 11)
	public static void configurationshift() throws Exception
	{
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		Thread.sleep(2000);
		
		
		
		WebElement element = driver.findElement(By.xpath("//html//li[2]/ul[1]/li[2]"));
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
		Thread.sleep(5000);
		
	}


	@Test (priority = 12)
	public static void configshiftfaddfun() throws Exception
	{
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		Thread.sleep(3000);
		
		WebElement element = driver.findElement(By.xpath("//a[@href='../shift/index.php']"));
		Actions action = new Actions(driver);
		action.moveToElement(element).click().perform();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//html//div[@id='employee_table']/input[1]")).click();
		
		
		
		driver.findElement(By.id("no_of_shift")).sendKeys("1");
		
		
		
		driver.findElement(By.id("from_time")).sendKeys("11:12:13 AM");
		driver.findElement(By.id("till_time")).sendKeys("11:21:31 PM");
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,400)");
		
		driver.findElement(By.id("button_action")).click();
		
		/* WebElement element1 = driver.findElement(By.id("button_action"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(element1).click().perform(); */
		
		
		
		Thread.sleep(4000);
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	@Test(priority = 13)
	public static void Configurationshiftview() throws Exception
	{
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@href='../shift/index.php']")).click();
		
		driver.findElement(By.xpath("//html//td[5]/button[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(text(),'Close')]")).click();
		
	}

	@Test (priority = 14)
	public static void configshiftdelfun()throws Exception
	{
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@href='../shift/index.php']")).click();
		
		
		driver.findElement(By.xpath("//html//td[7]/button[1]")).click();
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		Thread.sleep(4000);
		
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		
	}

	@Test (priority = 15)
	public static void configurationregionfun() throws Exception
	{
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		
		mousehover();
		driver.findElement(By.xpath("//a[@href='../region/index.php']")).click();	
		
		
	}

	@Test(priority = 16)
	public static void regionadd() throws Exception
	{

		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		
		mousehover();
		driver.findElement(By.xpath("//a[@href='../region/index.php']")).click();
		
		driver.findElement(By.xpath("//html//div[@id='employee_table']/input[1]")).click();
		
		driver.findElement(By.xpath("//input[@id='region_name']")).sendKeys("BLR");
		
		driver.findElement(By.xpath("//input[@id='button_action']")).click();
		
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
	}

	@Test(priority = 17)
	public static void regionviewfun() throws Exception
	{
		
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		
		mousehover();
		driver.findElement(By.xpath("//a[@href='../region/index.php']")).click();
		
		driver.findElement(By.xpath("//html//tr[2]/td[3]/button[1]")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@type='button'][contains(text(),'Close')]")).click();
		
	}

	@Test (priority = 18)
	public static void regiondelfun() throws Exception
	{
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		
		mousehover();
		driver.findElement(By.xpath("//a[@href='../region/index.php']")).click();
		
		driver.findElement(By.xpath("//html//tr[2]/td[5]/button[1]")).click();
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		Thread.sleep(2000);
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();

	}

	@Test(priority = 19)
	public static void shedfun() throws Exception
	{
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Add Shed')]")).click();
		Thread.sleep(2000);
		
	}

	@Test(priority = 20)
	public static void shedaddfun() throws Exception
	{
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		
		driver.findElement(By.xpath("//a[@href='../shed/index.php']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@value='ADD']")).click();
		driver.findElement(By.xpath("//input[@id='shed_name']")).sendKeys("PNQ");
		
		WebElement listbox = driver.findElement(By.id("region_name"));
		Select list=new Select(listbox);
		list.selectByVisibleText("BLR");
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("button_action")).click();
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
	}

	@Test(priority = 21)
	public static void shedview() throws Exception
	{
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Add Shed')]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//tbody//tr[2]//td[4]//button[1]")).click();
		
		Thread.sleep(2000);
		
		
		driver.findElement(By.xpath("//button[@type='button'][contains(text(),'Close')]")).click();
		
		
	}

	@Test(priority = 22)
	public static void sheddel() throws Exception
	{
		
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Add Shed')]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//tbody//tr[2]//td[6]//button[1]")).click();
		
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		Thread.sleep(4000);
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		
	}

	@Test(priority = 23)
	public static void shiftmanagerfun() throws Exception
	{
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@href='../shift_manager/index.php']")).click();
		Thread.sleep(2000);
		
	}

	@Test(priority = 24)
	public static void shiftmanageradd() throws Exception
	{
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@href='../shift_manager/index.php']")).click();
		
		driver.findElement(By.xpath("//input[@value='ADD']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='shift_manager_name']")).sendKeys("Darshan");
		driver.findElement(By.id("employee_id")).sendKeys("Dars1234");
		
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,200)");
		
		WebElement listbox = driver.findElement(By.id("loco_shed"));
		Select list = new Select(listbox);
		list.selectByVisibleText("PNQ");
		

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,400)");
		
		driver.findElement(By.id("button_action")).click();
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	@Test(priority = 25 )
	public static void shiftmanagerviewfun() throws Exception
	{
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Shift Manager')]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//tr//td[5]//button[1]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[contains(text(),'Close')]")).click();
	}

	@Test(priority = 26)
	public static void shiftmanagerdelfun() throws Exception
	{
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Shift Manager')]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//tr//td[7]//button[1]")).click();
		
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(2000);
		
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		
	}


	@Test(priority = 27)
	public static void operatorfun() throws Exception
	{
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		
		driver.findElement(By.xpath("//a[@href='../operator/index.php']")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 28)
	public static void operatoraddfun() throws Exception
	{
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@href='../operator/index.php']")).click();
		driver.findElement(By.xpath("//input[@value='ADD']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("shift_operator_name")).sendKeys("Darsh");
		driver.findElement(By.id("employee_id")).sendKeys("1010");
		WebElement listbox = driver.findElement(By.id("loco_shed"));
		Select list = new Select(listbox);
		list.selectByVisibleText("PNQ");
		driver.findElement(By.id("username")).sendKeys("superadmin");
		driver.findElement(By.id("password")).sendKeys("super");
		driver.findElement(By.id("password2")).sendKeys("super");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//input[@id='button_action']")).click();
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	@Test(priority = 29)
	public static void operatoraddduplicatefun() throws Exception
	{
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@href='../operator/index.php']")).click();
		
		driver.findElement(By.xpath("//input[@value='ADD']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.id("shift_operator_name")).sendKeys("Darshan");
		driver.findElement(By.id("employee_id")).sendKeys("1010");
		WebElement listbox = driver.findElement(By.id("loco_shed"));
		Select list = new Select(listbox);
		list.selectByVisibleText("PNQ");
		driver.findElement(By.id("username")).sendKeys("superadmin");
		driver.findElement(By.id("password")).sendKeys("super");
		driver.findElement(By.id("password2")).sendKeys("super123");
		
		//driver.findElement(By.xpath("//input[@id='button_action']")).click();
		
		String actual = "Passwords do not match!";
		Assert.assertEquals(actual, "Passwords do not match!");
		
		Thread.sleep(1000);
		
	}

	@Test(priority = 30)
	public static void operatorviewfun() throws Exception
	{
		
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@href='../operator/index.php']")).click();
		
		//JavascriptExecutor js1 = (JavascriptExecutor) driver;
		//js1.executeScript("window.scrollBy(0,400)");
		
		driver.findElement(By.xpath("//tbody//tr[2]//td[7]//button[1]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[contains(text(),'Close')]")).click();
		
	}

	@Test(priority = 31)
	public static void operatordelfun() throws Exception
	{
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='../operator/index.php']")).click();
		
		//JavascriptExecutor js1 = (JavascriptExecutor) driver;
		//js1.executeScript("window.scrollBy(0,400)");
		
		driver.findElement(By.xpath("//tbody//tr[2]//td[9]//button[1]")).click();
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(2000);
		
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		
	}

	@Test(priority = 32)
	public static void pilotfun() throws Exception
	{
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		
		driver.findElement(By.xpath("//a[contains(text(),'Pilot')]")).click();
		Thread.sleep(2000);
	}

	@Test (priority = 33)
	public static void pilotradd() throws Exception
	{
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Pilot')]")).click();
		
		driver.findElement(By.xpath("//input[@value='ADD']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("loco_pilot_name")).sendKeys("Hectronic");
		driver.findElement(By.id("employee_id")).sendKeys("9072");
		WebElement listbox = driver.findElement(By.id("loco_shed"));
		Select list = new Select(listbox);
		list.selectByVisibleText("PNQ");
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,400)");
		driver.findElement(By.id("button_action")).click();
		
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	@Test(priority = 34)
	public static void pilotview() throws Exception
	{
		
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Pilot')]")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//html//tr[2]/td[5]/button[1]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@type='button'][contains(text(),'Close')]")).click();
		
		
	}

	@Test(priority = 35)
	public static void pilotdel() throws Exception
	{
		
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@href='../pilot/index.php']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//html//tr[2]/td[7]/button[1]")).click();
		Thread.sleep(4000);
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		Thread.sleep(4000);
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		
	}

	@Test(priority = 36)
	public static void locoenginefun() throws Exception
	{
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Loco Engine')]")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 37)
	public static void locoengineadd() throws Exception
	{
		
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Loco Engine')]")).click();
		driver.findElement(By.xpath("//input[@value='ADD']")).click();
		Thread.sleep(2000	);
		
		driver.findElement(By.id("loco_engine_no")).sendKeys("90726714");
		WebElement listbox = driver.findElement(By.id("loco_shed"));
		Select list = new Select(listbox);
		list.selectByVisibleText("PNQ");
		
		WebElement listbox1 = driver.findElement(By.id("region_name"));
		Select list1 = new Select(listbox1);
		list1.selectByVisibleText("BLR");

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,400)");
		driver.findElement(By.id("button_action")).click();
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		alert.accept(); 
	}

	@Test(priority = 38)
	public static void locoengineview() throws Exception
	{
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Loco Engine')]")).click();
		Thread.sleep(2000);
		
		//JavascriptExecutor js1 = (JavascriptExecutor) driver;
		//js1.executeScript("window.scrollBy(0,400)");
		
		driver.findElement(By.xpath("//tbody//tr[2]//td[5]//button[1]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[contains(text(),'Close')]")).click();
		
	}

	@Test(priority = 39)
	public static void locoenginedel() throws Exception
	{
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Loco Engine')]")).click();
		Thread.sleep(2000);
		
		//JavascriptExecutor js1 = (JavascriptExecutor) driver;
		//js1.executeScript("window.scrollBy(0,400)");
		
		driver.findElement(By.xpath("//tbody//tr[2]//td[7]//button[1]")).click();
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		alert.accept(); 
		
		Thread.sleep(2000);
		
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
	}

	@Test(priority = 40)
	public static void fuelpointfun() throws Exception
	{
		
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Fuel Point')]")).click();
		Thread.sleep(2000);
		
	}

	@Test(priority = 41)
	public static void fuelpointadd() throws Exception
	{
		
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		Thread.sleep(2000	);
		
		driver.findElement(By.xpath("//a[contains(text(),'Fuel Point')]")).click();
		driver.findElement(By.xpath("//input[@value='ADD']")).click();
		Thread.sleep(2000	);
		
		driver.findElement(By.id("fuel_point_no")).sendKeys("1");
		
		WebElement listbox = driver.findElement(By.id("loco_shed"));
		Select list = new Select(listbox);
		list.selectByVisibleText("PNQ");
		
		driver.findElement(By.id("button_action")).click();
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		alert.accept(); 
		
		
	}

	@Test(priority = 42)
	public static void fuelpointview() throws Exception
	{
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Fuel Point')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//tbody//tr[2]//td[4]//button[1]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@type='button'][contains(text(),'Close')]")).click();
		
	}

	@Test(priority = 43)
	public static void fuelpointdelfun() throws Exception
	{
		
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Fuel Point')]")).click();
		driver.findElement(By.xpath("//tbody//tr[2]//td[6]//button[1]")).click();
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		Thread.sleep(2000);
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		
	}

	@Test(priority = 44)
	public static void atgfun() throws Exception
	{
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'ATG (Storage Tank)')]")).click();
		Thread.sleep(2000);
		
	}

	@Test(priority = 45)
	public static void atgaddfun() throws Exception
	{
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'ATG (Storage Tank)')]")).click();
		
		driver.findElement(By.xpath("//input[@value='ADD']")).click();
		driver.findElement(By.id("atg_port")).sendKeys("4");
		driver.findElement(By.id("atg_make")).sendKeys("Veeder Root");
		driver.findElement(By.id("storage_tank_no")).sendKeys("1");
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,400)");
		
		driver.findElement(By.id("button_action")).click();
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	@Test(priority = 46)
	public static void atgviewfun() throws Exception
	{
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'ATG (Storage Tank)')]")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//tr//td[5]//button[1]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@type='button'][contains(text(),'Close')]")).click();
	}

	@Test(priority = 47)
	public static void atgdelfun() throws Exception
	{
		
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'ATG (Storage Tank)')]")).click();
		
		driver.findElement(By.xpath("//tbody//tr[2]//td[7]//button[1]")).click();
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		Thread.sleep(2000);
		
		Alert alert1 = driver.switchTo().alert();
		
		alert1.accept();
		
	}

	@Test(priority = 48)
	public static void addtrainfun() throws Exception
	{
		
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Add Train')]")).click();
		Thread.sleep(2000);
		
	}

	@Test(priority = 49)
	public static void addtrainaddfun() throws Exception
	{
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Add Train')]")).click();
		driver.findElement(By.xpath("//input[@value='ADD']")).click();
		
		driver.findElement(By.id("train_no")).sendKeys("9072");
		WebElement listbox = driver.findElement(By.id("train_type"));
		Select list = new Select(listbox);
		list.selectByVisibleText("Passenger");
		WebElement listbox1 = driver.findElement(By.id("loco_shed"));
		Select list1 = new Select(listbox1);
		list1.selectByVisibleText("PNQ");
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,300)");
		
		driver.findElement(By.id("button_action")).click();
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	@Test(priority = 50)
	public static void addtrainviewfun() throws Exception
	{
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Add Train')]")).click();
		
		driver.findElement(By.xpath("//tbody//tr[2]//td[5]//button[1]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@type='button'][contains(text(),'Close')]")).click();
	}

	@Test(priority = 51)
	public static void addtraindelfun() throws Exception
	{
		
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Add Train')]")).click();
		driver.findElement(By.xpath("//tbody//tr[2]//td[7]//button[1]")).click();
		Thread.sleep(2000);
		
		Alert  alert = driver.switchTo().alert();
		alert.accept();
		
		Thread.sleep(2000);
		
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
	}

	@Test(priority = 52)
	public static void headerfun() throws Exception
	{
		
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Set Report Header')]")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 53)
	public static void headeraddfun() throws Exception
	{
		
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Set Report Header')]")).click();
		driver.findElement(By.xpath("//input[@value='ADD']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("report_header")).sendKeys("Bengaluru");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@id='button_action']")).click();
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
	}

	@Test(priority = 54)
	public static void headerview() throws Exception
	{
		
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Set Report Header')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//tr//td[3]//button[1]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@type='button'][contains(text(),'Close')]")).click();
	}

	@Test(priority = 55)
	public static void headerdel() throws Exception
	{
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Set Report Header')]")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//tr//td[5]//button[1]")).click();
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		Thread.sleep(2000);
		
		Alert alert1 = driver.switchTo().alert();
		alert1.accept();
		
	}

	@Test(priority = 56)
	public static void profilefun() throws Exception
	{
		
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Add Profiles')]")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 57)
	public static void profileadd() throws Exception
	{
		
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		Thread.sleep(2000);
		
		
		driver.findElement(By.xpath("//a[contains(text(),'Add Profiles')]")).click();
		driver.findElement(By.xpath("//input[@value='ADD']")).click();
		Thread.sleep(1000);
		
		WebElement listbox = driver.findElement(By.id("role"));
		Select list = new Select(listbox);
		list.selectByVisibleText("Superadmin");
		
		driver.findElement(By.id("username")).sendKeys("Darshan");
		driver.findElement(By.id("password")).sendKeys("Dars@1234");

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,300)");
		
		driver.findElement(By.id("button_action")).click();
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	@Test(priority = 58)
	public static void profileview() throws Exception
	{
		
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Add Profiles')]")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//tbody//tr[2]//td[4]//button[1]")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[@type='button'][contains(text(),'Close')]")).click();
		
	}

	@Test(priority = 59)
	public static void profiledel() throws Exception
	{
		
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		mousehover();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Add Profiles')]")).click();
		
		driver.findElement(By.xpath("//tbody//tr[2]//td[6]//button[1]")).click();
		Thread.sleep(2000);
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		
	}

	@Test(priority=60)
	public static void entryvalidation() throws Exception
	{
		
		driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();

		driver.get("http://www.hectronicafms.com/lfms/");
		driver.findElement(By.id("name")).sendKeys("superadmin");
		driver.findElement(By.id("contact")).sendKeys("superadmin");
		driver.findElement(By.name("login")).click();
		
		Thread.sleep(2000);
		
		String onspot  = "Username or Password is Invalid,Please Enter Valid Username or Password!";
		Assert.assertEquals(onspot, "Username or Password is Invalid,Please Enter Valid Username or Password!");
		
	}

	 @Test(priority = 61)
	public static void reports() throws Exception
	{
		
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		
		WebElement element = driver.findElement(By.xpath("//body/div[@id='cssmenu']/ul[@class='main-navigation']/li[6]/a[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		
		Thread.sleep(2000);
		
	}

	@Test(priority = 62)
	public static void shiftreport() throws Exception
	{
		
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		
		WebElement element = driver.findElement(By.xpath("//body/div[@id='cssmenu']/ul[@class='main-navigation']/li[6]/a[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		
		driver.findElement(By.xpath("//a[@href='../shift_report/index.php']")).click();
		Thread.sleep(2000);
		
	}

	@Test(priority = 63) 
	public static void shiftreportgenerate() throws Exception
	{
		
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		
		WebElement element = driver.findElement(By.xpath("//body/div[@id='cssmenu']/ul[@class='main-navigation']/li[6]/a[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		
		driver.findElement(By.xpath("//a[@href='../shift_report/index.php']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("date")).sendKeys("2018-01-23");
		driver.findElement(By.id("filter")).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.id("export")).click();
		Thread.sleep(2000);
	}

	@Test(priority = 64)
	public static void shiftreportview() throws Exception
	{
		
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		
		WebElement element = driver.findElement(By.xpath("//body/div[@id='cssmenu']/ul[@class='main-navigation']/li[6]/a[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		
		driver.findElement(By.xpath("//a[@href='../shift_report/index.php']")).click();
		
		driver.findElement(By.id("date")).sendKeys("2018-01-23");
		driver.findElement(By.id("filter")).click();
		
		//driver.findElement(By.xpath("//html//td[15]/input[1]")).click();
		//Thread.sleep(2000);
		
		
		
	}
			
	@Test(priority = 65)
	public static void shiftdateerrorvalidation() throws Exception
	{
		
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		
		WebElement element = driver.findElement(By.xpath("//body/div[@id='cssmenu']/ul[@class='main-navigation']/li[6]/a[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		
		driver.findElement(By.xpath("//a[@href='../shift_report/index.php']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("date")).sendKeys("2018-01-22");
		driver.findElement(By.id("filter")).click();
		
		Thread.sleep(2000);
		
		String actual = "No Order Found";
		Assert.assertEquals("No Order Found", actual);
		
		Thread.sleep(2000);
		
		
	}

	@Test(priority = 66)
	public static void Transaction() throws Exception
	{
		
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		
		WebElement element = driver.findElement(By.xpath("//body/div[@id='cssmenu']/ul[@class='main-navigation']/li[6]/a[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		
		driver.findElement(By.xpath("//a[@href='../transaction_report/index.php']")).click();
		Thread.sleep(2000);
		
	}

	@Test(priority = 67)
	public static void Transactionreportgenerate() throws Exception
	{
			
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		
		WebElement element = driver.findElement(By.xpath("//body/div[@id='cssmenu']/ul[@class='main-navigation']/li[6]/a[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		
		driver.findElement(By.xpath("//a[@href='../transaction_report/index.php']")).click();
		
		driver.findElement(By.id("from_date")).sendKeys("2018-01-23");
		driver.findElement(By.id("to_date")).sendKeys("2018-02-23");
		driver.findElement(By.id("filter")).click();
		
		driver.findElement(By.id("export")).click();
		
		Thread.sleep(2000);
		
	}

	@Test(priority = 68)
	public static void Transactionreportview() throws Exception
	{
		
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		
		WebElement element = driver.findElement(By.xpath("//body/div[@id='cssmenu']/ul[@class='main-navigation']/li[6]/a[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Transaction Report')]")).click();
		
		driver.findElement(By.id("from_date")).sendKeys("2018-01-01");
		driver.findElement(By.id("to_date")).sendKeys("2018-04-17");
		driver.findElement(By.id("filter")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//tbody//tr[1]//td[15]//input[1]")).click();
		
		Thread.sleep(2000);
		
		/*JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,800)");
		
		Thread.sleep(2000);*/
		
		//driver.findElement(By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/button[1]")).click();
		//div[@id='dataModal']//button[@type='button'][contains(text(),'×')]
		Thread.sleep(2000);
		
		
	}

	@Test(priority = 69)
	public static void Transactionerrorvalidation() throws Exception
	{
		
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		
		WebElement element = driver.findElement(By.xpath("//body/div[@id='cssmenu']/ul[@class='main-navigation']/li[6]/a[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		
		driver.findElement(By.xpath("//a[@href='../transaction_report/index.php']")).click();
		driver.findElement(By.id("from_date")).sendKeys("2018-01-21");
		driver.findElement(By.id("to_date")).sendKeys("2018-01-22");
		driver.findElement(By.id("filter")).click();
		
		Thread.sleep(2000);
		
		String actual = "No Order Found";
		Assert.assertEquals("No Order Found", actual);
		
		Thread.sleep(2000);
		
	}

	@Test(priority = 70)
	public static void Operator() throws Exception
	{
		
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		
		WebElement element = driver.findElement(By.xpath("//body/div[@id='cssmenu']/ul[@class='main-navigation']/li[6]/a[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		
		driver.findElement(By.xpath("//a[@href='../operator_report/index.php']")).click();
		Thread.sleep(2000);
		
	}

	@Test(priority = 71)
	public static void Operatorreport() throws Exception
	{
		
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		
		WebElement element = driver.findElement(By.xpath("//body/div[@id='cssmenu']/ul[@class='main-navigation']/li[6]/a[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		
		driver.findElement(By.xpath("//a[@href='../operator_report/index.php']")).click();
		driver.findElement(By.id("operator_id")).sendKeys("1008");
		driver.findElement(By.id("from_date")).sendKeys("2018-01-01");
		driver.findElement(By.id("to_date")).sendKeys("2018-04-13");
		
		driver.findElement(By.id("filter")).click();
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		
		//driver.findElement(By.xpath("//button[@id='export']")).click();
		//Thread.sleep(2000);
		
	}

	@Test(priority = 72)
	public static void Operatorreportview() throws Exception
	{
		
driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		
		WebElement element = driver.findElement(By.xpath("//body/div[@id='cssmenu']/ul[@class='main-navigation']/li[6]/a[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		
		driver.findElement(By.xpath("//a[@href='../operator_report/index.php']")).click();
		driver.findElement(By.id("operator_id")).sendKeys("1008");
		driver.findElement(By.id("from_date")).sendKeys("2018-01-01");
		driver.findElement(By.id("to_date")).sendKeys("2018-04-13");
		
		driver.findElement(By.id("filter")).click();
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		
		driver.findElement(By.xpath("//html//tr[5]/td[15]/input[1]")).click();
		Thread.sleep(2000);
		
		Thread.sleep(10);
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,800)");
		
		driver.findElement(By.xpath("//div[@id='dataModal']//div[@class='modal-dialog']//div[@class='modal-content']//div[@class='modal-footer']//button[@type='button']")).click();
		
	}

	@Test(priority = 73)
	public static void Operatorreporterrorvalidation() throws Exception
	{
		
		driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
		
		WebElement element = driver.findElement(By.xpath("//body/div[@id='cssmenu']/ul[@class='main-navigation']/li[6]/a[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		
		driver.findElement(By.xpath("//a[@href='../operator_report/index.php']")).click();
		driver.findElement(By.id("operator_id")).sendKeys("1008");
		driver.findElement(By.id("from_date")).sendKeys("2018-01-01");
		driver.findElement(By.id("to_date")).sendKeys("2018-01-13");
		
		driver.findElement(By.id("filter")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[4]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[15]/input[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='dataModal']//button[@type='button'][contains(text(),'×')]")).click();
		
		/*String actual = "No Order Found";
		Assert.assertEquals("No Order Found", actual); */
		
		Thread.sleep(2000);
		
		
	}
@Test(priority = 74)
public static void flow() throws Exception
{
	
	driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
	
	WebElement element = driver.findElement(By.xpath("//body/div[@id='cssmenu']/ul[@class='main-navigation']/li[6]/a[1]"));
	Actions action = new Actions(driver);
	action.moveToElement(element).build().perform();
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//a[@href='../flow_meter_report/index.php']")).click();
	
	Thread.sleep(2000);
	
	
}

@Test(priority = 75)
public static void flowmeterreport() throws Exception
{

	driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
	
	WebElement element = driver.findElement(By.xpath("//body/div[@id='cssmenu']/ul[@class='main-navigation']/li[6]/a[1]"));
	Actions action = new Actions(driver);
	action.moveToElement(element).build().perform();
	Thread.sleep(2000);
	
	
	driver.findElement(By.xpath("//a[contains(text(),'Flow Meter Report')]")).click();
	Thread.sleep(2000);
	
	WebElement listbox = driver.findElement(By.id("flow_meter"));
	Select list = new Select(listbox);
	list.selectByValue("1");
	
	driver.findElement(By.id("from_date")).sendKeys("2018-01-01");
	driver.findElement(By.id("to_date")).sendKeys("2018-04-12");
	
	driver.findElement(By.id("filter")).click();
	
	Thread.sleep(2000);
	
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,600)");
	
	//driver.findElement(By.xpath("//button[@id='export']")).click();
	
	//driver.findElement(By.id("export")).click();
	//Thread.sleep(2000);
	
}

@Test(priority = 76)
public static void flowmeterreportview() throws Exception
{
	
	driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
	                                                                                                                                                                                                     
	WebElement element = driver.findElement(By.xpath("//body/div[@id='cssmenu']/ul[@class='main-navigation']/li[6]/a[1]"));
	Actions action = new Actions(driver);
	action.moveToElement(element).build().perform(); 
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//a[contains(text(),'Flow Meter Report')]")).click();
	Thread.sleep(2000);
	
	WebElement listbox = driver.findElement(By.xpath("//select[@id='flow_meter']"));
	Select se= new Select(listbox);
	se.selectByValue("1");
	
	driver.findElement(By.id("from_date")).sendKeys("2018-01-01");
	driver.findElement(By.id("to_date")).sendKeys("2018-04-12");
	
	driver.findElement(By.id("filter")).click();
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//tbody//tr[1]//td[15]//input[1]")).click();

	Thread.sleep(2000);
	

	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,800)");
	
	//Thread.sleep(2000);
	//driver.findElement(By.xpath("//div[@id='dataModal']//div[@class='modal-dialog']//div[@class='modal-content']//div[@class='modal-footer']//button[@type='button']")).click();
	
}   

@Test(priority = 77)
public static void traintype() throws Exception
{
	
	driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
	
	WebElement element = driver.findElement(By.xpath("//body/div[@id='cssmenu']/ul[@class='main-navigation']/li[6]/a[1]"));
	Actions action = new Actions(driver);
	action.moveToElement(element).build().perform();
	
	driver.findElement(By.xpath("//a[@href='../train_type_report/index.php']")).click();
	
	Thread.sleep(2000);
	
	
}

@Test(priority = 78)
public static void traintypereport() throws Exception
{
	
	driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
	
	WebElement element = driver.findElement(By.xpath("//body/div[@id='cssmenu']/ul[@class='main-navigation']/li[6]/a[1]"));
	Actions action = new Actions(driver);
	action.moveToElement(element).build().perform();
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//a[@href='../train_type_report/index.php']")).click();
	
	WebElement element1 = driver.findElement(By.id("train_type"));
	Select list = new Select(element1);
	list.selectByVisibleText("Passenger");
	
	driver.findElement(By.id("from_date")).sendKeys("2018-01-01");
	driver.findElement(By.id("to_date")).sendKeys("2018-04-12");
	driver.findElement(By.id("filter")).click();
	
	JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,800)");
	
	Thread.sleep(2000); 
	//driver.findElement(By.xpath("//button[@id='export']")).click();
	
		
} 

@Test(priority = 79)
public static void traintypereportview() throws Exception
{

	driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
	
	WebElement element = driver.findElement(By.xpath("//body/div[@id='cssmenu']/ul[@class='main-navigation']/li[6]/a[1]"));
	Actions action = new Actions(driver);
	action.moveToElement(element).build().perform();
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//a[@href='../train_type_report/index.php']")).click();
	
	WebElement element1 = driver.findElement(By.id("train_type"));
	Select list = new Select(element1);
	list.selectByVisibleText("Passenger");
	
	driver.findElement(By.id("from_date")).sendKeys("2018-01-01");
	driver.findElement(By.id("to_date")).sendKeys("2018-04-12");
	driver.findElement(By.id("filter")).click();
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//tbody//tr[1]//td[15]//input[1]")).click();
	Thread.sleep(2000);

	
	/* JavascriptExecutor js1 = (JavascriptExecutor) driver;
	js1.executeScript("window.scrollBy(0,800)");
	
	Thread.sleep(2000);
	*/ 
	
	//driver.findElement(By.xpath("//div[@id='dataModal']//button[@type='button']")).click();
	//driver.findElement(By.id("id")).click();
	
} 



@Test(priority = 80)
public static void Trainwise() throws Exception
{

	driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
	
	WebElement element = driver.findElement(By.xpath("//body/div[@id='cssmenu']/ul[@class='main-navigation']/li[6]/a[1]"));
	Actions action = new Actions(driver);
	action.moveToElement(element).build().perform();
	
	driver.findElement(By.xpath("//a[contains(text(),'Train Wise Issue Report')]")).click();
		Thread.sleep(2000);
}

@Test(priority = 81)
public static void Trainwisereport() throws Exception
{
	
	driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
	
	WebElement element = driver.findElement(By.xpath("//body/div[@id='cssmenu']/ul[@class='main-navigation']/li[6]/a[1]"));
	Actions action = new Actions(driver);
	action.moveToElement(element).build().perform();
	
	driver.findElement(By.xpath("//a[contains(text(),'Train Wise Issue Report')]")).click();
	
	driver.findElement(By.id("from_date")).sendKeys("2018-02-01");
	driver.findElement(By.id("to_date")).sendKeys("2018-04-17");
	driver.findElement(By.id("filter")).click();
	
	//JavascriptExecutor js1 = (JavascriptExecutor) driver;
	//js1.executeScript("window.scrollBy(0,800)");
	
	//driver.findElement(By.xpath("//button[@id='export']")).click();
	//Thread.sleep(2000);
	Thread.sleep(2000);
} 

/* @Test(priority = 82)
public static void ATGreport() throws Exception
{
	
	driver.findElement(By.xpath("//a[@href='../shift_configration/index.php']")).click();
	
	WebElement element = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/ul[1]/li[4]/a[1] "));
	Actions action = new Actions(driver);
	action.moveToElement(element).build().perform();
	
	driver.findElement(By.xpath("//a[contains(text(),'Tank Status')]")).click();
	
	
	
	
}*/

public static int mousehover()
{
	WebElement element = driver.findElement(By.xpath("//html//ul[@class='main-navigation']/li[2]/a[1]"));
	Actions action = new Actions(driver);
	action.moveToElement(element).build().perform();
	return 1; 

}

@AfterMethod
public void teardown() 
{
		
	driver.quit();
} 
}