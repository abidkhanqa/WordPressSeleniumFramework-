# WordPressSeleniumFramework

# Technologies used in Framework:
1.	Selenium
2.	Java
3.	TestNG
4.	Maven
5.	ExtentReport


Details: This is simple robust Selenium with Java Automation framework. It will generate a extent report with test results. The framework is easily customizable and controllable to a project’s need from config.properties file.
Using the config.properties file which can be found in src/test/resources you can execute tests in chrome and firefox. (More browser support can easily be added) You may also change the environment url and credentials as needed.

# Pre-requisites: 
Must have either Chrome or Firefox browser (Any Version)


# How to use this framework?

1.	Clone the repository to your workspace
2.	Open the config.properties change any configuration needed. You may use the dummy credentials already in the file (Note WordPress may restricted or block account for multiple attempts of automation runs on their site.) 
3.	Run the testng.xml file


Once the execution has finished refresh the proc and the html extent report will be generated under Reports folder which is located at the project root.
