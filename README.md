# Test Automatin Framework based on Java Spring and TestNg

Demo How to use Spring boot + Test NG in Automation testing:

 - to generate java client from swagger use command:

mvn clean compile

 - Example of using:

mvn package

java -jar target\test-sbtg-1.0-SNAPSHOT.jar testng2.xml

 - for parallel execution:
 
java -jar target\test-sbtg-1.0-SNAPSHOT.jar testngParallel.xml

*note1: some ideas from https://www.baeldung.com/spring-boot-rest-client-swagger-codegen

*note2: set folder where client' classes are generated as a source folder

Image For Docker can be organized in way discribed at: https://docs.docker.com/language/java/build-images/
