Feature: ToDo Tracker

  Scenario: Full Task Flow

    Given User opens the application
    When User creates tasks from Excel
    And User updates a task
    And User marks task as complete
    And User calculates total duration
    Then Total duration should be displayed
    And Countdown should be visible
    And User deletes a task