#!/bin/bash
echo 'Running script'
git clone https://github.com/CSE201-Group0-Project/WeApp.git
echo 'Finished cloning project'
cd WeApp/WeApp
echo 'Run maven wrapper'
./mvnw clean install
echo 'Run war file'
java -jar target/WeApp-0.0.1-SNAPSHOT.war
