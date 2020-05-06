Feature: Search for schools in the search bar

@DesktopBrowsersTesting
  Scenario Outline: Search for schools in the search bar on Desktop browsers
    Given Launch the browser "<browserName>"
    When User navigate to the LSAC home page
    And User search for "Law School" in the search bar clicking on Search link
    And Click on the search button
    Then It should show the "Law School" in the search results

    Examples: 
      | browserName |
      | Chrome      |
      | Firefox     |

@MobileBrowsersTesting
  Scenario Outline: Search for schools in the search bar on Mobile browsers
    Given Launch the browser on mobile device "<mobileBrowser>"
    When User navigate to the LSAC home page on mobile
    And Click on the menu toggle bar
    And User search for "Law School" in the search bar on mobile
    And Click on the search button on mobile
    And Perform the scroll action on the view
    Then It should show the "Law School" in the search results on mobile

    Examples: 
      | mobileBrowser |
      | MobileChrome  |
      | Safari        |
