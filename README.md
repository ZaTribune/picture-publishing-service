# Picture Publishing Service  
  
An Example for a Spring Boot Web Application.

<p align="center">
  <img src="src/main/resources/static/images/spring.svg" width="200" height="200"/>
</p>
  
## Overview  
The client needs a website where registered and logged in users can upload pictures for acceptance or rejection.  
An administrator will login and review all submissions.  
Accepted pictures will be assigned a URL which can be accessed by all users (without login).  
Rejected pictures have their pictures removed, but the metadata remains.  

## Detailed Requirements  
- End-users can register.  
  - Registration information: email address, password  
- Landing page shows all accepted pictures' URLs  
- NON-logged in users can click on the links to see the pictures  
- Logged in users can upload a picture along with following fields:  
  - description  
  - category  
- only three fixed categories: living thing, machine, nature  
- attachment (up to 2 Mb) (jpg, png, gif only)  
- An administrative user can login to a separate admin page  
- a built-in admin with a username "admin" and password "admin123"  
  - Administrative user sees list of uploaded pictures  
  - list of all uploaded, unprocessed pictures  
  - anything that was accepted or rejected does not show up here  
  - Admin can select a picture to process it  
  - opens a new page showing description, category, picture dimensions, and displays picture  
  - has two buttons "Accept", "Reject"  
  - if "Accept" is pressed, a URL is autogenerated forthat picture, and can bedisplayed on the Landing page  
  - if "Reject" is pressed, the picture file is removed from storage and the data record marked asRejected  

## Nonfunctional Requirements  
- the backend database should be an open source standard SQL variety of PostgreSQL  
- must provide scripts for deployment and running unit tests  

## Expected Deliverables  
- the entire project: code and database  
- instructions on how to deploy it  
- REST API documentation (Swagger preferred but anything clear is fine)

## Steps to deploy
- Just load this project on your preferred IDE e.g. Intellij or Netbeans ...etc and Maven will load all dependencies
  and configure directories.  
- This project uses an embedded "h2 database" so there's no need for a dbms e.g. MySQL or Postgres ...etc  
- There are 2 provided users by default  
  - user: admin@pps.com  
  - password: admin123  
  - role/authority: ADMIN  
  - user: muhammad.ali@pps.com
  - password: user123
  - role/authority: USER 

## Authors  
   **Muhammad Ali Arafah** - find me on : [Twitter](https://twitter.com/ZaTribune), [LinkedIn](https://www.linkedin.com/in/zatribune).    