Feature: Testing SauceLabs Demo Website homepage feature

  Scenario: Sort the displayed products at home page
    Given I launch the SauceLabs demo website
    When I enter the username "<username>" and password "<password>"
    And I click on the Login button
    Then I should be able to sort the displayed products by name A-Z
    Then I should be able to sort the displayed products by name Z-A
    Then I should be able to sort the displayed products by price low to high
    Then I should be able to sort the displayed products by price high to low
    Then I close the browser

    Examples:
      | username         					| password     |
      | standard_user    					| secret_sauce |
