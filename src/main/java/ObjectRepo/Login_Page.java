package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	public Login_Page(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
		
		//Declaration
		@FindBy(id="username")
		private WebElement UserTextField;
		
		@FindBy(xpath="//input[@placeholder='Password']")
		private WebElement PassWordTextField;
		
		@FindBy(id="loginButton")
		private WebElement LoginButton;

		//getter method
		public WebElement getUserTextField() {
			return UserTextField;
		}

		public WebElement getPassWordTextField() {
			return PassWordTextField;
		}

		public WebElement getLoginButton() {
			return LoginButton;
		}
		
		//Business Logics
		public void loginData(String userName,String passWord)
		{
			UserTextField.sendKeys(userName);
			PassWordTextField.sendKeys(passWord);
			LoginButton.click();
		}
		
		
	
}



