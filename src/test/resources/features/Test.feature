@SmokeTest

Feature: Modify name, surname and dob

  Scenario: Test profile page functionality
    Given Open home page
    When Login to my profile page and enter mambetov_a@inbox.lv and testpwd001
    Then Change Artem, Greatest
    And Save the changes




