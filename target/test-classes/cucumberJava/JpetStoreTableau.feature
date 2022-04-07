# language: en

  Feature: acceder et se conencter à l'application jpetstore

    Background:
      Given J'instancie le navigateur "chrome"

      Scenario Outline: se connecter à l'application et verifier y etre connnecter
        When j'arrive sur l'url  "https://petstore.octoperf.com/actions/Catalog.action"
        When J'accede à la page de connexion
        And je me connecte avec l'identifiant <login> et le password <password>
        Then je verifie que je suis connecté en tant que l'utilsateur <name>


        Examples:
          | login  | password | name  |
          | "j2ee" | "j2ee"   | "ABC" |
          | "ACID" | "ACID"   | "ABC" |