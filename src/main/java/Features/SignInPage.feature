
Feature: SignIn Page
  Scenario: Correct Login Control
    Given Start Driver and Browser
    When Navigate to lolaflora.com signInPage URL
    And I'm filling registered e-mail address
    And I enter a correct password in the password field
    And I click sign in button
    Then Is Login successful
    And Driver quit

  Scenario: Incorrect Login Control
    Given Start Driver and Browser
    When Navigate to lolaflora.com signInPage URL
    And I'm filling unregistered e-mail address
    And I enter a incorrect password in the password field
    And I click sign in button
    Then Is Login Unsuccessful
    And Driver quit

  Scenario: Required Field Control
    Given Start Driver and Browser
    When Navigate to lolaflora.com signInPage URL
    And I click sign in button
    Then Is there required field warning text for required fields
    And Driver quit

  Scenario: Forgot Password Process Control
    Given Start Driver and Browser
    When Navigate to lolaflora.com signInPage URL
    And I click forgot password button
    And I fill forgot password email address
    And I click forgot password send button
    Then Is forgot password send process success icon enabled
    And Driver quit

  Scenario: SignUp Button Control
    Given Start Driver and Browser
    When Navigate to lolaflora.com signInPage URL
    And I click sign up button
    Then Is the sign up page loaded?
    And Driver quit

  Scenario: SignInWithFacebook Button Control
    Given Start Driver and Browser
    When Navigate to lolaflora.com signInPage URL
    And I click sign in with facebook button
    Then Is the sign in with facebook page loaded?
    And Driver quit



