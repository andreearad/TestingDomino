Feature: Testare Domino.ro

  Background:
  Given open Domino website1
  Then aceept cookies and click authentication button
  And enter email "andreea_rad@icloud.com" and continue1
  Then enter password "Domino123" and continue1

  Scenario: enter search criteria
    Given search appartments
    Then categorie filtrare "Localizare"
    Then selectie filtru "Localitate"
    Then filtreaza dupa "Cluj-Napoca"
    Then selectie filtru "Cartier"
    Then filtreaza dupa "Zorilor"
    Then categorie filtrare "Compartimentare si anexe"
    Then selectie filtru "Numar Camere Decomandate"
    Then filtreaza dupa "2"
    Then categorie filtrare "Finisaje"
    Then selectie filtru "Stare Finisaje Interioare"
    Then filtreaza dupa "Buna"
    Then show result

  Scenario: creeare lista fvorite
    Given salveaza cautarea
    And selecteaza apartamentul
    And afiseaza detaliisi adauga la favorite
    Then alege alt apartament si ascunde
    Then ia legatura si proprietarul si raporteaza pret gresit
    Then raporteaza vandut si ascunde
    Then sorteaza crescator anunturile
    Then alege si adauga la favorite


  Scenario: verificare anunturi salvate
    Given acceseaza contul meu
    And sterge anunturile ascunse
    Then sterge cautarea
    Then sterge anunutul favorit
    Then ia legatura cu vanzatorul si raporteaza vandut
