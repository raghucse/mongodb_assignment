# mongodb_assignment

## Pre-requisites  
java oracle jdk 18  
Maven 

## How to compile and Package</br>
1. Clone the project from git
2. Run 'mvn clean package' under folder when pom.xml is present using terminal
3. Executable with dependencies will be generated under target folder

## Running the executable</br>

**Use following command to run from a json file** </br>
cat sample.json | java -jar jsonformatter-1.0-RELEASE-jar-with-dependencies.jar  
***or***  
echo "{\\"a\\": {\\"b\\": 1}}" | java -jar jsonformatter-1.0-RELEASE-jar-with-dependencies.jar   

note: latest executable is included under /executable

## Running test cases</br>
Run 'maven test' under folder when pom.xml is present using terminal
