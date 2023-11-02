
  Feature: Information post  user


    Scenario Outline: Send information post user with response success
      Given I Load customer information
        | name | job |
        | <name>  | <job> |
      When I call Post user API
      Then I should see the status code 201
      And I validate quantity key is 4
      And I validate schema response "PostJsonSchema"
      And I validate fields post response api
      And I validate post response contain data expected

      Examples:
        | name | job |
      ##@externaldata@./src/test/resources/data/Testdata.xlsx@Sheet1@1