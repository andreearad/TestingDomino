Feature: Testare Domino.ro

  Background:Autentificare si acceptare cookies
  Given deschide site-ul Domino
  Then aceepta cookies si acceseaza autentificarea
  And introduce email "andreea_rad@icloud.com"
  Then introduce parola "Domino123"

  Scenario: Introducere filtre de cautare
    Given cauta apartamente
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

  Scenario: Creeare lista fvorite
    Given salveaza cautarea
    And selecteaza apartamentul
    And afiseaza detalii si adauga la favorite
    Then alege alt apartament si ascunde
    Then ia legatura si proprietarul si raporteaza pret gresit
    Then raporteaza vandut si ascunde
    Then sorteaza crescator anunturile
    Then alege si adauga la favorite


  Scenario: Verificare anunturi salvate
    Given acceseaza contul meu
    And sterge anunturile ascunse
    Then sterge cautarea
    Then sterge anunutul favorit
    Then ia legatura cu vanzatorul si raporteaza vandut
