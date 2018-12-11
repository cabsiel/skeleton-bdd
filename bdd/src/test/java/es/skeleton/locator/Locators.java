package es.skeleton.locator;

import org.openqa.selenium.By;

public final class Locators {
	private Locators() {
		// Private constructor to avoid instantiation
	}
	
	protected static By textInput(String fieldName) {
		return By.xpath("//label[text()='"+fieldName+"']/../..//input[@type='text']");
	}
	
	protected static By textAreaInput(String fieldName) {
		return By.xpath("//label[text()='"+fieldName+"']/../..//textarea[@role='textbox']");
	}
	
	protected static By textSearchInput(String fieldName) {
		return By.xpath("//label[text()='"+fieldName+"']/../..//input[@role='textbox']");
	}
	
	protected static By calendarInput(String fieldName) {
		return By.xpath("//input[contains(@class,'hasDatepicker')][@type='text']/../../../../div/label[text()='" + fieldName + "']/../../div/div/span/input");
	}
	
	protected static By dropDownInput(String fieldName) {
		return By.xpath("//*[contains(@class,'ui-selectonemenu-label ui-inputfield ui-corner-all')]/../../../../div/label[text()='" + fieldName + "']/../../div/div/div/label");
	}
	
	protected static By colorListInput(String fieldName) {
		return By.xpath("//*[contains(@class,'ui-selectonemenu-label ui-inputfield ui-corner-all')]/../../../../div/label[text()='" + fieldName + "']/../../div/div/div/label");
	}
	
	protected static By checkboxInput(String fieldName) {
		return By.xpath("//*[contains(@class, 'ui-chkbox')]/../label[text() = '" + fieldName + "']/../div/div[2]");
	}
	
	protected static By tab(String tabName) {
		return By.xpath("//li[@role='tab']/a[text()='" + tabName + "']");
	}
}
