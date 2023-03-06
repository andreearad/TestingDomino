Feature: Testare Domino.ro

  Background: log-in Domino.ro
  //  Given open Domino website
  //  And click authentication button
  //  Then enter email "andreea_rad@icloud.com" and continue
  //  Then enter password "Domino123" and continue
  // urmeaza sa revin si sa modific scenariul 1



  Scenario: Log-in Domino.ro and enter search criteria
  Given open Domino website
  And click authentication button
  Then enter email "andreea_rad@icloud.com" and continue
  Then enter password "Domino123" and continue
  And click home and search appartments
  Then open localization list
  Then select city
  Then select neighborhood
  Then select compartment and number of rooms
  Then select finish and finished appartments
  Then show results


Scenario: make a favorite list
  Given click on appartemnt
  And open the details and add to favorite
  Then go back and click on another
  Then get the owners phone numer and report as sold
  Then find another appartemnt and favorite
  Then go to favorites list
  Then select favorite appartment

