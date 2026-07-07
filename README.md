# Three Card Poker [![Three Card Poker CI](https://github.com/atimalsina2024/three-card-poker/actions/workflows/ci.yml/badge.svg)](https://github.com/atimalsina2024/three-card-poker/actions/workflows/ci.yml)

This is a simple full stack 3 Card Poker application built to demonstrate SDET skills across unit testing, API testing and UI Automation

## [View Live Allure Report](https://atimalsina2024.github.io/three-card-poker/)


## Technical Stack

| Layer | Technology |
|-------|------------|
| Backend | Java 17, Spring Boot 3.2 |
| Game Logic | Custom `HandEvaluator` Service |
| Frontend | HTML5, JavaScript, Fetch API |
| Unit Tests | JUnit 5, Parameterized Tests (`@ParameterizedTest`, `@MethodSource`) |
| API Tests | REST Assured, JSON Schema Validation |
| UI Automation | Selenium WebDriver, TestNG, Page Object Model (POM) |
| Reporting | Allure Reports |
| CI/CD | GitHub Actions |
| Build Tool | Maven |

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
