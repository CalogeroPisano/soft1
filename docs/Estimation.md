# Project Estimation  

Authors:
Stefano Bergia,Calogero Pisano,Concetto Antonino Privitera,Minfang Li

Date:
25/06/2020

Version:2.0

# Contents



- [Estimate by product decomposition]
- [Estimate by activity decomposition ]



# Estimation approach

<Consider the EZGas  project as described in YOUR requirement document, assume that you are going to develop the project INDEPENDENT of the deadlines of the course>

# Estimate by product decomposition



### 

|             | Estimate                        |             
| ----------- | ------------------------------- |  
| NC =  Estimated number of classes to be developed   |    4                         |             
|  A = Estimated average size per class, in LOC       |        200                    | 
| S = Estimated size of project, in LOC (= NC * A) |800|     
| E = Estimated effort, in person hours (here use productivity 10 LOC per person hour)  |     63                                 |   
| C = Estimated cost, in euro (here use 1 person hour cost = 30 euro) |1890 | 
| Estimated calendar time, in calendar weeks (Assume team of 4 people, 8 hours per day, 5 days per week ) |      10              |               


# Estimate by activity decomposition



### 

|         Activity name    | Estimated effort (person hours)   |             
| ----------- | ------------------------------- | 
|Requirement engineering  |20|
|Design|25|
|Coding|24|
|Unit testing|20|
|Integration testing|11|
|Acceptance testing|8|
|Management|2|
|Git maven||


```plantuml
[Requirement engineering] lasts 1 week
[Design] lasts 2 weeks
[Coding] lasts 4 days
[Unit testing] lasts 3 days
[Integration testing] lasts 3 days
[Acceptance testing] lasts 1 week
[Coding CR] lasts 1 day
[Integration testing CR] lasts 1 days
[Acceptance testing CR] lasts 1 day
[Management] lasts 1 days
[Design] starts at [Requirement engineering]'s end
[Coding] starts at [Design]'s end
[Unit testing] starts at [Coding]'s end
[Integration testing] starts at [Unit testing]'s end
[Acceptance testing] starts at [Integration testing]'s end
[Coding CR] starts at [Acceptance testing]'s end
[Integration testing CR] starts at [Coding CR]'s end
[Acceptance testing CR] starts at [Integration testing CR]'s end
[Management] starts at [Acceptance testing CR]'s end
@enduml
```
