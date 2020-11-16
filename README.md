# WeApp
JoJo Technology's (CSE201 Group 0) App Repository 

WeApp is a repository of applications, which can be understand as a library of applications that is sortable and filterable based on different criteria. 
WeApp is different from platform-specific stores in that it provides more information, includes user discussions, is user-driven, and allows cross-platform comparison.

## Running WeApp by terminal

```
git clone https://github.com/CSE201-Group0-Project/WeApp.git
cd WeApp/WeApp
./mvnw clean install
java -jar target/WeApp-0.0.1-SNAPSHOT.war
```

## Running WeApp by Eclipse
```
In eclipse Project Explorer, right click the project
Select "Run As" -> "Spring Boot App"
```
If "Spring Boot App" option doesn't show up, here is alternative:
```
Select "Run As" -> "Maven Build..." -> In the goals, enter "spring-boot:run" -> click Run button
```

