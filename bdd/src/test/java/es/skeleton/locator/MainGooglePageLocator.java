package es.skeleton.locator;

import org.openqa.selenium.By;

public enum MainGooglePageLocator implements PageLocator {
	
	SEARCH_BOX(By.id("lst-ib"));
	

	private By locator;
	
	MainGooglePageLocator(By locator) {
        this.locator = locator;
    }
	
	@Override
    public By locator() {
        return locator;
    }
}
