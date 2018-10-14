# selenium-maven-solution

Requirements for running this solution
---------------------------------
  * Install JDK 8 (Java Development Kit), configure JAVA_HOME variable and add it to PATH
  * Install Maven and add it to your PATH
  * Download Chromedriver for your OS (This solution has been tested in Chromedriver 2.35 in Ubuntu 16.04)  
  
Steps to run this solution
--------------------------
  * Clone this repo to your computer to a directory where you have read/write access
  * Change **chromedriver.path** in src/test/resources/config.properties to where you have downloaded Chromedriver
  * Change **ss.path** in src/test/resources/config.properties to where you want screenshots to be saved (Ensure you have write permission for this directory)
  * You can run this solution by running the command in your terminal
  ```console
     mvn clean compile test
```

This solution has been tested on the following environment
  * Selenium 3.5.3
  * Chromedriver 2.53
  * Maven 3.5.2
  * Ubuntu 16.04
