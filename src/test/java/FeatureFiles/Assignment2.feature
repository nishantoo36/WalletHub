Feature: Assignment2

  Background:
    Given Open Url "https://wallethub.com/profile/test-insurance-company-13732055i"
    Given verify that homepage is opened

  @WebScenarios
  Scenario: Test Login
      When user click on login button
      Then verify that login page open
      When user enter username as "test@testmail.com" and "abcd@123124"
      When Open Url "https://wallethub.com/profile/test-insurance-company-13732055i"
      When user hover on <4> star
      Then verify that first <4> stars inside get lit up when you hover over on <4> one star
      When user give <4> star review
      Then verify that <4> star review displayed on write review form
      When user select health insurance from drop down "Health Insurance" on review form
      When user write review as "This is just a testing review I submitted to test the automation developed by me so please kindly ignore it, Also application is really awesome"
      When user submit review form
      When Open Url "https://wallethub.com/profile"
      Then Verify reviewed star count as <4>
      Then Verify selected dropdownValue as "Health Insurance"







