@Api @Movie @Regression
  Feature: Get Movie by Search

    @GetBySearch
    Scenario: Get movie by search success
      Given set apikey to '28d2634c'
      Given set search to 'batman'
      When send get by search
      Then get by search response equals with request