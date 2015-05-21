package by.epam.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractPage{

//	private static final String BASE_URL = "http://www.yandex.ru/";
	//private WebDriver driver;
	
	@FindBy(xpath = "(//span[@class='js-messages-title-dropdown-name'])")
	private WebElement loggedUser;
	
	@FindBy(xpath = "(//span[@class='b-toolbar__item__label js-toolbar-item-title-compose'])")
	WebElement buttonNewEmail;
	
	@FindBy(xpath = "(//span[contains(@class,'b-pseudo-link daria-action') and contains(@data-action,'mail-common.abook-popup')])")
	WebElement sendTo;
	
	@FindBy(xpath = "(//span[@class='abook-entry-name-content'])")
	WebElement chooseEmail;
	
	@FindBy(xpath = "(//button[@class='nb-button _nb-action-button _init js-abook-popup-ok ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only'])")
	WebElement submitEmail;
	
	@FindBy(id = "compose-subj")
	WebElement sendSubject;
	
	@FindBy(id = "compose-send")
	WebElement sendBody;
	
	@FindBy(linkText = "Черновики")
	WebElement folderDraft;
		
	@FindBy(xpath = "(//button[contains(@class,' nb-button _nb-small-button _init daria-action  b-popup__focus-me') and contains(@data-action,'dialog.save')])")
	WebElement saveDraftEmail;
	
	@FindBy(xpath = "(//button[contains(@id,'nb-16') and contains(@title,'Отправить письмо (Ctrl + Enter)')])")
	WebElement buttonSendEmail;
	
	@FindBy(linkText = "Отправленные")
	WebElement folderSent;
	
	@FindBy(xpath = "(//span[@class='b-messages__subject'])")
	WebElement titleEmail;
	
//	@FindBy(xpath = "(//a[contains(@class,'b-messages__message__link daria-action') and contains(@data-action, 'thread.toggle')])")
//	WebElement bodyEmail; //Hello! This is test of Module 5. Bye
	
	@FindBy(xpath = "(//span[@class='header-user-pic b-mail-dropdown__handle'])")
	WebElement buttonExit;
	
	@FindBy(xpath = "(//a[contains(@class,'b-mail-dropdown__item__content ') and contains(@data-metric,'Меню сервисов:Выход')])")
	WebElement buttonExitExit;
	
	@FindBy(xpath = "(//div[@class='b-popup__close daria-action'])")
	WebElement popupWindow;
	
	@FindBy(xpath = "(//html[@id='js']/body/div[5]/div[2]/table/tbody/tr/td/div[3]/div/a)")
//	@FindBy(xpath = "(//a[contains(@class,'daria-action') and contains(@data-action,'common.clck')])")
	WebElement submitExit;

	public HomePage(WebDriver driver){
		//this.driver = driver;
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	public String getLoggedUserName(){
		return loggedUser.getText();
	}
	
	public void writeNewEmail(String subject, String body){
		buttonNewEmail.click();
		sendTo.click();
		chooseEmail.click();
		submitEmail.click();
		sendSubject.sendKeys(subject);
		sendBody.sendKeys(body);
	}
	
	public void saveEmailToDraft(){
		if (saveDraftEmail.getText().equals("Сохранить и перейти")){
			saveDraftEmail.click();
		}
	}
	
	public void openDraftFolder(){
		folderDraft.click();
	}
	
	public void openSentFolder(){
		folderSent.click();
	}
	
	public String getTitleOfEmail(){
		return titleEmail.getText();
	}
	
	public String getTitleEmailInSentFolder(){
		return titleEmail.getAttribute("title");
	}
	
	public void sendNewEmail(){
		titleEmail.click();
		buttonSendEmail.click();
	}
	
	public void quitFromMailBox(){
		buttonExit.click();
		buttonExitExit.click();
		if (popupWindow.getAttribute("title").equals("Закрыть")){
//			System.out.println(popupWindow.getAttribute("title"));
			submitExit.click();
			
		}
	}


	/*@Override
	public void openPage() {
		// TODO Auto-generated method stub
		driver.navigate().to(BASE_URL);
	}*/
}
