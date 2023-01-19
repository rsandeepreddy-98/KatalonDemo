import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver as Keys
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By

WebUI.openBrowser('https://www.spicejet.com/')

Thread.sleep(2000)

WebUI.click(findTestObject('Object Repository/spice_jet_pageObjects/datePicker_icon'))

String targetDate = "19-March-2023"

String expectedDate = targetDate.split('-')[0].trim()

System.out.println(expectedDate)

String expectedMonth = targetDate.split('-')[1].trim()//March

System.out.println(expectedMonth)

String expectedyear = targetDate.split('-')[2].trim()//2022

System.out.println(expectedyear)

String month_Year = WebUI.getText(findTestObject('spice_jet_pageObjects/month_year'))

//WebUI.click(findTestObject('spice_jet_pageObjects/next_btnCalender'))

System.out.println(month_Year)

String current_month = month_Year.split(" ")[0].trim() //December]

String current_Year = month_Year.split(" ")[1].trim() //2022


System.out.println(((('Current_Month = ' + current_month) + ' ') + 'Current_year = ') + current_Year)

while (!(current_month.equals(expectedMonth) && current_Year.equals(expectedyear))) {
    WebUI.click(findTestObject('spice_jet_pageObjects/next_btnCalender'))
	 current_month = month_Year.split(" ")[0].trim() //December]
	
	 current_Year = month_Year.split(" ")[1].trim() //2022
	
	
	System.out.println(((('Current_Month = ' + current_month) + ' ') + 'Current_year = ') + current_Year)
	
}

WebDriver driver = DriverFactory.getWebDriver()

List<WebElement> allDates = driver.findElements(By.xpath('//div[@class=\'css-76zvg2 r-homxoj r-ubezar r-16dba41\']'))

for (WebElement e : allDates) {
    if (e.getText().equalsIgnoreCase(expectedDate)) {
        e.click()

        break
    }
}