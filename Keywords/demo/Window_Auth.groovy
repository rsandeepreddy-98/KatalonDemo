package demo

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.assertj.core.api.Assert
import org.openqa.selenium.TakesScreenshot

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.webui.keyword.builtin.TakeScreenshotKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import groovy.ui.SystemOutputInterceptor
import internal.GlobalVariable

public class Window_Auth_popUp {
	@Keyword
	public void AuthLogin() {
		WebUI.openBrowser("https://admin:admin@the-internet.herokuapp.com/")
		WebUI.click(findTestObject('Object Repository/Pgae_objects/Window_Auth_PageObjects/Basic_Auth'))
		String expected = "Congratulations! You must have the proper credentials.";
		String actual = WebUI.getText(findTestObject('Object Repository/Pgae_objects/Window_Auth_PageObjects/Congragulations_text'))
		if(actual.equalsIgnoreCase(expected)) {
			System.out.println("Validated");
		}
		else {
			WebUI.takeScreenshot()
			System.out.println("Not validated...Please check");
		}
		org.testng.Assert.assertEquals(expected, actual);
		WebUI.closeBrowser()
	}
}
