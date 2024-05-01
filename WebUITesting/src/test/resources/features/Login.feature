Feature: Testing SauceLabs Demo Website login feature
  Scenario: Login with valid credentials
    Given I launch the SauceLabs demo website
    When I enter the username "<username>" and password "<password>"
    And I click on the Login button
    Then I should be logged in successfully
    Then I should be able to log out from the application
    Then I close the browser

    Examples:
      | username         					| password     |
      | standard_user    					| secret_sauce |
#     | problem_user              | secret_sauce |
#		  | performance_glitch_user   | secret_sauce |
#		  | error_user                | secret_sauce |
#		  | visual_user               | secret_sauce |

	Scenario: Login with locked_out_user or incorrect credentials set
    Given I launch the SauceLabs demo website
    When I enter the username "<username>" and password "<password>"
    And I click on the Login button
    Then I should view the login error message "<login_error_message>"
    Then I close the browser

	  Examples:
		  | username                  | password        | login_error_message |
		  | locked_out_user           | secret_sauce    | Epic sadface: Sorry, this user has been locked out. |
		  | incorrect_username        | secret_sauce    | Epic sadface: Username and password do not match any user in this service |
		  | standard_user             | incorrect_pass  | Epic sadface: Username and password do not match any user in this service |
		  |                           |                 | Epic sadface: Username is required |
		  | standard_user             |                 | Epic sadface: Password is required |
		  |                           | secret_sauce    | Epic sadface: Username is required |