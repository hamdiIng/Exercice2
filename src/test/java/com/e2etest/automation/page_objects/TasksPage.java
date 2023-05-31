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
	
	final static String TASK_NAME = "//*[@id=\"root\"]/div/div/div/div[1]/input";
	final static String TASK_DESCRIPTION = "//*[@id=\"root\"]/div/div/div/div[2]/input";
	
	final static String LIEN_DECONNEXION = "//*[@id=\"navbarSupportedContent\"]/ul/li[3]/a";
	final static String LIEN_TASKS = "//*[@id=\"navbarSupportedContent\"]/ul/li[2]/a";

	/* @FindBy */
	@FindBy(how = How.XPATH, using = LOGIN)
	public static WebElement textLogin;
	@FindBy(how = How.XPATH, using = PASSWORD)
	public static WebElement textPassword;
	
	
	@FindBy(how = How.XPATH, using = TASK_NAME)
	public static WebElement taskName;
	@FindBy(how = How.XPATH, using = TASK_DESCRIPTION)
	public static WebElement taskDescription;
	
	@FindBy(how = How.XPATH, using = LIEN_DECONNEXION)
	public static WebElement lienDeconnexion;
	@FindBy(how = How.XPATH, using = LIEN_TASKS)
	public static WebElement lienTasks;
	
	

	
	public TasksPage() {
		configFileReader = new ConfigFileReader();
		PageFactory.initElements(Setup.getDriver(), this);
	}
	public void checkUrlChnaged() {
		String actualUrl=Setup.getDriver().getCurrentUrl();
		System.out.println("Title of page is " + actualUrl);
		String url= configFileReader.getProperties("todolist.url");
		if(actualUrl.equals(url))
		{
			System.out.println("Failed - The URL is not changed");
		}
		else {
			System.out.println("Succesfull - The URL is changed");
		}
	}

}
