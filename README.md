# 📱🧪 Appium – Selenium – Cucumber Automation Framework

This project is an automation testing framework built using **Java**, **Appium**, **Selenium**, and **Cucumber**.  
It supports automated testing for **mobile** applications using a **BDD (Behavior-Driven Development)** approach with **Gherkin** syntax.

---

## 🚀 Features

- Mobile automation (Android) using **Appium**
- Web automation using **Selenium WebDriver**
- Test scenarios written in **Cucumber (Gherkin)**
- **Page Object Model (POM)** implementation
- Tag-based test execution
- Cucumber HTML reports

---

## 🧩 Tech Stack

| Component | Technology |
|----------|-----------|
| Language | Java |
| Mobile Automation | Appium |
| Web Automation | Selenium WebDriver |
| BDD | Cucumber |
| Build Tool | Maven |
| Test Runner | JUnit |

---

## 🛠️ Installation & Setup

### 1. Install Requirements
Make sure you have installed:

- Java 11
- Maven
- Android SDK
- Appium Server
- Node.js
- IDE (IntelliJ, VSCode, Eclipse)

### 2. Install Appium
```bash
npm install -g appium
appium -v
```

### Start Appium Server
```bash
appium
```

### Device Configuration
Android: Enable Developer Options and USB Debugging <br>
APK: The APK must be downloaded manually on playstore (Lion Parcel), or you may configure the installation process in the Hooks file.

---

## ▶️ Running Tests

Run all tests
```bash
mvn clean verify
```

Run tests by tag
```bash
mvn clean test -Dcucumber.filter.tags="@regression"
```

## 📚 Test Reports
After execution, Cucumber reports are available at:
```bash
/target/cucumber-reports-html/cucumber-html-reports/features-overview.html
```

## 📚 Test Reports
After execution, Cucumber reports are available at:
```bash
/target/cucumber-reports-html/cucumber-html-reports/features-overview.html
```

### 📹 Test Execution Video

To view the video of the test execution, please refer to the following file:

video-recording.mov

This file contains a complete recording of the automation run, which can help in reviewing and verifying the test results.
