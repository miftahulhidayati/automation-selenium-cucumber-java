Feature: Stockbit Login
  As a user I should able to login into Stockbit

  Scenario: I login with valid credential
    Given I navigate to "https://stockbit.com/login"
    And I enter "indlovu" into input field having xpath "//input[@id='username']"
    And I enter "cantik" into input field having id "password"
    When I click on element having id "email-login-button"
    Then I wait 30 seconds for element having class "popavatar"

  Scenario: I try to logout
