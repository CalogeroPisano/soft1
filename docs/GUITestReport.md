# GUI  Testing Documentation 

Authors:Concetto Antonino Privitera

Date: 30/05/2020

Version:1.0

# GUI testing

This part of the document reports about testing at the GUI level. Tests are end to end, so they should cover the Use Cases, and corresponding scenarios.

## Coverage of Scenarios and FR

```
<Complete this table (from IntegrationApiTestReport.md) with the column on the right. In the GUI Test column, report the name of the .py  file with the test case you created.>
```

### 

| Scenario ID | Functional Requirements covered | GUI Test(s) |
| ----------- | ------------------------------- | ----------- |
| 1           | FR1, FR1.1                      |CreateUserAccountHome|
| 2           | FR1, FR1.1                      |ModifyUserAccount|
| 3           | FR1, FR1.2                      |DeleteUserAccount|
| 4           | FR3, FR3.1                      |CreateGasStationTest|             
| 5           | FR3, FR3.1                      |EditGasStationTest|             
| 6           | FR3, FR3.2                      |RemoveGasStationTest|         
| 7           | FR4, FR4.2 (only address without radius), FR4.3 (partially), FR4.5, FR5, FR5.1                     |ReportPriceHomeTest, ReportPriceAdminTest|             
| 8           | FR4, FR4.2 (only address without radius), FR4.3 (show map only in home, not admin page), 4.5                                |SearchGasStationAdminTest, SearchGasStationHomeTest|
| 10          | FR5, FR5.2, FR5.3               |EvaluatePrice|             
| ...         |                                 |             |             


# REST  API  Testing

This part of the document reports about testing the REST APIs of the back end. The REST APIs are implemented by classes in the Controller package of the back end. 
Tests should cover each function of classes in the Controller package

## Coverage of Controller methods


<Report in this table the test cases defined to cover all methods in Controller classes >

| class.method name | Functional Requirements covered |REST  API Test(s) | 
| ----------- | ------------------------------- | ----------- | 
| saveUser         | FR1.1                            |     test01saveUser        |     
| updateUser           | FR1.1                             |      test02updateUser       |             
| getUserById         |      FR1.4                           |       test03getUserById      |             
| getAllUsers         |           FR1.3                      |        test04getAllUsers     |             
| IncreaseUsetReputation         |       FR5                          |        test05IncreaseUsetReputation     |        FR5     
| DecreaseUserReputation         |                                 |       test06DecreaseUserReputation      |  
| login         |           FR1                      |        test07login     |             
| savegasStation         |      FR3.1                           |        test08savegasStation     |             
| updategasStation         |    FR3.1                             |       test09updategasStation      |  
| setgasStationReport         |            FR5.1                     |        test10setgasStationReport     |             
| getByProximity         |        FR4.1                         |        test11getByProximity    |             
| getAllGasStation         |      FR3.3                           |       test12getAllGasStations      |  
| searchGasStationsByGasolineType         |         FR4.4                        |       test13searchGasStationsByGasolineType    |  
| getGasStationWithCoordinates         |   FR4.5                              |        test14getGasStationWithCoordinates     |             
| deleteGasStation         |   FR3.2                               |       test98deleteGasStation      | 
| deleteUser         |        FR1.2                         |       test99deleteUser    |             