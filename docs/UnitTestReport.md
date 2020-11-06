# Unit Testing Documentation

Authors:

Date:

Version:

# Contents

- [Black Box Unit Tests](#black-box-unit-tests)




- [White Box Unit Tests](#white-box-unit-tests)


# Black Box Unit Tests

    <Define here criteria, predicates and the combination of predicates for each function of each class.
    Define test cases to cover all equivalence classes and boundary conditions.
    In the table, report the description of the black box test case and (traceability) the correspondence with the JUnit test case writing the 
    class and method name that contains the test case>
    <JUnit test classes must be in src/test/java/it/polito/ezgas   You find here, and you can use,  class EZGasApplicationTests.java that is executed before 
    the set up of all Spring components
    >

 ### **Class *GasStationDto* - method *testReportDependability&testGasStationId&testGasStationName&testGasStationAddress&testHasDiesel&testHasSuper&testHasSuperPlus&testLat&testLon&testDieselPrice&testSuperPrice&testSuperPlusPrice&testGasPrice&testReportUser&testReportTimestamp&testHasMethane&testMethanePrice&testCarSharing***

**Criteria for method *testReportDependability&testGasStationId&testGasStationName&testGasStationAddress&testHasDiesel&testHasSuper&testHasSuperPlus&testLat&testLon&testDieselPrice&testSuperPrice&testSuperPlusPrice&testGasPrice&testReportUser&testReportTimestamp&testHasMethane&testMethanePrice&testCarSharing*:**

- Sign of reportDependability
- Sign of gasStationId 
- Sign of gasStationName
- Sign of gasStationAddress
- Sign of hasDiesel
- Sign of hasSuper
- Sign of hasSuperPlus
- Sign of hasGas
- Range of lat
- Range of lon
- Sign of dieselPrice
- Sign of superPrice
- Sign of superPlusPrice
- Sign of gasPrice 
- Sign of reportUser
- Sign of reportTimestamp
- Sign of hasMethane
- Sign of methanePrice
- Sign of carSharing
 
 
 
 





**Predicates for method *testReportDependability&testGasStationId&testGasStationName&testGasStationAddress&testHasDiesel&testHasSuper&testHasSuperPlus&testLat&testLon&testDieselPrice&testSuperPrice&testSuperPlusPrice&testGasPrice&testReportUser&testReportTimestamp&testHasMethane&testMethanePrice&testCarSharing*:**

| Criteria | Predicate |
| -------- | --------- |
|   Sign of reportDependability       |      >0     |
|          |    <=0       |
|   Sign of gasStationId       |      >0     |
|          |    <=0       |
|   Sign of gasStationName       |      >0     |
|          |    <=0       |
|   Sign of gasStationAddress       |   gasStationAddress instanceof string == True     | |
|   Sign of hasDiesel       |     hasDiesel instanceof bolean == True     |
|   Sign of hasSuper       |     hasSuper instanceof bolean == True    |
|   Sign of hasSuperPlus       | hasSuperPlus instanceof bolean == True     |
|   Sign of hasGas       | hasGas instanceof bolean == True     |
|   Range of lat       |      >=-180 & <180    |
|          |    >=180   <-180      |
|   Range of lon       |      >=-180 & <180    |
|          |    >=180   <-180      |
|   Sign of dieselPrice       |      >0     |
|          |    <=0       |
|   Sign of superPrice       |      >0     |
|          |    <=0       |
|   Sign of superPlusPrice       |      >0     |
|          |    <=0       |
|   Sign of gasPrice       |      >0     |
|          |    <=0       |
|   Sign of reportUser       |      >0     |
|          |    <=0       |
|   Sign of reportTimestamp       |      >0     |
|          |    <=0       |
|   Sign of hasMethane       |     Sign of hasMethane instanceof bolean == True    |
|   Sign of methanePrice       |      >0     |
|          |    <=0       |
|   Sign of carSharing       |      >0     |
|          |    <=0       |





**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|   Sign of reportDependability       |   Minint, 0, maxint     |
|   Sign of gasStationId       |    Minint, 0, maxint             |
|   Sign of gasStationName       |      Minint, 0, maxint    |
|   Sign of gasStationAddress       |     ""(empty string)    |
|   Sign of hasDiesel       |        ""(empty boolean)     |
|   Sign of hasSuper       |       ""(empty boolean)      |
|   Sign of hasSuperPlus       |      ""(empty boolean)     |
|   Sign of hasGas       |        ""(empty boolean)      |
|   Range of lat      |   -180, -181 , -179 , 180, 181, 179      |
|    Range of lon      |   -180, -181 , -179 , 180, 181, 179    
|   Sign of dieselPrice       |    Minint, 0, maxint             |
|   Sign of superPrice       |    Minint, 0, maxint             |
|   Sign of superPlusPrice       |    Minint, 0, maxint             |
|   Sign of gasPrice       |    Minint, 0, maxint             |
|   Sign of reportUser       |    Minint, 0, maxint             |
|   Sign of reportTimestamp       |       Minint, 0, maxint    |
|   Sign of hasMethane       |       ""(empty boolean)      |
|   Sign of methanePrice       |    Minint, 0, maxint             |
|   Sign of carSharing       |        ""(empty string)    |




**Combination of predicates**:

| Sign of reportDependability| Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| Positive | V | setReportDependability(2.0)   getReportDependability() -> 2.0 |it.polito.ezgas.GasStationDtoTests.testReportDependability|
|Negative|I|setReportDependability(-2.0)   getReportDependability() -> Unexpected Exception ||

| Sign of gasStationId| Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| Positive | V | setGasStationId(2.0)   getGasStationId() -> 2.0 |it.polito.ezgas.GasStationDtoTests.testGasStationIdPos|
|Negative|I|setGasStationId(-2)   getGasStationId() -> Unexpected Exception ||

| Sign of gasStationName| Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| Positive | V | setGasStationName(Q8)   getGasStationName() -> Q8 |it.polito.ezgas.GasStationDtoTests.testGasStationName|
|Negative|I|setGasStationName("")   getGasStationName() -> Unexpected Exception ||

| Sign of gasStationAddress| Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| True | V | setGasStationAddress("Via Sandro Botticelli, 62, 10154 Torino TO")   setGasStationAddress() -> "Via Sandro Botticelli, 62, 10154 Torino TO" |it.polito.ezgas.GasStationDtoTests.testGasStationAddress|
|False|I|setGasStationDtoAddress("")   getGasStationAddress() -> Unexpected Exception ||

|  Sign of hasDiesel | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| True | V | setHasDiesel(false)   getHasDiesel() -> false|it.polito.ezgas.GasStationDtoTests.testHasDiesel|
|False|I|getHasDiesel()||

|  Sign of hasSuper | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| True | V | setHasSuper(false)   getHasSuper() -> false|it.polito.ezgas.GasStationDtoTests.testHasSuper|
|False|I|setHasSuper() ||

|  Sign of hasSuperPlus | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| True | V | setHasSuperPlus(false)   getHasSuperPlus() -> false|it.polito.ezgas.GasStationDtoTests.testHasSuperPlus|
|False|I|setHasSuperPlus() ||

| Sign of hasGas | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| True | V | setHasGas(false)   getHasGas() -> false|it.polito.ezgas.GasStationDtoTests.testHasGas|
|False|I|setHasGas() ||

| Range of lat| Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| >=-180 & <180  | V | setLat(2.0)   getLat() -> 2.0 |it.polito.ezgas.GasStationDtoTests.testLat|
|>=180   <-180|I|setLat(360.000)   getLat() -> Unexpected Exception  ||


| Range of lon| Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| >=-180 & <180  | V | setLon(2.0)   getLon() -> 2.0 |it.polito.ezgas.GasStationDtoTests.testLonInRange|
|>=180   <-180|I|setLon(360.000)   getLon() -> Unexpected Exception  ||

| Sign of dieselPrice| Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| Positive | V | setDieselPrice(2.0)   getDieselPrice() -> 2.0 |it.polito.ezgas.GasStationDtoTests.testDieselPrice|
|Negative|I|setDieselPrice(-2.0)   getDieselPrice() -> Unexpected Exception ||

| Sign of superPrice| Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| Positive | V | setSuperPrice(2.0)   getSuperPrice() -> 2.0|it.polito.ezgas.GasStationDtoTests.testSuperPrice|
|Negative|I|setSuperPrice(-2.0)   getSuperPrice() -> Unexpected Exception ||

| Sign of superPlusPrice| Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| Positive | V | setSuperPlusPrice(2.0)   getSuperPlusPrice() -> 2.0 |it.polito.ezgas.GasStationDtoTests.testPlusPrice|
|Negative|I|setSuperPlusPrice(-2.0)   getSuperPlusPrice() -> Unexpected Exception ||

| Sign of gasPrice| Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| Positive | V | setGasPrice(2.0)   getGasPrice() -> 2.0 |it.polito.ezgas.GasStationDtoTests.testGasPrice|
|Negative|I|setGasPrice(-2.0)   getGasPrice() -> Unexpected Exception ||

| Sign of reportUser| Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| Positive | V | setReportUser(2)   getReportUser() -> 2 |it.polito.ezgas.GasStationDtoTests.testReportUser|
|Negative|I|setReportUser(-2)   getReportUser() -> Unexpected Exception |

| Sign of reportTimestamp  | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| Positive | V | setReportTimestamp(1589711737)   getReportTimestamp() -> 1589711737 |it.polito.ezgas.GasStationDtoTests.testReportTimestamp|
|Negative|I|setReportTimestamp(-2)   getReportTimestamp() -> Unexpected Exception |||

| Sign of hasMethane | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| True | V | setHasMethane(false)   setHasMethane() -> false|it.polito.ezgas.GasStationDtoTests.testHasMethane|
|False|I|setHasMethane() ||

| Sign of methanePrice| Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| Positive | V | setMethanePrice(2.0)   getMethanePrice() -> 2.0 |it.polito.ezgas.GasStationDtoTests.testMethanePrices|
|Negative|I|setMethanePrice(-2.0)   getMethanePrice() -> Unexpected Exception ||


| Sign of carSharing| Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| Positive | V | setCarSharing(" Car")   getCarSharing() -> "Car" |it.polito.ezgas.GasStationDtoTests.testCarSharing|
|Negative|I|setCarSharing("")   getGasStationAddress() -> Unexpected Exception ||






 ### **Class *UserDto* - method *testUserId&testUserName&testPassword&testEmail&testReputation&testAdmin***

**Criteria for method *Class *UserDto* - method *testUserId&testUserName&testPassword&testEmail&testReputation&testAdmin*:**

 - Input of userId
 - Input of userName
 - Input of password
 - Input of email
 - Input of reputation
 - Input of admin

 

 





**Predicates for method *Class *UserDto* - method *testUserId&testUserName&testPassword&testEmail&testReputation&testAdmin*:**

| Criteria | Predicate |
| -------- | --------- |
| Input of userId   | userId instanceof integer == True      |
| Input of reputation | reputation instanceof integer == True |
| Input of userName   | userName instanceof string == True          |
| Input of password   | password instanceof string == True          |
| Input of email   | email instanceof string == True          |
| Input of admin   | admin instanceof boolean == false          |



note: Input of userId,Input of userName, Input of password, Input of email, Input of reputation and Input of admin can not be null

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| Input of userId         | ""(empty integer)                |
| Input of reputation         | ""(empty integer)                |
| Input of userName         | ""(empty string)                |
| Input of password         | ""(empty string)                |
| Input of email         | ""(empty string)                |
| Input of admin   | ""(empty boolean)          |



**Combination of predicates**:


|Input of userId  | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
|True|V|userId(2)|void it.polito.ezgas.dto.UserDtoTests.testgetUserId()|
|False|I|userId("")||

|Input of reputation  | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
|True|V|reputation(2)|void it.polito.ezgas.dto.UserDtoTests.testgetReputation()|
|False|I|reputation("")||

|Input of userName   | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
|True|V|userName("calogero")|void it.polito.ezgas.dto.UserDtoTests.testgetUserName()|
|False|I|userName("")||

|Input of password   | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
|True|V|password("password")|void it.polito.ezgas.dto.UserDtoTests.testgetPassword()|
|False|I|password("")||

|Input of email   | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
|True|V|email("test@gmail.com")|void it.polito.ezgas.dto.UserDtoTests.testgetEmail()|
|False|I|email("")||

|Input of admin   | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
|True|V|admin("false")|void it.polito.ezgas.dto.UserDtoTests.testgetAdmin()|
|False|I|admin("")||

















### **Class *GasStationTests * - method *testReportDependability&testGasStationId&testGasStationName&testGasStationAddress&testHasDiesel&testHasSuper&testHasSuperPlus&testLat&testLon&testDieselPrice&testSuperPrice&testSuperPlusPrice&testGasPrice&testReportUser&testReportTimestamp&testHasMethane&testMethanePrice&testCarSharing***

**Criteria for *GasStationTests * -method *testReportDependability&testGasStationId&testGasStationName&testGasStationAddress&testHasDiesel&testHasSuper&testHasSuperPlus&testLat&testLon&testDieselPrice&testSuperPrice&testSuperPlusPrice&testGasPrice&testReportUser&testReportTimestamp&testHasMethane&testMethanePrice&testCarSharing*:**

- Sign of reportDependability
- Sign of gasStationId 
- Sign of gasStationName
- Sign of gasStationAddress
- Sign of hasDiesel
- Sign of hasSuper
- Sign of hasSuperPlus
- Sign of hasGas
- Range of lat
- Range of lon
- Sign of dieselPrice
- Sign of superPrice
- Sign of superPlusPrice
- Sign of gasPrice 
- Sign of reportUser
- Sign of reportTimestamp
- Sign of hasMethane
- Sign of methanePrice
- Sign of carSharing


**Predicates for  method *testReportDependability&testGasStationId&testGasStationName&testGasStationAddress&testHasDiesel&testHasSuper&testHasSuperPlus&testLat&testLon&testDieselPrice&testSuperPrice&testSuperPlusPrice&testGasPrice&testReportUser&testReportTimestamp&testHasMethane&testMethanePrice&testCarSharing*:**


| Criteria | Predicate |
| -------- | --------- |
|   Sign of reportDependability       |      >0     |
|          |    <=0       |
|   Sign of gasStationId       |      >0     |
|          |    <=0       |
|   Sign of gasStationName       |      >0     |
|          |    <=0       |
|   Sign of gasStationAddress       |   gasStationAddress instanceof string == True     | |
|   Sign of hasDiesel       |     hasDiesel instanceof bolean == True     |
|   Sign of hasSuper       |     hasSuper instanceof bolean == True    |
|   Sign of hasSuperPlus       | hasSuperPlus instanceof bolean == True     |
|   Sign of hasGas       | hasGas instanceof bolean == True     |
|   Range of lat       |      >=-180 & <180    |
|          |    >=180   <-180      |
|   Range of lon       |      >=-180 & <180    |
|          |    >=180   <-180      |
|   Sign of dieselPrice       |      >0     |
|          |    <=0       |
|   Sign of superPrice       |      >0     |
|          |    <=0       |
|   Sign of superPlusPrice       |      >0     |
|          |    <=0       |
|   Sign of gasPrice       |      >0     |
|          |    <=0       |
|   Sign of reportUser       |      >0     |
|          |    <=0       |
|   Sign of reportTimestamp       |      >0     |
|          |    <=0       |
|   Sign of hasMethane       |     Sign of hasMethane instanceof bolean == True    |
|   Sign of methanePrice       |      >0     |
|          |    <=0       |
|   Sign of carSharing       |      >0     |
|          |    <=0       |


**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
|   Sign of reportDependability       |   Minint, 0, maxint     |
|   Sign of gasStationId       |    Minint, 0, maxint             |
|   Sign of gasStationName       |      Minint, 0, maxint    |
|   Sign of gasStationAddress       |     ""(empty string)    |
|   Sign of hasDiesel       |        ""(empty boolean)     |
|   Sign of hasSuper       |       ""(empty boolean)      |
|   Sign of hasSuperPlus       |      ""(empty boolean)     |
|   Sign of hasGas       |        ""(empty boolean)      |
|   Range of lat      |   -180, -181 , -179 , 180, 181, 179      |
|    Range of lon      |   -180, -181 , -179 , 180, 181, 179    
|   Sign of dieselPrice       |    Minint, 0, maxint             |
|   Sign of superPrice       |    Minint, 0, maxint             |
|   Sign of superPlusPrice       |    Minint, 0, maxint             |
|   Sign of gasPrice       |    Minint, 0, maxint             |
|   Sign of reportUser       |    Minint, 0, maxint             |
|   Sign of reportTimestamp       |       Minint, 0, maxint    |
|   Sign of hasMethane       |       ""(empty boolean)      |
|   Sign of methanePrice       |    Minint, 0, maxint             |
|   Sign of carSharing       |        ""(empty string)    |


**Combination of predicates**:

| Sign of reportDependability| Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| Positive | V | setReportDependability(2.0)   getReportDependability() -> 2.0 |it.polito.ezgas.GasStationTests.testReportDependability|
|Negative|I|setReportDependability(-2.0)   getReportDependability() -> Unexpected Exception ||

| Sign of gasStationId| Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| Positive | V | setGasStationId(2.0)   getGasStationId() -> 2.0 |it.polito.ezgas.GasStationTests.testGasStationIdPos|
|Negative|I|setGasStationId(-2)   getGasStationId() -> Unexpected Exception ||

| Sign of gasStationName| Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| Positive | V | setGasStationName(Q8)   getGasStationName() -> Q8 |it.polito.ezgas.GasStationTests.testGasStationName|
|Negative|I|setGasStationName("")   getGasStationName() -> Unexpected Exception ||

| Sign of gasStationAddress| Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| True | V | setGasStationAddress("Via Sandro Botticelli, 62, 10154 Torino TO")   setGasStationAddress() -> "Via Sandro Botticelli, 62, 10154 Torino TO" |it.polito.ezgas.GasStationTests.testGasStationAddress|
|False|I|setGasStationDtoAddress("")   getGasStationAddress() -> Unexpected Exception ||

|  Sign of hasDiesel | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| True | V | setHasDiesel(false)   getHasDiesel() -> false|it.polito.ezgas.GasStationTests.testHasDiesel|
|False|I|getHasDiesel()||

|  Sign of hasSuper | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| True | V | setHasSuper(false)   getHasSuper() -> false|it.polito.ezgas.GasStationTests.testHasSuper|
|False|I|setHasSuper() ||

|  Sign of hasSuperPlus | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| True | V | setHasSuperPlus(false)   getHasSuperPlus() -> false|it.polito.ezgas.GasStationTests.testHasSuperPlus|
|False|I|setHasSuperPlus() ||

| Sign of hasGas | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| True | V | setHasGas(false)   getHasGas() -> false|it.polito.ezgas.GasStationTests.testHasGas|
|False|I|setHasGas() ||

| Range of lat| Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| >=-180 & <180  | V | setLat(2.0)   getLat() -> 2.0 |it.polito.ezgas.GasStationTests.testLat|
|>=180   <-180|I|setLat(360.000)   getLat() -> Unexpected Exception  ||


| Range of lon| Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| >=-180 & <180  | V | setLon(2.0)   getLon() -> 2.0 |it.polito.ezgas.GasStationTests.testLonInRange|
|>=180   <-180|I|setLon(360.000)   getLon() -> Unexpected Exception  ||

| Sign of dieselPrice| Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| Positive | V | setDieselPrice(2.0)   getDieselPrice() -> 2.0 |it.polito.ezgas.GasStationTests.testDieselPrice|
|Negative|I|setDieselPrice(-2.0)   getDieselPrice() -> Unexpected Exception ||

| Sign of superPrice| Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| Positive | V | setSuperPrice(2.0)   getSuperPrice() -> 2.0|it.polito.ezgas.GasStationTests.testSuperPrice|
|Negative|I|setSuperPrice(-2.0)   getSuperPrice() -> Unexpected Exception ||

| Sign of superPlusPrice| Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| Positive | V | setSuperPlusPrice(2.0)   getSuperPlusPrice() -> 2.0 |it.polito.ezgas.GasStationTests.testPlusPrice|
|Negative|I|setSuperPlusPrice(-2.0)   getSuperPlusPrice() -> Unexpected Exception ||

| Sign of gasPrice| Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| Positive | V | setGasPrice(2.0)   getGasPrice() -> 2.0 |it.polito.ezgas.GasStationTests.testGasPrice|
|Negative|I|setGasPrice(-2.0)   getGasPrice() -> Unexpected Exception ||

| Sign of reportUser| Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| Positive | V | setReportUser(2)   getReportUser() -> 2 |it.polito.ezgas.GasStationTests.testReportUser|
|Negative|I|setReportUser(-2)   getReportUser() -> Unexpected Exception |

| Sign of reportTimestamp  | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| Positive | V | setReportTimestamp(1589711737)   getReportTimestamp() -> 1589711737 |it.polito.ezgas.GasStationTests.testReportTimestamp|
|Negative|I|setReportTimestamp(-2)   getReportTimestamp() -> Unexpected Exception |||

| Sign of hasMethane | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| True | V | setHasMethane(false)   setHasMethane() -> false|it.polito.ezgas.GasStationTests.testHasMethane|
|False|I|setHasMethane() ||

| Sign of methanePrice| Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| Positive | V | setMethanePrice(2.0)   getMethanePrice() -> 2.0 |it.polito.ezgas.GasStationTests.testMethanePrices|
|Negative|I|setMethanePrice(-2.0)   getMethanePrice() -> Unexpected Exception ||


| Sign of carSharing| Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
| Positive | V | setCarSharing(" Car")   getCarSharing() -> "Car" |it.polito.ezgas.GasStationTests.testCarSharing|
|Negative|I|setCarSharing("")   getGasStationAddress() -> Unexpected Exception ||


### **Class *LoginDtoTests * - method *test_LoginDtoUserID1&test_LoginDtoUserID2&test_LoginDtoUserID&test_LoginDtoUserReputation1&test_LoginDtoUserReputation2&test_LoginDtoUserReputation3&test_LoginDtoUserName&test_LoginDtoToken&test_LoginDtoUserEmail&test_LoginDtoUserAdmin***

**Criteria for method *Class *LoginDtoTests * - method *test_LoginDtoUserID1&test_LoginDtoUserID2&test_LoginDtoUserID&test_LoginDtoUserReputation1&test_LoginDtoUserReputation2&test_LoginDtoUserReputation3&test_LoginDtoUserName&test_LoginDtoToken&test_LoginDtoUserEmail&test_LoginDtoUserAdmin:**

 - Input of userId
 - Input of userName
 - Input of token
 - Input of email
 - Input of reputation
 - Input of admin

 

 





**Predicates for method *Class *LoginDtoTests * - method * test_LoginDtoUserID1&test_LoginDtoUserID2&test_LoginDtoUserID&test_LoginDtoUserReputation1&test_LoginDtoUserReputation2&test_LoginDtoUserReputation3&test_LoginDtoUserName&test_LoginDtoToken&test_LoginDtoUserEmail&test_LoginDtoUserAdmin  *:**

| Criteria | Predicate |
| -------- | --------- |
| Input of userId   |  >0    |
|          |    <=0        |     
| Input of reputation |  >0    |
|          |    <=0         | 
| Input of userName   | userName instanceof string == True          |
| Input of token   | password instanceof string == True          |
| Input of email   | email instanceof string == True          |
| Input of admin   | admin instanceof boolean == Talse          |



note: Input of userId,Input of userName, Input of password, Input of email, Input of reputation and Input of admin can not be null

**Boundaries**:

| Criteria | Boundary values |
| -------- | --------------- |
| Input of userId         | Minint, 0, maxint                 |
| Input of reputation         | Minint, 0, maxint                |
| Input of userName         | ""(empty string)                |
| Input of token         | ""(empty string)                |
| Input of email         | ""(empty string)                |
| Input of admin   | ""(empty boolean)          |



**Combination of predicates**:


|Input of userId  | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
|Positive | V | setUserId(8888)   |test_LoginDtoUserID1|
|Negative|I|setUserId(-2147483647)|test_LoginDtoUserID2 test_LoginDtoUserID|

|Input of reputation  | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
|True|V|setReputation(100) getUserId -> 100|test_LoginDtoUserReputation1|
|False|I|reputation(-2147483647)|test_LoginDtoUserReputation2 test_LoginDtoUserReputation3|

|Input of userName   | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
|True|V|setUserName("pluto") getUserName()->"pluto"|void it.polito.ezgas.dto.LoginDtoTests.test_LoginDtoUserName|
|False|I|userName("")||

|Input of token   | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
|True|V|setToken("0001") getToken()->"0001"|void it.polito.ezgas.dto.LoginDtoTests.test_LoginDtoToken|
|False|I|Token("")||

|Input of email   | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
|True|V|setEmail("pippo.pluto@ezgas.it") getEmailtToken()->"pippo.pluto@ezgas.it"|void it.polito.ezgas.dto.LoginDtoTests.test_LoginDtoUserEmail|
|False|I|email("")||

|Input of admin   | Valid / Invalid | Description of the test case | JUnit test case |
|-------|-------|-------|-------|
|True|V|admin("true")|void it.polito.ezgas.dto.LoginDtoTests.test_LoginDtoUserAdmin|
|False|I|admin("")||











# White Box Unit Tests

### Test cases definition
    
    <JUnit test classes must be in src/test/java/it/polito/ezgas>
    <Report here all the created JUnit test cases, and the units/classes under test >
    <For traceability write the class and method name that contains the test case>


| Unit name | JUnit test case |
|--|--|
|GasStationDto|void it.polito.ezgas.dto.GasStationDtoTests.GasStationDtoTests |
|UserDto|void it.polito.ezgas.dto.UserDtoTests.UserDtoTests |
|GasStation|void it.polito.ezgas.dto.GasStationTests.GasStationTests |
|LoginDto|void it.polito.ezgas.dto.LoginDtoTests.LoginDtoTests |







### Code coverage report
![coverage1](ezgas/docs/UI/coverage1.png)
![coverage2](ezgas/docs/UI/coverage2.png)


### Loop coverage analysis

    <Identify significant loops in the units and reports the test cases
    developed to cover zero, one or multiple iterations >

|Unit name | Loop rows | Number of iterations | JUnit test case |
|---|---|---|---|
|||||
|||||
||||||




