@checkrate
Feature: Check Rate
  Scenario: User checks the shipping rate successfully
    Given the user is already logged in to the application
    When the user clicks the check rates menu
    And the user enters the origin area as "Kedokan Bunder, Indramayu (IYU)"
    And the user enters the destination as "Mampang Prapatan"
    And the user clicks the "Cek Tarif" button
    And the user enters the item weight as "5" kg
    And the user enters the item type as "Dokument / Document"
    And the user selects the delivery method "regpack"
    Then the shipping rate should be displayed correctly

  Scenario: User checks rates for a non-covered destination
    Given the user is already logged in to the application
    When the user clicks the check rates menu
    And the user enters the origin area as "Kedokan Bunder, Indramayu (IYU)"
    And the user enters the destination as "Bintangor, Sarawak"
    And the user clicks the "Cek Tarif" button
    Then the error message "Maaf, area tujuan belum tercakup." should be displayed
