

## UniteUs UI Automation
UI automation to test the provider search functionality of Unite US resource directory website/portal.

The tests executes as a filter search by service provider name by partial text search


## How to execute test
Process #1 
* Go to `/UniteusUIAutomation/src/main/java/com/uniteus/uiautomation/UniteusUIAutomation/test/ProvidersFilterTest.java`, that holds testcases
* Right click on file name in Package Explorer and `run as` TestNG Test

Process #2
 * Right click on  `testNG.xml`, that holds test class(es) name to be executed

Process #3
 * execute mvn command from command line
 `mvn clean test -DsuiteXMLFile=testNG.xml`


## Framework
This is a Maven project and framework consist of following JARs:
  * Selenium
  * TestNG
  * extentreport
  * Java 1.8+

### Structure
This project is your standard Maven Java project with `src` folders, `testNG.xml` and `POM.xml`.

### Models
`src/main/java/model` represents UI screen properties equivalent to respective page objects. 
Each model consist of UI elements with respect to their unique locators, with an impertaive assertion of element to be enabled or displayed in order to make sure of accessibility during test run. 
Models contains representation of entities like ProviderCard, ProviderFilter etc.

### Properties
`src/main/resources/configs/runConfig.properties` is a simple properties file to store various common configurations that are required by any/all tests to be executed.
`src/main/resources/drivers` consist of drivers for each browser. Currently it contains only `Chrome` driver, but `firefox`, `IE`, `Safari`, or `Netgear` drivers can be included here. 
`src/main/testdata/testdata.properties` consist of testdata like partial text search on provider name. 

### Tests
`src/main/java/BasicSetup.java` is the tests superclass for configuration and common code
`/UniteusUIAutomation/src/main/java/com/uniteus/uiautomation/UniteusUIAutomation/test/ProvidersFilterTest.java` holds test classes (TestNG)

### Reports
extentreports get generated as soon as the test are run. Test results are saved insidee `test-output` directory under root. 
HTML file is generated for each run with prefix `testReport-` followed by date and time of the run. 

 
