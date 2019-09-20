Instructions to download project from GitHub:
- Used Google-Chrome browser to upload the project to GitHub so I request recipient(s) to use in the same browser for easy access. 
- Also, I have made the project visibility to the public for a hassle-free experience.

1. Click the link in a browser https://github.com/medamonis/automation-service-initial-version
2. Click on 'Clone or download' green button at right-side middle of the page.
3. Next, click on 'Download zip', which saves to the local machine.
4. Unzip the project file to see it's content. 


Project Info:
Prerequisites:
-	Chrome Browser of version 7.0

Technologies Used:
-	Java version 8.0
-	Selenium version 3.141.59
- TestNG

Observations noticed in the application:-

In the 'CreateAccount' page:-
-	Data in the 'Email' field (which is auto populated) is editable.
-	Most of the fields accepts only spaces & app do not prompt any error, few of the fields are:'First Name', 'Last Name', 'FirstName under Address', 'LastName under address', 'Address field', 'Mobile Phone' etc.,
-	Noticed typo in the error message when an invalid password is given i.e., 'password' as 'passwd'
-	When 'Country' field is changed to '-' & clicked 'Register' button, noticed 3 error messages (instead one appropriate error would have been displayed).
-	When Country is chosen as '-', 'State' and 'PostalCode' fields are getting disappeared. (Since country is a mandatory field, there shouldn't be a none or - option to select which makes state and postalcode fields to get disappear.
-	Though 'Mobile Phone' field is stated as Mandatory with * mark, app do not prompt any error when trying to register without inputting mobile phone.
- 	Though user inputs decimal number in 'Mobile Phone' field, app do not prompt any error message.
-	The alignment of hint message "You must register at least one phone number" is not proper, would be better if it is beside or in between Mobile & Home phone number fields.
- 	Regarding phone number fields, would be better if either of them i.e., hint or * mark are displayed instead of both.
-	Also Min length is not defined for the Mobile & Home Phone number fields (app accepts even if user enter 1 digit)



