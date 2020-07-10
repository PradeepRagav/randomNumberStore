# randomNumberStore
1. Spring boot app : App runs on port 8080
http://localhost:8080/randomNumber
Which takes numbers in a POST method with 
Request body  : 
{ "numbers" : [140,360,389,689,359]}Response : { "lastFiveMinutesNumbers": [ 140, 360, 389, 689, 359 ], "lastTenMinutesNumbers": [ 140, 360, 389, 689, 359 ], "lastThirtyMinutesNumbers": [ 140, 360, 389, 689, 359 ]}
https://github.com/PradeepRagav/randomNumberStore
mvn package
java -jar <path>/assignment/target/assignment-0.0.1-SNAPSHOT.jar

2. Java app :
Prints 5 random numbers per second
https://github.com/PradeepRagav/randomNumberGen

mvn package
java -jar <path>/target/hackernewsapi-0.0.1-SNAPSHOT.jar
