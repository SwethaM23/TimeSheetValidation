
Problem Statement : Timesheet
Website           : "https://be.cognizant.com/"
---------------------------------------------------------------------

Project Deliverables:

1) Verify that title of the page (Be.Cognizant) is displayed or not.

2) Collect and Print User Info details User Info in console and report.

3) Display Timesheet & Take the last three week timesheet data and print the same in console and report.

4) Display the information which present in the drop down list.

5) To take screenshot of when it failed


Steps of the Procedure:
----------------------------------------------------------------------

1)  Launch any browser (In this code we have used Chrome browser and Microsoft Edge browser). 
2)  Navigate to “https://be.cognizant.com/”.
3)  Sign-in with your Username and password. 
4)  Get the User information in the console. 
5)  Navigate to One.Cognizant Website. 
6)  In start searching text box type Timesheet and click search icon. 
7)  Click Timesheet option among the listed results. 
8)  The timesheet page is opened, then we need to retrieve the date of previous Saturday and the next Friday and check it with the first row in the                       	timesheet. These steps will be carried out for the 2nd row and 3rd row. 
9)  In the Timesheet page, click the drop-down list search by and select the status option. 
10) Click the status drop down box, select all options and capture the information. 

Folders
----------------------------------------------------------------------

1) src/main/java

	 i)Report
		->ExtentReportManager.java
		->timestamputils.java

       ii)Timesheet
		->BaseUI.java
		->HomePage.java
		->TimeSheetPage.java
		->UserDetails.java
	iii)Utils
		->ExcelWrite
 
2) src/main/resources
	i)properties
		->Config.properties

3) src/test/java
	
	  i)TimeSheetSetup
		->TimeSheetSetup.java

6) Screenshots
	
	  ->Account.png
	  ->HomePage.png
	  ->Search.png
       	  ->Timesheet.png

Data Driven Concepts

-----------------------------------------------------------------------
1) Properties File (Reading Data)

   * (config.properties)- This properties file is present in        

   * This file conists
 
		
		-> websiteURLKey	-Input for URL
		-> email		-Input for email address
		-> password		-Input for account password

Key Automation Scope
-------------------------------------------------------------------------

-> Locating elements precisely.
-> Using appropriate synchronization technique.
-> Extracting menu items & store in collections
-> Scrolling up and down in web page
-> Filling form (in different objects in web page)  
-> Taking Screenshots
-> Printing output in console.
-> Generate Extent Report and TestNG report.


Technology/Automation Tools Used
-------------------------------------------------------------------------
1)  Selenium Webdriver and it's concepts.
2)  Maven
3)  TestNG framework and it's concepts.
4)  Data Driven approach
5)  Page Object Model
6)  TestNG Report
7)  Property file concepts
8)  Multiple Browser testing concepts
9)  Java Concepts
10) Extent Report 


                                  
                                  ----------------------------
                                  |                          |
                                  |      IMPORTANT NOTE      |
                                  |                          |
                                  ----------------------------

    -> For mutiple browsers (chrome and Edge), The brower name is read from 'config.properties' file
    -> If you want to use chrome brower, please go to 'config.properties' file and set browser name as 'chrome'.
    -> If you want to use edge brower, please go to 'config.properties' file and set browser name as 'edge'.
    -> Then execute the Test.

Output:
    Starting ChromeDriver 111.0.5563.64 (c710e93d5b63b7095afe8c2c17df34408078439d-refs/branch-heads/5563@{#995}) on port 54248
Only local connections are allowed.
Please see https://chromedriver.chromium.org/security-considerations for suggestions on keeping ChromeDriver safe.
ChromeDriver was started successfully.
INFO: Detected dialect: W3C
User Details
Profile Name : M, Swetha (Cognizant)
Email Id : 2269363@cognizant.com
Title is validatedBe.Cognizant - Home

Current Week - 17-JUN-2023 To 23-JUN-2023
Previous Week - 10-JUN-2023 To 16-JUN-2023
Before Previous Week - 03-JUN-2023 To 09-JUN-2023

System date and TimeSheet date both are similar for current week
System date and TimeSheet date both are similar for previous week
System date and TimeSheet date both are similar for previous before previous week

Selected dropdown Approved List 
03-JUN-2023 To 09-JUN-2023
Approved
 
27-MAY-2023 To 02-JUN-2023
Approved
 
20-MAY-2023 To 26-MAY-2023
Approved
 
13-MAY-2023 To 19-MAY-2023
Approved
 
06-MAY-2023 To 12-MAY-2023
Approved
 
29-APR-2023 To 05-MAY-2023
Approved
 
22-APR-2023 To 28-APR-2023
Approved
 
15-APR-2023 To 21-APR-2023
Approved
 
08-APR-2023 To 14-APR-2023
Approved
 
01-APR-2023 To 07-APR-2023
Approved
 
25-MAR-2023 To 31-MAR-2023
Approved
 
18-MAR-2023 To 24-MAR-2023
Approved
 
11-MAR-2023 To 17-MAR-2023
Approved
 
04-MAR-2023 To 10-MAR-2023
Approved
 
25-FEB-2023 To 03-MAR-2023
Approved
 
18-FEB-2023 To 24-FEB-2023
Approved
 
Selected dropdown value Approved matched in results
-----------------------------------------------------
Selected dropdown Pending List 
17-JUN-2023 To 23-JUN-2023
Pending
 
Selected dropdown value Pending matched in results
-----------------------------------------------------
-----------------------------------------------------
No results found for Overdue
-----------------------------------------------------
No results found for Partially Approved
-----------------------------------------------------
No results found for Saved
-----------------------------------------------------
No results found for Sent Back for Revision
Selected dropdown Submitted for Approval List 
10-JUN-2023 To 16-JUN-2023
Submitted for Approval
 
Selected dropdown value Submitted for Approval matched in results
-----------------------------------------------------
PASSED: navigationToWebsite
PASSED: details
PASSED: OneC
PASSED: timeSheetNavigation
PASSED: timesheet
PASSED: searchDropDown
PASSED: Status_Approved
PASSED: Status_Pending
PASSED: Status_Overdue
PASSED: Status_PartialApprove
PASSED: Status_Saved
PASSED: Status_Revision
PASSED: Status_submitForApprove

===============================================
    Default test
    Tests run: 13, Failures: 0, Skips: 0
===============================================


===============================================
Default suite
Total tests run: 13, Failures: 0, Skips: 0
===============================================

[TestNG] Time taken by org.testng.reporters.JUnitReportReporter@329dc214: 6 ms
[TestNG] Time taken by [FailedReporter passed=0 failed=0 skipped=0]: 1 ms
[TestNG] Time taken by org.testng.reporters.jq.Main@1f129467: 42 ms
[TestNG] Time taken by org.testng.reporters.SuiteHTMLReporter@2dff7085: 50 ms
[TestNG] Time taken by org.testng.reporters.EmailableReporter2@2bebd114: 10 ms
[TestNG] Time taken by org.testng.reporters.XMLReporter@72ecbcb3: 10 ms

 
     

   