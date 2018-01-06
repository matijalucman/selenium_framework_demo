## Selenium framework demo project

#### Examples of gradle commands for test execution:

* Run all tests in testng.xml suite:

``` java
gradlew runTests
```

* Run tests filtered by Cucumber option:

``` java
gradlew runTests -Pcucumber.options="some Cucumber switch"
```
More informations about Cucumber switches can be found [here](https://cucumber.io/docs/reference/jvm#list-configuration-options).

* Run tests filtered by TestNG groups:

``` java
gradlew runTests -Pgroups=someGroups
```
* Run tests with different profiles:

``` java
gradlew runTests -Pprofile=someProfile
```
* Run tests with excluded one or more browsers:

``` java
// browser options can be CH, FF or IE
gradlew runTests -PexcludeBrowsers=browserOptions
```
Third party reports used in this project:
* [TestNGExtentsReport](https://github.com/email2vimalraj/TestNGExtentsReport)
* [CucumberExtentReporter](https://github.com/email2vimalraj/CucumberExtentReporter)

Reports are really great, I certainly recommend them.