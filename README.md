# WeApp
JoJo Technology's (CSE201 Group 0) App Repository 

WeApp is a repository of applications, which can be understand as a library of applications that is sortable and filterable based on different criteria. 
WeApp is different from platform-specific stores in that it provides more information, includes user discussions, is user-driven, and allows cross-platform comparison.

# Group Members 
- Amy Nguyen 
- Zhuoyue Sun
- Xiaocheng Kang
- Jiahao Zhang

## Running WeApp by terminal

```
git clone https://github.com/CSE201-Group0-Project/WeApp.git
cd WeApp/WeApp
./mvnw clean install
java -jar target/WeApp-0.0.1-SNAPSHOT.war
```

## Running WeApp by Eclipse

1. On the command line 

```
git clone https://github.com/CSE201-Group0-Project/WeApp.git
```
2. Inside Eclipse or Spring Tool Suite IDE
```
File -> Import -> Maven -> Existing Maven project
```

3. In STS, right click the project in project explorer 
```
Select "Run As" -> "Spring Boot app"
```
4. In Eclipse, right click the project in project explorer 
```
Select "Run As" -> "Maven Build..." -> In the goals, enter "spring-boot:run" -> click Run button
```

## Necessary prerequisites for Windows
1. Run Command Prompt as administrator
2. Set the value of the environment variable to your JDK installation path as follows:
```
setx -m JAVA_HOME "C:\Progra~1\Java\jdk1.8.0_XX"
echo %JAVA_HOME%
```
