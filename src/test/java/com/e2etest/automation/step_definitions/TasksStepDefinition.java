package com.e2etest.automation.step_definitions;

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
	  
	}
	@Then("Je vérifie que le bouton de connexion est non cliquable")
	public void jeVérifieQueLeBoutonDeConnexionEstNonCliquable() {
	
	}

	@When("Je saisie le login")
	public void jeSaisieLeLogin() {
	    
	}

	@Given("Je saisie le mot de passe")
	public void jeSaisieLeMotDePasse() {
	 
	}


	@Then("Je vérifie qu un message rouge apparait pour alerter {string}")
	public void jeVérifieQuUnMessageRougeApparaitPourAlerter(String string) {

	}

	@Given("La page change")
	public void laPageChange() {

	}
	@Then("Je vérifie que les liens sont affiches {string} {string}")
	public void jeVérifieQueLesLiensSontAffiches(String string, String string2) {

	}

	@When("Je clique sur le bouton Ajout de tache")
	public void jeCliqueSurLeBoutonAjoutDeTache() {
	   
	}
	@Then("Je vérifie que le bouton ajout de tache est inactive")
	public void jeVérifieQueLeBoutonAjoutDeTacheEstInactive() {

	}

	@When("Je saisie la description de la tache")
	public void jeSaisieLaDescriptionDeLaTache() {

	}

	@When("Je saisie le nom de la tache")
	public void jeSaisieLeNomDeLaTache() {
	   
	}


}