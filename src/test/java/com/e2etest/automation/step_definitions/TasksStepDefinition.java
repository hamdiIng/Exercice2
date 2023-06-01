package com.e2etest.automation.step_definitions;

import org.junit.Assert;

import com.e2etest.automation.page_objects.TasksPage;
import com.e2etest.automation.utils.ConfigFileReader;
import com.e2etest.automation.utils.SeleniumUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TasksStepDefinition {

	protected ConfigFileReader configFileReader;
	protected SeleniumUtils seleniumUtils;
	protected TasksPage tasksPage;

	public TasksStepDefinition() {
		configFileReader = new ConfigFileReader();
		seleniumUtils = new SeleniumUtils();
		tasksPage = new TasksPage();
	}

	@Given("Je me rends sur le site {string}")
	public void jeMeRendsSurLeSite(String URL) {
		seleniumUtils.get(configFileReader.getProperties(URL));
	}

	@When("Je clique sur le bouton de connexion")
	public void jeCliqueSurLeBoutonDeConnexion() {
		TasksPage.loginBtn.click();

	}

	@Then("Je vérifie que le bouton de connexion est non cliquable")
	public void jeVérifieQueLeBoutonDeConnexionEstNonCliquable() {
		boolean clickBtn = seleniumUtils.isCliquable(tasksPage.loginBtn);
		Assert.assertFalse(clickBtn);
	}

	@When("Je saisie le login {string}")
	public void jeSaisieLeLogin(String login) {
		seleniumUtils.saisie(tasksPage.textLogin, login);

	}

	@Given("Je saisie le mot de passe {string}")
	public void jeSaisieLeMotDePasse(String password) {
		seleniumUtils.saisie(tasksPage.textPassword, password);

	}

	@Then("Je vérifie qu un message rouge apparait pour alerter {string}")
	public void jeVérifieQuUnMessageRougeApparaitPourAlerter(String string) {
		boolean showMsg = seleniumUtils.isElementDisplayed(tasksPage.alertMessage);
		Assert.assertTrue(showMsg);
	}

	@Given("La page change")
	public void laPageChange() {
		tasksPage.checkUrlChnaged();

	}

	@When("Je me connecte")
	public void jeMeConnecte() {
		tasksPage.login();

	}

	@Then("Je vérifie que les liens sont affiches {string} {string}")
	public void jeVérifieQueLesLiensSontAffiches(String linkTasks, String linkLogout) {
		String link_tasks = TasksPage.lienTasks.getText();
		String link_logout = TasksPage.lienDeconnexion.getText();
		Assert.assertEquals(link_tasks,linkTasks);
		Assert.assertEquals(link_logout,linkLogout);
	}

	@When("Je clique sur le bouton Ajout de tache")
	public void jeCliqueSurLeBoutonAjoutDeTache() {
		TasksPage.addTaskBtn.click();

	}

	@Then("Je vérifie que le bouton ajout de tache est inactive")
	public void jeVérifieQueLeBoutonAjoutDeTacheEstInactive() {
		boolean addBtn = seleniumUtils.isCliquable(TasksPage.addTaskBtn);
		Assert.assertFalse(addBtn);

	}

	@When("Je saisie la description de la tache {string}")
	public void jeSaisieLaDescriptionDeLaTache(String desc) {
		seleniumUtils.saisie(tasksPage.taskDescription, desc);

	}

	@When("Je saisie le nom de la tache {string}")
	public void jeSaisieLeNomDeLaTache(String name) {
		seleniumUtils.saisie(tasksPage.taskName, name);

	}
	
	@When("J ajoute une tache")
	public void jAjouteUneTache() {
		tasksPage.ajouterTache();
		
	}
	
	@When("Je verifie que la tache est ajoutee")
	public void jeVerifieQueLaTacheEstAjoutee() {
		String text_msg = TasksPage.addedTask.getText();
		Assert.assertEquals(text_msg, configFileReader.getProperties("todolist.nameTask"));
		
	}
	

}