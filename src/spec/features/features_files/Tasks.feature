@LoginaddTasks
Feature: Se rendre sur le site locale et effectuer une série de tests afin de vérifierla connexion et la gestion des taches


  @loginParamsVides
  Scenario: Se rendre sur le site locale et effectuer le test de connexion avec login et mot de passe  vide
    Given Je me rends sur le site "todolist.url"
    When Je clique sur le bouton de connexion
    Then Je vérifie que le bouton de connexion est non cliquable

  @loginPasswordVides
  Scenario: Se rendre sur le site locale et effectuer le test de connexion avec mot de passe  vide
    Given Je me rends sur le site "todolist.url"
     When Je saisie le login
    And Je clique sur le bouton de connexion
    Then Je vérifie que le bouton de connexion est non cliquable

  @loginLoginVide
  Scenario: Se rendre sur le site locale et effectuer le test de connexion avec login vide
    When Je saisie le mot de passe
    And Je clique sur le bouton de connexion
    Then Je vérifie que le bouton de connexion est non cliquable

  @loginParamsIncorrect
  Scenario: Se rendre sur le site locale et effectuer le test de connexion avec des identifiant non conforme
    When Je saisie le login
    And Je saisie le mot de passe
    And Je clique sur le bouton de connexion
    Then Je vérifie qu un message rouge apparait pour alerter "Désolé, les identifiants sont incorrects."

  @loginCasPassant
  Scenario: Se rendre sur le site locale et effectuer le test de connexion avec des identifiant valide
    When Je saisie le login
    And Je saisie le mot de passe
    And Je clique sur le bouton de connexion
    And La page change
    Then Je vérifie que les liens sont affiches "Tâches" "Déconnexion"

  @addTaskParamsVides
  Scenario: Se rendre sur le site locale et effectuer le test d ajout d une tache nul
    When Je saisie le login
    And Je saisie le mot de passe
    And Je clique sur le bouton de connexion
    And La page change
    And Je vérifie que les liens sont affiches "Tâches" "Déconnexion"
    And Je clique sur le bouton Ajout de tache
    Then Je vérifie que le bouton ajout de tache est inactive

  @addTaskNomVide
  Scenario: Se rendre sur le site locale et effectuer le test d ajout d une tache sans nom
    When Je saisie le login
    And Je saisie le mot de passe
    And Je clique sur le bouton de connexion
    And La page change
    And Je vérifie que les liens sont affiches "Tâches" "Déconnexion"
    And Je saisie la description de la tache
    And Je clique sur le bouton Ajout de tache
    Then Je vérifie que le bouton ajout de tache est inactive

  @addTaskDescriptionVide
  Scenario: Se rendre sur le site locale et effectuer le test d ajout d une tache sans description
    When Je saisie le login
    And Je saisie le mot de passe
    And Je clique sur le bouton de connexion
    And La page change
    And Je vérifie que les liens sont affiches "Tâches" "Déconnexion"
    And Je saisie le nom de la tache
    And Je clique sur le bouton Ajout de tache
    Then Je vérifie que le bouton ajout de tache est inactive

  @addTaskDescriptionVide
  Scenario: Se rendre sur le site locale et effectuer le test d ajout d une tache sans description
    When Je saisie le login
    And Je saisie le mot de passe
    And Je clique sur le bouton de connexion
    And La page change
    And Je vérifie que les liens sont affiches "Tâches" "Déconnexion"
    And Je saisie le nom de la tache
    And Je saisie la description de la tache
    And Je clique sur le bouton Ajout de tache
    Then Je vérifie que le bouton ajout de tache est inactive
