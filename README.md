# Three Card Poker [![Three Card Poker CI](https://github.com/atimalsina2024/three-card-poker/actions/workflows/ci.yml/badge.svg)](https://github.com/atimalsina2024/three-card-poker/actions/workflows/ci.yml)

This is a simple full stack 3 Card Poker application built to demonstrate SDET skills across unit testing, API testing and UI Automation

## [View Live Allure Report](https://atimalsina2024.github.io/three-card-poker/)


## Technical Stack
### |Layer|Technology|
|------|--------------|
|Row 1 Backend|Row 1 Java 17, Spring Boot 3.2|
|Row 2 Game Logic| Row 2 Custom HandEvaluator Service|
|Row 3 Frontend| Row 3HTML5, Javascript, Fetch API|
|Row 4 Unit Tests| Row 4 JUnit 5, parameterized tests|
|Row 5 API tests| Row 5 REST Assured, JSON Schema validation|
|Row 6 UI Automation| Row 6 Selenium WebDriver, TestNG, Page Object Model|
|Row 7 Reporting|Row 7 Allure Reports|
|Row 8 CI/CD| Row 8 GitHub Actions|
|Row 9 Build Tool| Row 9 Maven|

## Test Strategy
### Unit Tests
- JUnit 5: 3 Test scenarios for Card, 6 scenarios for Deck and  6 scenarios for HandEvalutor. HandEvaluator was thoroughly tested using @ParameterizedTest supplying test data using @MethodSource. 

### API Tests
- REST Assured: Tested Response statusCode for negative and positive scenarios for all API end points. Also validated contents on response body and validated response schema

### UI Tests
- Selenium + TestNG : Tested DealHand feature and HandRank feature. POM used to seperate Test Layer and Page Object and Action layer. Used explicit waits to decrease flakiness of the test. Used Allure annotations to make results readable. 

## Running locally

### Prerequisites
- Java 17
- Maven 3.9+
- Chrome browser
- Allure CLI (`brew install allure`)

### Start the application
```bash
mvn spring-boot:run
```
Open `http://localhost:8080` in your browser.

### Run unit tests
```bash
mvn test
```

### Run API tests
```bash
mvn test -Dtest=DealApiTest,EvaluateApiTest,EvaluateApiNegativeTest
```

### Run UI tests
Run from STS: right-click `testng-suite.xml` → Run As → TestNG Suite
(Requires Spring Boot app running)

### Generate Allure report
```bash
allure serve allure-results
```