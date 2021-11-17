package bootcamp;

public class classNote {
    /*
    JAN 5TH, TUESDAY

#1- How do you decide which test cases to automate from your project?

	- repetitive
	- important

	- We cannot and should NOT automate all the test cases.

	1- First of all I would start with automating smoke test suite. (Main functionality of the application)

	2- Datadriven test cases: if I have test cases that are supposed to be tested against multiple test data, I would priotize those.

	3- Business needs:
		- What is urgent
		- What is most used by costumer
		- What is critical for the company

	4- Complex/Time consuming test cases

What I should not be automating:
	- Complex/Time consuming test cases
	- Unstable test/flaky cases: you will never know if your test automation code is breaking or your application is being unstable
	- Visual test cases
	- Unfinished functionality : if there are things chaning with the functionality it should not be automated.


------------------------------------------------------------------------

 Why do you use BDD Framework? How did you decide using BDD Framework?

 	- BDD is extension of TDD. Instead of writing tests we are writing scenarios.
 	- We write SCENARIOS from END USERS perspective.
 	- This framework has 2 sides.
 		- Business side: Feature files where we use Gherkin language to write our scenarios.
 			- Gherkin is very similar to English. Therefore it makes everyone in the team on the same page.
 		- Implementation side:
 			- Where we actually implement the programming logic that automates the application.


----------------------------------------------------------------------

What is POM Design Pattern and why did you decide to use it?
	- POM Design pattern is creating Java classes for each page of the application, and storing related web elements and methods to their classes.

	- First of all, it makes our code REUSABLE. I don't have to repeatedly locate web elements in every single other class.
	- Secondly, EASY TO MAINTAIN. I store 1 webelement in 1 class and it is a lot easier to fix any issue with that web element because I know exactly where everything is stored.
	- Thirdly, is seperating web elements and our test cases. Our test cases will be cleaner therefore easy to manage over all.

----------------------------------------------------------------------

HOW DO YOU USE PAGE OBJECT MODEL? / HOW DID YOU IMPLEMENT POM DESIGN PATTERN?
	- #1 - We initialize the web elements using PageFactory.initElements method
		- We create connection in between our Driver and the object of current class.
		- So when we use the object of the class, the object is already initialized with all the web elements and able to use them.

		PageFactory.initElements(Driver.getDriver(), this);

	- #2 - We use @FindBy annotation to locate web elements.
		@FindBy (xpath = "//something")
		public WebElement exampleBox;


----------------------------------------------------------------------

What are the disadvantages of using POM Design Pattern?
	- "Takes more time in the beginning"
	- To be able to automate test case, we have to create a set of structures and create a logic.
	- Initially it takes more time to create POM Design Pattern.
	- But (converting the disavantage to advantage), in the long run, since we get re-usable WebElements, methods, easy to maintain structure, the ROI(Return on Investment) is a lot bigger.

------------------------------------------------------------------------

How can you only run the failed tests from your framework? What kind of structure you built and how?

	- I use a cucumber plugin that is called "rerun", which allows me to run ONLY failed test cases.

	- How did I achieve that?
		- I created a second runner class (FailedTestRunner) dedicated to running only failed scenarios.
		- Let's say I have 100 tests running in the first run, and 10 of those tests are failed.
		- If we implemented "rerun" structure correctly, all of the failed tests are going to be stored in "rerun.txt"
		- Our "FailedTestRunner" class will be pointing to "rerun.txt", and when we run it, it will only run those failed tests.

--------------------------------------------------------------------------------

-> Why we would want to rerun the failed test cases?
	- If a bunch of tests are failing from a big regression suite, we don't want to rerun the whole suite again.
	-> Therefore we just re-run the failed tests to make sure those tests are actually failing and it is not a synchronization issue.


--------------------------------------------------------------------------------

What is synchronization and how did you achieve it in your framework?
	- Synchronization is making sure our driver and browser are on the same page.
	- Since selenium browser driver is a lot faster compared to the browsers (chrome, firefox etc), we use different types of waits to make sure selenium is synchronized with browsers.

	There are 3 different wait types coming from Selenium Library.
	- All of the 3 waits are waiting for some condition to happen, and will continue when that condition happens.
		- implicitWait: everytime we are trying to locate a web element this method is triggered.
			- by default the value of implicitlyWait is 0.
			- if we set the number to 10 seconds, and our driver is NOT ABLE to find a web element, it will start counting for given seconds.
			- if findELement finds the web element we continue. If not it will throw NoSuchElementException.

		- explicitWait
		- fluentWait

			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)

				   .withTimeout(60, TimeUnit.SECONDS)

			       .pollingEvery(2, TimeUnit.SECONDS)

			       .ignoring(NoSuchElementException.class);

		- both explicit and fluent wait is waiting for explicit condition to happen.
		 	- elementIsDisplayed
		 	- titleIs()
		 	- visibilityOf
		 	- ElementsToBeClickable
		 	- AlertIsPresent
		 	- enable

		- with fluent wait we can adjust the polling time (how often we want to check the page for the condition)

		- There is also Thread.sleep() that is NOT SELENIUM WAIT. It is coming from JAVA library.
		- In some certain situtation where Selenium waits are not working, I use Thread.sleep to be able to continue with execution than I'll try to handle later on.
		- Thread.sleep will hold the whole execution of the code for the given seconds without depending on and type of condition.


--------------------------------------------------------------------------------

What kind of exception is thrown after each one of the wait types?

	- implictlyWait --> NoSuchElementException
	- explicit and fluent --> TimeOutException

- We use implicit wait once, and it will be applied througout the execution of that specific driver's session.

- Explicit wait, we have to create and apply to each and every single case we are handling.


--------------------------------------------------------------------------------

HARD ASSERT VS SOFT ASSERT

	- Only TestNG has soft assert. JUNIT does not have soft assert.

	- What is hard assert and soft assert?
		- Hard assert: will stop the execution of the test when it fails.
		- The line we have the hard assert, if fails, rest of the lines will not be executed.
		- Hard assertion methods are static, therefore we are able to use them without having to create the object of the class.

		Assert.assertEquals(ExpectedStr , ActualStr);

	- What is soft assert?
		- Soft assert: will NOT stop the execution if the assertion fails.
		- Soft assert methods are not static, so we must create the object of the class when we need to use them.
		- Soft assert records the lines where the assertion is done.
		- And it will continue the execution of the test case.
		- Then it will display the recorded result at the very end.

		SoftAssert softAssert= new SoftAssert();
		softAssert.assertTrue(2<1);


How do you decide which assertion you should be using?
	- If the functionality is not very critical I would use soft assert.
	- If the functionality is so important that if that condition is not True the rest of the test is not supposed to be running, then I would use hard assertion.


----------------------------------------------------------------------

Why did you decide to use Selenium but not Protractor, but not...

#1- open source:
	- FREE
	- POPULAR
		- There is a big community using it.
		- Which means, there are many different ways of implementations, and different solutions to almost all of the problems.

#2- maturity:
	- Selenium has been around for a while
	- There has been many different versions and bug fixes on Selenium Library
	- So Selenium is a lot more faster, stable, dependable, reliable compared to what it was before.

#3- opportunities to integrate with other tools.
	- Because it is so popular and used by a lot of different people, we have many different options of implementations for Selenium
	- Supports:
		- Multiple browsers
		- Multiple OS
		- Multiple programming language
		- Parallel testing with Selenium GRID


------------------------------------------------------------------------------------

How do you handle dynamic web elements?
	- We can handle dynamic web elements in two different ways.

#1- We can use the existing xpath methods suchs as

	"starts-with",
	"ends-with",
	"contains"

	and find the attribute part that is not changing.

	abc18237129837123987
	abdi2342834729834723

#2- Finding a static parent or child and moving to desired web element from there.


	<div name="static2">
		<div>
			<div id="fj382934898"> </div>
		</div>
	</div>

	//div[@name='static2']/div/div


------------------------------------------------------------------------

What version of Selenium you are using?
- 3.141.59

------------------------------------------------------------------------

How do you decide which locator you use when you are locating a web element?

	- First I would check for id. If there is id, and it is not dynamic, I would go for id.
	- If not, I would quickly check for it there is unique class attribute value or name attribute value.
	- If it is a link, I would use linkText or partialLinkText
	- If none of the above is working, then I would go for XPATH or CssSelector.


------------------------------------------------------------------------

What are the different types of exceptions you are getting with Selenium, and how do you handle?
	- NoSuchElementException
		1- Locator issue. Check if locator is correct, if not fix the locator.
		2- Synchronization issue. You just want to make sure you proper wait times for all the conditions.
		3- Iframe. If there is iframe on the page, and the web element we are trying to locate is inside of an iframe, even if our locator is correct, we will get NoSuchElementException.
		- To avoid that, we need to switch to the iframe.

	- TimeOutException
		- We get this exception from WebDriverWait class.
		- When we get it, make sure to check the lines where we used explicit waits.
	- StaleElementReferenceException:
		- When there is a change in the DOM (HTML page) such as refresh, back, forward, the driver will lose its reference to specific web elements.
		- We need to refresh the Element Reference by re-locating the web element.
		- Using Page Object Model Design Pattern eliminates StaleElementReferenceException
		- Why? because every time we use web element from POM Design pattern, a "freshness check" is happening.

	- ElementNotVisible
	- ElementNotInteractable
	- NullPointerException
	- NoSuchFile
	- IOException
	- ElementNotClickable
	- NoAlertPresentException
	- NoSuchFrameException
	- NoSuchAttributeException

------------------------------------------------------------------------

What is your tag strategy in Cucumber?
	- I create different testing suites using different tags.
	- We can use multiple tags in the same feature file to have the same feature file be part of different testing suites as well.

	- for ex:

	Feature #1:
		@Smoke @Regression @wip

	- We can use the keywords to include or exclude specific tags from test runtime.
		- and
		- or
		- and not


------------------------------------------------------------------------

How do you scroll on the page to see something specific?
	1- Actions moveToElement method to scroll down to specific web elements.

Do you know any other way to scroll?
	2- We can use JSExecutor.executescript method to scrool up and down, or left and right.

	JSExecutor --> executeScript --> scrollBy(0,250);
	JSExecutor --> executeScript --> scrollIntoView(true), WebElementWeWantToScroll;


------------------------------------------------------------------------

How do you handle WebTables using Selenium?
	- If there is a web table, we can handle it creating custom xpath locators.
	- We can go from parent to child, child to parent etc to locate the web elements that we want to locate.

------------------------------------------------------------------------

How do you handle dynamic web tables?
	- I would create a custom xpath locator, but this time I would consider not using the web elements, or rows, or columns that are dynamic.
	- I would find something static (not-changing), and then create my logic around that.

------------------------------------------------------------------------

What is the difference between XPATH and CssSelector?
	- We can create custom locators with both of these.

	- CSS Selector:
		- Works only one way. We can only go from parent to child using CSS Selector.
		- CssSelector is technically faster than XPATH.

	- XPATH:
		- Works both ways. We can go both from parent to child, and child to parent using XPATH.
		- We can work with displayed TEXTS.
		- Technically XPATH is slower than CssSelector (milliseconds)

------------------------------------------------------------------------

driver.close() vs driver.quit();
	- driver.close();
		- closes only the current window

	- driver.quit();
		- will close all of the windows that has been opened by selenium webdriver.

How do you handle Alerts, iframes, windows?

1- How do you handle Alerts

	2 types of alerts
	#1- HTML ALERT : we can just locate and click as any other web element.
	#2- JS ALert:

	- Alert class that comes from Selenium library.
 	- We create object of it and switch to driver focus to alert.
 	- 3 types of alerts.

		- information : we can only accept() this alert
		- confirmation : we can accept(), and dismiss();
		- prompt : we can accept(), dismiss() and sendKeys();

2- How do you handle iframes
	- Iframe: html inside another html
	- We need to switch selenium focus to iframe
	- We have 3 different ways to switch to iframe.
		- index
		- name, id
		- WebElement : we can locate the iframe with any of the existing attributes and use it as a web element.

	- After switching to iframe, we need to switch back to the default frame to be able to continue with actions in the main frame.

		- driver.switchTo().defaultContent();
		- driver.switchTo().parentFrame();

How do you handle windows?
	- We use window handles for handling windows & tabs.
	- A window handle is a randomly generated unique id for each window.
	- We can use WindowHandles to switch in between different windows.

	driver.getWindowHandle(); --> will return current window handle
	driver.getWindowHandles(); --> will return all of the currently opened windows' handles.

TouchActions: Implements actions for touch enabled devices, reusing the available composite and builder design patterns from Actions.


------------------------------------------------------------------------------

Tell me about your framework?

#1----------
- cucumber, bdd
- pom
- java
- selenium webdriver
- maven
	- pom.xml
	- folder structure
		- pages
			- PageFactory
			- FindBy
			- inheritance
			- basepage
		- runners
			- cucumberRunner
			- failedRunner
		- step_definitions
			- snippets
			- implementations
			- Hook
				- Junit
				- ScreenShot
		- utilities package
			- driver
			- config_reader

		- features
			- gherkin
			- scenario outlines -> data driven

		- pom.xml
			- libraries
			- plugins
				- cucumber_reporting

			- dependencies
				- selenium
				- javafaker
				- webdriver manager etc



#2---------------------

- pom design pattern
- packages
	- pages
		- webelements/locators
		- class for each page
	- runners
		- cukesRunner
			- reports
		- failedTestRunner
		- smokeRunner
		- RegressionRunner
	- step_definitions
		- implementations
		- hooks
	- utilites
		- Driver
		- ConfigReader
		- UtilitiesClass: repeated methods
	- resources
		- features
			- .feature files: to implement Cucumber
			- implementing feature files in step_defs classes
	- configuration.properties
		-url

- maven
	- pom.xml
		- libraries/jar.files
			- selenium
			- cucumber-junit
			- javafaker
		- plugin
			- maven surefire


#3 ------------------------

	- Intellij
	- Java
	- Selenium
	- BDD, Cucumber
	- Data Driven -> getting data from excel
	- POM Design Pattern
		- created class for each page of app
		- easy to maintain
		- reusable
	- Singleton
	- Java OOP
	- Cucumber-Junit
	- JDBC
	- API testing with RestAssured
	- Github
	- Continious Integration -> Jenkins
	- AWS
	- json reports
	- html reports
	- maven
	- pom.xml
		- dependencies
		- plugins
	- pages
	- runners
		- cukesRunner
		- failedRunner -> rerun.txt
	- utils
	- configuration.properties
	- feature files
		- gherkin language
		- tags for creating suites
	- step_definitions
		- implementation of features


-----------------------------------

#4-
	- java
	- selenium
	- BDD
	- features -> gherkin language
	- pom.xml
	- junit/testNG
	- RestAssured -> API
	- JDBC -> DB
	- POM design pattern
	- Singleton Design Pattern -> Driver utils
	- Runner classes
	- Hook
		-screenshot
		-beforemethod/aftermethod/dbConnections
	- configuration.properties
	- github
	- CI/CD


-----------------------------------

5-
	- IntelliJ
	- Selenium -> browser automation
	- Maven
	- Cucumber
	- Jenkins
	- POM Design Pattern
	- Feature files
		- Gherkin: easy to understand
	- Utils package
	- Reporting
		- cucumber html report, jenkins
	- Git
	- JUnit for assertions
	- BDD, cucumber, feature files
	- Runner class for running tests
	- Hook implements Before/After Tests,
		- TakesScreenShot
	- DataDrivenTesting : ApachePOI



--------

TELL ME ABOUT YOUR FRAMEWORK
    - This question wants to hear:
        - Different types of tools you used in your framework
        - What programming language you used
        - Did you use and Built Automation Tool
        - Did you use any design patterns
        - Did you implement any reporting tools
        - Did you read data from any external file (could be for credentials, could be for Data Driven Testing), how did you read it.
    - JAVA
    - SELENIUM
    - CUCUMBER
    - JUNIT/TESTNG
    - MAVEN
    - APACHE POI
    - POM DESIGN
    - SINGLETON
    - POSTMAN
    - JDBC
    - JENKINS
    - RESTASSURED
    - HTML REPORT
    - INTELLIJ
    - POJO
    - CONFIGURATION PROPERTIES
    - APPIUM
    - AWS
    - JIRA
    - DOCKER
    - SQL DEVELOPER
    - Selenium GRID

---------------

- I used Java as my programming language
- I used Selenium as my test automation tool, to automate browser
- I used Maven as my built automation tool. Which has pom.xml file that allows me to manage dependencies and
     control the versions of the tools that I am using.
- As a unit testing tool, I used JUNIT with Cucumber to make my framework Behavior Driven Development.
- I used Page Object Model Design Pattern to manage, and simplify maintaining my framework.
- Because the POM design pattern helps locating the web elements only once and makes it easier to find them when we
   need to update/change any information.
- I created Singleton design pattern for my driver, so that my framework is always passing the exact same instance of
my driver in the same runtime.
- I created a configuration.properties file where I store the "imporant" test data so that I can reach them from one place.
    - DDT/Not Hardcoding : we are able to seperate our test data from our tests. So that we are not hardcoding our data.
        - browserType
        - username
        - password
        - environment
- I also created a utility class which is reading from the .properties file that I use.
    Business side:
- I implemented BDD approach to simplify reading and understanding  my framework for the rest of the team (non-technical
 people in the team)
-- I write my test cases in "scenarios" which are in Gherkin language, which is almost exacly like English so that everyone
     is able to understand
    Implementation side:..
- I implemented the actual code in the step_definitions classes so that they are seperated from the rest of the framework
- I trigger my framework from my Runner class.
- Which is able to accept different types of Tags so that I can run different test suites.
- I also implemented a logic where if  any of the tests are failing my code will be taking a screenshot and adding it into the report.
- I used JDBC for DB.
- I used RestAssured for API testing



     */
}
