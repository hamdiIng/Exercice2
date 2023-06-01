package com.e2etest.automation.page_objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2etest.automation.utils.ConfigFileReader;
import com.e2etest.automation.utils.Setup;

public class TasksPage {

	public ConfigFileReader configFileReader;

	final static String LOGIN = "//input[@type='email']";
	final static String PASSWORD = "//input[@type='password']";
	final static String BTNLOGIN = "//*[@type='submit']";
	final static String ALERT_MSG= "//*[@class='alert alert-danger']";

	final static String TASK_NAME = "//*[@id=\"root\"]/div/div/div/div[1]/input";
	final static String TASK_DESCRIPTION = "//*[@id=\"root\"]/div/div/div/div[2]/input";
	final static String TASK_ADD_BTN="//*[@class='btn btn-primary']";
	final static String TASK_ADDED="//*[@id=\"root\"]/div/div/ul/li[1]/span[1]/b";

	final static String LIEN_DECONNEXION = "//*[@id=\"navbarSupportedContent\"]/ul/li[3]/a";
	final static String LIEN_TASKS = "//*[@id=\"navbarSupportedContent\"]/ul/li[2]/a";

	/* @FindBy */
	@FindBy(how = How.XPATH, using = LOGIN)
	public static WebElement textLogin;
	@FindBy(how = How.XPATH, using = PASSWORD)
	public static WebElement textPassword;
	@FindBy(how = How.XPATH, using = BTNLOGIN)
	public static WebElement loginBtn;

	@FindBy(how = How.XPATH, using = TASK_NAME)
	public static WebElement taskName;
	@FindBy(how = How.XPATH, using = TASK_DESCRIPTION)
	public static WebElement taskDescription;
	@FindBy(how = How.XPATH, using = TASK_ADD_BTN)
	public static WebElement addTaskBtn;
	
	@FindBy(how = How.XPATH, using = TASK_ADDED)
	public static WebElement addedTask;
	//*[@id="root"]/div/div/ul/li[1]/span[1]/b

	@FindBy(how = How.XPATH, using = LIEN_DECONNEXION)
	public static WebElement lienDeconnexion;
	@FindBy(how = How.XPATH, using = LIEN_TASKS)
	public static WebElement lienTasks;
	
	@FindBy(how = How.XPATH, using = ALERT_MSG)
	public static WebElement alertMessage;
	

	public TasksPage() {
		configFileReader = new ConfigFileReader();
		PageFactory.initElements(Setup.getDriver(), this);
	}

	public void checkUrlChnaged() {
		String actualUrl = Setup.getDriver().getCurrentUrl();
		System.out.println("Title of page is " + actualUrl);
		String url = configFileReader.getProperties("todolist.url");
		if (actualUrl.equals(url)) {
			System.out.println("Failed - The URL is not changed");
		} else {
			System.out.println("Succesfull - The URL is changed");
		}
	}
	public void login() {
		textLogin.clear();
		textLogin.sendKeys(configFileReader.getProperties("todolist.login"));
		textPassword.clear();
		textPassword.sendKeys(configFileReader.getProperties("todolist.password"));
		loginBtn.click();
	}
	public void ajouterTache() {
		taskName.clear();
		taskName.sendKeys(configFileReader.getProperties("todolist.nameTask"));
		taskDescription.clear();
		taskDescription.sendKeys(configFileReader.getProperties("todolist.descTask"));
		addTaskBtn.click();
	}

}
