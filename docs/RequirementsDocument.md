# Requirements Document 

Authors:Calogero Pisano, Bergia Stefano, Antonino Privitera, Li Minfang

Date:09/04/2020

Version:1.0

# Contents

- [Stakeholders](#stakeholders)
- [Context Diagram and interfaces](#context-diagram-and-interfaces)
	+ [Context Diagram](#context-diagram)
	+ [Interfaces](#interfaces) 
	
- [Requirements Document](#requirements-document)
- [Contents](#contents)
- [Stakeholders](#stakeholders)
- [Context Diagram and interfaces](#context-diagram-and-interfaces)
	- [Context Diagram](#context-diagram)
	- [Interfaces](#interfaces)
- [Stories and personas](#stories-and-personas)
- [Functional and non functional requirements](#functional-and-non-functional-requirements)
	- [Functional Requirements](#functional-requirements)
	- [Non Functional Requirements](#non-functional-requirements)
- [Use case diagram and use cases](#use-case-diagram-and-use-cases)
	- [Use case diagram](#use-case-diagram)
		- [Use case 1](#use-case-1)
				- [UC1 - FR1    Create a new account](#uc1---fr1-create-a-new-account)
				- [Scenario 1-1](#scenario-1-1)
		- [Use case 2](#use-case-2)
				- [UC2 - FR2   Record position of the gas stations](#uc2---fr2-record-position-of-the-gas-stations)
				- [Scenario 2-1](#scenario-2-1)
		- [Use case 3](#use-case-3)
				- [UC3 - FR3 Record the price of gas station](#uc3---fr3-record-the-price-of-gas-station)
				- [Scenario 3-1](#scenario-3-1)
		- [Use case 4](#use-case-4)
				- [UC4 - FR4  Record a score of the gas station](#uc4---fr4-record-a-score-of-the-gas-station)
				- [Scenario 4-1](#scenario-4-1)
		- [Use case 5](#use-case-5)
				- [UC5 - FR5 Add a particular gas station to a favourite list](#uc5---fr5-add-a-particular-gas-station-to-a-favourite-list)
				- [Scenario 5-1](#scenario-5-1)
		- [Use case 6](#use-case-6)
				- [UC6 - FR6 Show gas station info](#uc6---fr6-show-gas-station-info)
				- [Scenario 6-1](#scenario-6-1)
				- [Scenario 6-2](#scenario-6-2)
				- [Scenario 6-3](#scenario-6-3)
		- [Use case 7](#use-case-7)
				- [UC7 - FR14 Show path between two locations and gas station markers](#uc7---fr14-show-path-between-two-locations-and-gas-station-markers)
				- [Scenario 7-1](#scenario-7-1)
		- [Use case 8](#use-case-8)
				- [UC8 - FR8 Open ticket](#uc8---fr8-open-ticket)
				- [Scenario 8-1](#scenario-8-1)
- [Glossary](#glossary)
- [System Design](#system-design)
- [Deployment Diagram](#deployment-diagram)


# Stakeholders

| Stakeholder name  | Description | 
| ----------------- |:-----------:|
| Admnistrator      | Do not use the application directly. Manage user ticketing problem request   | 
|User | Uses the application in order to get the position of the nearest gas stations, getting their prices as well, he/she has the possibility to review and write the price of a gas station|
|Google Maps| Does not use the application directly, it provides map service|

# Context Diagram and interfaces

## Context Diagram

```plantuml
left to right direction
actor User as u
actor GoogleMaps as m
actor Adminstrator as a
m -- (EZgas)
u -- (EZgas)
a -- (EZgas) 
```

## Interfaces
| Actor | Logical Interface | Physical Interface  |
| ------------- |:-------------:|:-----:|
|      User     |GUI         |Screen, monitor, touchscreen|

# Stories and personas
Paul works as Uber driver in a big city,in order to earn a salary, every day he needs to do a lot of km inside his car, taking Uber travel request from all over the city. So, he is always looking for the nearest gas station that suits for his type of car (he has a gasoline vehicle). Moreover he would prefer a cheap gas station than an expensive one, indeed, the less he spends for gas the better is for his monthly salary, for this reason, each time he refuels his car he accounts the fuel price of the gas station. At the end of the month he hightlights the better gas station in the city.

Besides, he has many friends that work as Uber drivers, in particular, they have a common telegram group where they can share informations about any gas station they have visited lately focusing on the price and position.

Margaret, one of the friend of Paul, has a natural gas vehicle so she needs information about the position of gas stations that have this particular refueling so she used to ask in the group if someone could help her.

Both Margaret and Paul would like to know everytime they need, the exact position and price of gas stations without loosing time and consequently possible Uber request, asking to others for informations.


# Functional and non functional requirements

## Functional Requirements

| ID        | Description  |
| ------------- |:-------------:| 
|FR1|Create a new account |
|  FR2     | Record the position of the gas stations already reviewed |  
|  FR3     | Record the price of gas station |
|  FR4     | Record the score of a gas station |
|  FR5     | Add a particular gas station to a favourite list |
|FR6| Show gas station info (price, type of fuel and score)|
|FR7|Show the map|
|FR8|Send ticket for assistance|
|  FR9     | Filter by price |
|  FR10     | Filter by type of fuel |
|  FR11    | Filter by best score |
| FR12 | log in |
| FR13 | log out |
| FR14 | Show path between two locations |
| FR15 | Show favoirute gas stations offline |

## Non Functional Requirements

| ID        | Type (efficiency, reliability, .. see iso 9126)           | Description  | Refers to |
| ------------- |:-------------:| :-----:| -----:|
|  NFR1     | Usability | Application should be used by any common user so it should intuitive and easy to use  | All FR  |
|  NFR2     | Reliability  |  Application should ensure the correct registration of the review | FR1-FR4 |
|  NFR3     | Portability | Application should run on last version of androind and IOS  | All FR |
|  NFR4     | Performance | Application filter functions should be completed within 0.5s   |  FR9-FR11 |
|  NFR5     | Privacy | Application should ensure the privacy of the data recorded on each user account  | FR1-FR5 |
|  NFR6     | Reliability | Application should show only one price from the one uploaded  (majority voting)| FR3 FR6 |


# Use case diagram and use cases


## Use case diagram
```plantuml
left to right direction
actor User as u
actor Adminstrator as A
actor GoogleMaps as M
u -- (FR1 Create a new account)
u -- (FR2 Record position of the gas stations)
u -- (FR3 Record the price of gas station)
u -- (FR4 Record a score of the gas station)
u -- (FR5 Add a particular gas station to a favourite list)
u -- (FR6 Show gas station info)
u --> (FR7 Show the map)
u --> (FR8 Send a ticket for assistance)
A <-- (FR8 Send a ticket for assistance)
M <-- (FR7 Show the map)
```

### Use case 1
##### UC1 - FR1    Create a new account

| Actors Involved        | User |
| ------------- |:-------------:| 
|  Precondition     |  |  
|  Post condition     | User has an active account |
|  Nominal Scenario     | User creates a new account by adding a valid username and password   |
|  Variants     |   |

##### Scenario 1-1

| Scenario ID: SC2        |   Corresponds to UC2 and UC3|
| ------------- |:-------------| 
| Description |User creates a new account by adding a valid username and password |
| Precondition |  User has an active account |
| Postcondition | Show gas station list |
| Step#        |  Step description   |
|  1     | User clicks on sign in button |
|  2     | User insert username and password |
|  3     | The App verifies that the username is unique  |
|  4     | The user has an active account |

### Use case 2
##### UC2 - FR2   Record position of the gas stations 

| Actors Involved        | User |
| ------------- |:-------------:| 
|  Precondition     | User has an active account |  
|  Post condition     | Maps is updated |
|  Nominal Scenario     | User record the position of the new gas station in the application by clicking add gas station button   |
|  Variants     |  |

##### Scenario 2-1

| Scenario ID: SC2        |   Corresponds to UC2|
| ------------- |:-------------| 
| Description | User add a new gas station position|
| Precondition |  User has an active account |
| Postcondition | Gas station is added |
| Step#        |  Step description   |
|  1     | User clicks on add gas station button |  
|  2     |  User inserts information about gas station |
|  3     | User clicks on add station  |
|  4     | if the station isn't present in the system  it is added |
| 4 | Gas station position is now showed to everyone in the application |

### Use case 3
##### UC3 - FR3 Record the price of gas station

| Actors Involved        | User |
| ------------- |:-------------:| 
|  Precondition     | User has an active account |  
|  Post condition     | The price of the gas station is updated |
|  Nominal Scenario     | User record the price of the gas station visited  |
|  Variants     |  |


##### Scenario 3-1

| Scenario ID: SC3        |   Corresponds to UC3|
| ------------- |:-------------| 
| Description | User add a price for a gas station|
| Precondition |  User has an active account, gas station exists and is shownon the screen |
| Postcondition | a price is added |
| Step#        |  Step description   |
|  1     | User clicks on a gas station marker |  
|  2     |  User clicks on add price button |
|  3     | User selects fuel type  |
| 4 | User writes the price for that fuel type |
| 5 | price for that fuel type for that gas station for that date is stored and used with all other prices uploaded by other users to determine which price is shown on the app |

### Use case 4
##### UC4 - FR4  Record a score of the gas station

| Actors Involved        | User |
| ------------- |:-------------:| 
|  Precondition     | User has an active account, a gas station is shown |  
|  Post condition     | The score is showed in the score section of the info of gas station |
|  Nominal Scenario     | User select the gas station and then decide a score of the gas station writing a number between 0 to 10 in the score textbox |
|  Variants     |  |

##### Scenario 4-1

| Scenario ID: SC4        |   Corresponds to UC4|
| ------------- |:-------------| 
| Description | User add a price for a gas station|
| Precondition |  User has an active account, a gas station is shown |
| Postcondition | The rating for the gas station is computed|
| Step#        |  Step description   |
|  1     | User clicks on "rating button" for the gas station |  
|  2     |  User insert a rating between 0 an 10 points |
|  3     |  the score is stored with all of the scores sent by other user for that station   |
|  4     |  the final rating for the gas station is computed by doing an avarage of all the scores  |


### Use case 5
##### UC5 - FR5 Add a particular gas station to a favourite list

| Actors Involved        | User |
| ------------- |:-------------:| 
|  Precondition     | User has an active account, gas station is in the map |  
|  Post condition     | User add the gas station in the favourite list |
|  Nominal Scenario     | User may add a particular gas station in a list of the gas station clicking the associated star of the gas station |
|  Variants     |  |

##### Scenario 5-1

| Scenario ID: SC5        |   Corresponds to UC5|
| ------------- |:-------------| 
| Description | User has an active account, gas station is selected|
| Precondition |  user has an active account  |
| Postcondition | Gas station in added in the user's the favourite list|
| Step#        |  Step description   |
|  1     | User clicks on "add to favourites" button for the gas station |  
|  2     |  gas station si marked as favourite |
|  3     |  information about gas station is downloaded locally |

### Use case 6
##### UC6 - FR6 Show gas station info

| Actors Involved        | User |
| ------------- |:-------------:| 
|  Precondition     | User has an active account, gas station is in the map |  
|  Post condition     | User sees gas station info |
|  Nominal Scenario     | User see gas station info by selecting the gas station in the map and clicking info button |
|  Variants     | Google map or internet is not available |


##### Scenario 6-1

| Scenario ID: SC6.1       |   Corresponds to UC6|
| ------------- |:-------------| 
| Description |User searches for a gas station|
| Precondition |  User has an active account |
| Postcondition | Show gas station  |
| Step#        |  Step description   |
|  1     | User clicks on the search bar |  
|  2     |  User writes the address of the gas station |
|  3 | a map with a marker for every gas station in that location is shown |
| 4 | User click to a gas station marker|
| 5 | Application shows the information of the gas station |

##### Scenario 6-2

| Scenario ID: SC6.2       |   Corresponds to UC6|
| ------------- |:-------------| 
| Description |User searches for a gas station but Google map is not available |
| Precondition |  User has an active account |
| Postcondition | Show gas station  |
| Step#        |  Step description   |
|  1     | User clicks on the search bar |  
|  2     | Alert about missing Google map availability is shown |
|  3     |  User writes the address of the gas station |
|  4 | Gas station is shown but the map is not |

##### Scenario 6-3

| Scenario ID: SC6.3       |   Corresponds to UC6|
| ------------- |:-------------| 
| Description |User searches for a gas station but Internet connection is not available |
| Precondition |  User has an active account |
| Postcondition | Show gas station  |
| Step#        |  Step description   |
|  1     | User clicks on the search bar |  
|  2     | Alert about missingInternet connection is shown |
|  3 | the list of favourite gas station is shown (see Scenario 5.1) |
|  4 | User selects a station in the list |
| 5 | Application shows the information of the gas station stored locally(possibly not updated)|

### Use case 7
##### UC7 - FR14 Show path between two locations and gas station markers 

| Actors Involved        | User |
| ------------- |:-------------:| 
|  Precondition     | User has an active account|  
|  Post condition     | User sees path and gas station markers|
|  Nominal Scenario     | User insert departure address and arrival address, the path and the merker are shown |
|  Variants     | the departure address is taken from gps location |

##### Scenario 7-1

| Scenario ID: SC7        |   Corresponds to UC7|
| ------------- |:-------------| 
| Description |User searches for a path and sees all the gas stations on that path|
| Precondition |  User has an active account |
| Postcondition | Show path on map and corresponding gas station marker |
| Step#        |  Step description   |
|  1     | User clicks on the search bar |  
|  2     | User clicks on the search path button |  
|  3     |  User writes the departure and arrival addresses |
|  4     | The path is showed |
|  5     | A marker for each station in the path is shown |  
|  6    |  User clicks on a marker |
|  7    | gas station info is shown |

### Use case 8
##### UC8 - FR8 Open ticket 

| Actors Involved        | User, Administrator |
| ------------- |:-------------:| 
|  Precondition     | User has an active account|  
|  Post condition     | The Administrator sees and addresses the issue|
|  Nominal Scenario     | User open a ticket request to notify an issue, the administrator sees all ticket requests and can solve problems |
|  Variants     |  |

##### Scenario 8-1

| Scenario ID: SC8        |   Corresponds to UC8|
| ------------- |:-------------| 
| Description | User open a ticket request to notify an issue, the administrator sees all ticket requests and can solve problems|
| Precondition |  User has an active account |
| Postcondition | The Administrator sees and addresses the issue |
| Step#        |  Step description   |
|  1     | User clicks on the "Open ticket button"|  
|  2     | User Inserts in a textbox a description of the issue|  
|  3     |  User clicks on "Send" button |
|  4     | The Administrator receives the ticket |
|  5     | The Administrator aswer the ticket |
|  7     | The message is shown to the User |

# Glossary

```plantuml
class EZGas
class Person{
    +name
    +surname
}
class Account{
    +email
    +password
    +username
}
class GasStation{
    +GasStationID
	+Name
    +Address
    +score
}
class FuelPrice{
  +price
  +Date
}
class FuelType{
  +type
}

class ticketRequest{
    +ticketID
    +status
}

class message{
	+timestamp
	+text
	+Author
}

class UserNewGasStationInfo{
    +newName
    +newAddress
}
class Adminstrator{
      
}

class favourites{
  +GasStationID
}

class GasStationRating{
	+Score
	+Date
}

class PriceSubmission{
	+Price
	+Date
}

Person <|-- Adminstrator
Person <|-- General_User
EZGas -- "*" Account
Account -- Person 
Account -- "*" UserNewGasStationInfo
UserNewGasStationInfo -- GasStation 
Account -- "*" ticketRequest
ticketRequest -- Adminstrator
GasStation -- "*" FuelPrice
FuelPrice -- "*" FuelType
Account -- "*" favourites
favourites -- GasStation
GasStationRating"*"--Account
GasStationRating"*"--GasStation
PriceSubmission"*"--Account
PriceSubmission"*"--GasStation
PriceSubmission"*"--FuelType
PriceSubmission"*"--FuelPrice
message"*"--ticketRequest

```

# System Design
\<describe here system design>

\<must be consistent with Context diagram>

# Deployment Diagram 

\<describe here deployment diagram >
