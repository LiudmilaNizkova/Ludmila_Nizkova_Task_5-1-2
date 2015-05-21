package by.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage{
	
	private final String BASE_URL = "http://www.yandex.ru/";
	
	@FindBy(name = "login")
	private WebElement inputLogin;

	@FindBy(name = "passwd")
	private WebElement inputPassword;
	
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	private WebElement loginButton;
	
	public MainPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	public void loginToMail(String username, String password){
		inputLogin.sendKeys(username);
		inputPassword.sendKeys(password);
		loginButton.click();
		//return new HomePage(this.driver);
		
	}

	//@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
		
	}


}
