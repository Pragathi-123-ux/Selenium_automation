SauceDemoAutomation (Basic)
===========================

This is a ready-to-import Eclipse Maven project that automates an end-to-end purchase flow on https://www.saucedemo.com/.

How to import into Eclipse:
1. Download and unzip the project.
2. In Eclipse: File -> Import -> Existing Maven Projects -> Select the unzipped folder -> Finish.
3. Right-click testng.xml -> Run As -> TestNG Suite.

Notes:
- Uses WebDriverManager to manage ChromeDriver automatically.
- Excel test data is under src/test/resources/testdata.xlsx.
