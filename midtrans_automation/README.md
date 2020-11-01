# SeleniumJavaPOM
This is sample framework for Android Test using Seleium Cucumber and Java


## 1. Please Checkout this project into your local system
## 2. Installation (pre-requisites)

1. Make sure JDK 1.8+ is installed (make sure Java class path is set)
2. Maven is installed (make sure .m2 class path is set)
3. Import project in any IDE like Eclipse/Intellij

## 3. Test Data Prepration and Assumption:
### Assumption: 
1. These Browser test will only run on Chrome browser and Firefox browser
2. Implemented two flow for puchase one us success and fail

### Test Data Prepration:
 config.properties (\profiles\config.properties)
 # if you want to change the browser so change the value for variable browser to firfox or Chorome in config.properties


## 4. For Running Tests:

1. Download this repository to your local machine
2. **Using Command Line :** Open Command Prompt and Navigate to folder midtrans_automation folder and run command : mvn clean test, it will execute the tests and generate the reports in folder : target/cucumber-report-html.html.
4. **Using Cucumber Runner Class :** right click of TestRunner/Debugger.java class and run as > Junit test.
5. **Using Features files :** select Purchase.feature feature file and right click select run as > cucumber feature file

