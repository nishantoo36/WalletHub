Feature: Assignment1

  Background:
    Given Open Url "https://www.facebook.com/"
    Given verify that facebook homepage is opened

  @WebScenarios
  Scenario: Test Login
    When user enter username as "test@testmail.com" and password as "absd@123123"
    When user click on facebook login button
    When Open Url "https://www.facebook.com/"
    When user do post as "Hello world"










