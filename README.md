# employeePortal - Server

This project consists of backend for the employee portal. There are 3 REST APIs exposed which are used by the UI to save
or get the employee information.

Technologies used: Java, Springboot, JUnit

Setting up the project:
Pre requisits - Java sdk has to be installed. If it is not installed already, 
it can be downloaded from here - https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

Refer the following link to set the JAVA_HOME after installing sdk - 
https://docs.oracle.com/cd/E19182-01/820-7851/inst_cli_jdk_javahome_t/

Steps to set up the server -
1. Clone the project
2. Open the terminal and move to the project folder. Command: cd {project_path}/employeePortal
3. Build the project using the command ./gradlew clean build
   To skip the test cases while building, use ./gradlew clean build -x test
4. Run the server using ./gradlew bootRun <br />
   You will see the following output when the server is up in the terminal: <br />
   2019-06-20 11:40:34.478  INFO 12578 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path '' <br />
   2019-06-20 11:40:34.481  INFO 12578 --- [           main] c.e.e.EmployeePortalApplication          : Started EmployeePortalApplication in 3.636 seconds (JVM running for 3.957) <br />
   <=========----> 75% EXECUTING [19s] <br />
   > :bootRun <br />
5. Once the server is up, the APIs can be accessed in postman/browser/any other application using https://localhost:8080/{API}


   
