Feature: Testare Domino.ro

  Scenario: Log-in Domino.ro
  Given open Domino website
  Then click authentication button
  Then enter email "andreea_rad@icloud" and continue
  Then enter password "Domino123" and continue
  Then click home and search appartments
  Then open localization list
  Then select city
  Then select neighborhood
  Then select compartment and number of rooms
  Then select finish and finished appartments
  Then show results




