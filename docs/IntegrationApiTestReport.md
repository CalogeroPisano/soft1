# Integration and API Test Documentation

Authors: 

Date:

Version:

# Contents

- [Dependency graph](#dependency graph)

- [Integration and API Test Documentation](#integration-and-api-test-documentation)
- [Contents](#contents)
- [Dependency graph](#dependency-graph)
- [Integration approach](#integration-approach)
- [Tests](#tests)
  - [Step 1](#step-1)
  - [Step 2](#step-2)
  - [Step 3](#step-3)
  - [Step n API Tests](#step-n-api-tests)
- [Scenarios](#scenarios)
  - [Scenario UCx.y](#scenario-ucxy)
- [Coverage of Scenarios and FR](#coverage-of-scenarios-and-fr)
- [Coverage of Non Functional Requirements](#coverage-of-non-functional-requirements)
    - [](#)

- [Tests](#tests)

- [Scenarios](#scenarios)

- [Coverage of scenarios and FR](#scenario-coverage)
- [Coverage of non-functional requirements](#nfr-coverage)



# Dependency graph 

   
   ```plantuml 
@startuml

Class UserController 
Interface UserService
Class UserServiceImpl
Class UserRepository
Class UserDto
Class UserEntity

Class LoginDto

Class IdPw

Class GasStationController
Interface GasStationService
Class GasStationServiceImpl
Class GasStationRepository
Class GasStationDto
Class GasStationEntity

UserController --> UserService
UserService --> UserServiceImpl
UserServiceImpl --> UserRepository
UserServiceImpl --> LoginDto
UserServiceImpl --> IdPw
UserRepository --> UserEntity
UserServiceImpl --> UserDto

LoginDto -[hidden] UserEntity
IdPw -[hidden] UserDto

GasStationController --> GasStationService
GasStationService --> GasStationServiceImpl
GasStationServiceImpl --> GasStationRepository
GasStationServiceImpl --> UserRepository
GasStationRepository --> GasStationEntity
GasStationServiceImpl --> GasStationDto

@enduml
```
     


# Integration approach

    bottom up
    step 1: User,  UserDto , loginDto, GasStation,GasStationDto
    step 2: UserRepository, GasStationDto
    step 3: UserServiceImpl , GasStationServiceImpl


#  Tests

   <define below a table for each integration step. For each integration step report the group of classes under test, and the names of
     JUnit test cases applied to them>

## Step 1
| Classes  | JUnit test cases |
|--|--|
|User|UserTests.testsetUserId|
||UserTests.testgetUserId|
||UserTests.testgetUserName|
||UserTests.testsetUserName|
||UserTests.testgetPassword|
||UserTests.testsetPassword|
||UserTests.tesgetEmail|
||UserTests.testsetEmail|
||UserTests.testsetReputation|
||UserTests.testgetReputation|
||UserTests.testsetAdmin|
||UserTests.testgetAdmin|
|UserDto|UserDtoTests.testsetUserId|
||UserDtoTests.testgetUserId|
||UserDtoTests.testgetUserName|
||UserDtoTests.testsetUserName|
||UserDtoTests.testgetPassword|
||UserDtoTests.testsetPassword|
||UserDtoTests.tesgetEmail|
||UserDtoTests.testsetEmail|
||UserDtoTests.testsetReputation|
||UserDtoTests.testgetReputation|
||UserDtoTests.testsetAdmin|
||UserDtoTests.testgetAdmin|
|LoginDto|LoginDtoTests.test_LoginDtoUserID1|
||LoginDtoTests.test_LoginDtoUserID2|
||LoginDtoTests.test_LoginDtoUserID|
||LoginDtoTests.test_LoginDtoUserName|
||LoginDtoTests.test_LoginDtoToken|
||LoginDtoTests.test_LoginDtoUserEmail|
||LoginDtoTests.test_LoginDtoUserReputation1|
||LoginDtoTests.test_LoginDtoUserReputation2|
||LoginDtoTests.test_LoginDtoUserReputation3|
||LoginDtoTests.test_LoginDtoUserAdmin|
|ldPwTests|ldPwTests.test_IdPwUser|
||ldPwTests.test_IdPwPassword|
|GasStation|GasStationTests.testReportDependability|
||GasStationTests.testGasStationId|
||GasStationTests.testGasStationName|
||GasStationTests.testGasStationAddress|
||GasStationTests.testHasDiesel|
||GasStationTests.testHasSuper|
||GasStationTests.testHasSuperPlus|
||GasStationTests.testHasGas|
||GasStationTests.testLat|
||GasStationTests.testLon|
||GasStationTests.testDieselPrice|
||GasStationTests.testSuperPrice|
||GasStationTests.testSuperPlusPrice|
||GasStationTests.testGasPrice|
||GasStationTests.testReportUser|
||GasStationTests.testReportTimestamp|
||GasStationTests.testMethanePrice|
||GasStationTests.testHasMethane|
||GasStationTests.testCarSharing|
|GasStationDto|GasStationDtoTests.testReportDependability|
||GasStationDtoTests.testGasStationId|
||GasStationDtoTests.testGasStationName|
||GasStationDtoTests.testGasStationAddress|
||GasStationDtoTests.testHasDiesel|
||GasStationDtoTests.testHasSuper|
||GasStationDtoTests.testHasSuperPlus|
||GasStationDtoTests.testHasGas|
||GasStationDtoTests.testLat|
||GasStationDtoTests.testLon|
||GasStationDtoTests.testDieselPrice|
||GasStationDtoTests.testSuperPrice|
||GasStationDtoTests.testSuperPlusPrice|
||GasStationDtoTests.testGasPrice|
||GasStationDtoTests.testReportUser|
||GasStationDtoTests.testReportTimestamp|
||GasStationDtoTests.testMethanePrice|
||GasStationDtoTests.testHasMethane|
||GasStationDtoTests.testCarSharing|




## Step 2
| Classes  | JUnit test cases |
|--|--|
|UserRepository|UserRepositoryTests.setupUser|
||UserRepositoryTests.test_verifyCredentials|
||UserRepositoryTests.test_verifyEmail|
||UserRepositoryTests.test_changeReputation|
||UserRepositoryTests.test_updateUsr|
|GasStationRepository|GasStationRepositoryTests.test_updateGasStation|
||GasStationRepositoryTests.test_verifyLatLon|
||GasStationRepositoryTests.test_setGasPrice|
||GasStationRepositoryTests.test_setDieselPrice|
||GasStationRepositoryTests.test_setMethanePrice|
||GasStationRepositoryTests.test_setSuperPrice|
||GasStationRepositoryTests.test_setSuperPlusPrice|
||GasStationrepositoryTests.test_setPremiumDieselPrice|
||GasStationRepositoryTests.test_setUserId|
||GasStationRepositoryTests.test_setTimestamp|

## Step 3
| Classes  | JUnit test cases |
|--|--|
|GasStationServiceImp|GasStationServiceimplTest.testGasStationFromDto|
||GasStationServiceimplTest.testGasStationToDto|
||GasStationServiceimplTest.testdistance|
||GasStationServiceimplTest.testgetGasStationById|
||GasStationServiceimplTest.testsaveGasStation|
||GasStationServiceimplTest.testgetAllGasStations|
||GasStationServiceimplTest.testdeleteGasStation|
||GasStationServiceimplTest.testgetGasStationsByGasolineType|
||GasStationServiceimplTest.testgetGasStationsByProximity|
||GasStationServiceimplTest.testgetGasStationsWithCoordinates|
||GasStationServiceimplTest.testgetGasStationsWithoutCoordinates|
||GasStationServiceimplTest.testsetReport|
||GasStationServiceimplTest.testgetGasStationByCarSharing|
|UserServiceImp|UserSeviceImplTests.testUserToDto|
||UserSeviceImplTests.testUserFromDto|
||UserSeviceImplTests.testUserToLoginDto|
||UserSeviceImplTests.testgetUserById|
||UserSeviceImplTests.testsaveUser|
||UserSeviceImplTests.testgetAllUsers|
||UserSeviceImplTests.testdeleteUser|
||UserSeviceImplTests.testlogin|
||UserSeviceImplTests.testincreaseUserReputation|
||UserSeviceImplTests.testdecreaseUserReputation|


## Step n API Tests

   <The last integration step  should correspond to API testing, or tests applied to all classes implementing the APIs defined in the Service package>

| Classes  | JUnit test cases |
|--|--|
|||




# Scenarios


<If needed, define here additional scenarios for the application. Scenarios should be named
 referring the UC they detail>

## Scenario UCx.y

| Scenario |  name |
| ------------- |:-------------:| 
|  Precondition     |  |
|  Post condition     |   |
| Step#        | Description  |
|  1     |  ... |  
|  2     |  ... |



# Coverage of Scenarios and FR


<Report in the following table the coverage of  scenarios (from official requirements and from above) vs FR. 
Report also for each of the scenarios the (one or more) API JUnit tests that cover it. >




| Scenario ID | Functional Requirements covered | JUnit  Test(s) | 
| ----------- | ------------------------------- | ----------- | 
|  ..         | FRx                             |             |             
|  ..         | FRy                             |             |             
| ...         |                                 |             |             
| ...         |                                 |             |             
| ...         |                                 |             |             
| ...         |                                 |             |             



# Coverage of Non Functional Requirements


<Report in the following table the coverage of the Non Functional Requirements of the application - only those that can be tested with automated testing frameworks.>


### 

| Non Functional Requirement | Test name |
| -------------------------- | --------- |
|                            |           |


