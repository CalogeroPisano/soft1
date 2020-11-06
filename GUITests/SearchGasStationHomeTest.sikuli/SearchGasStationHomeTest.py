#admin alread logged in and current location is http://localhost:8080
#we suppose that only one gas station already exists.
wheel("1590754019012.png", WHEEL_DOWN, 10)
click("1590778341452.png")
type("via roma")
wait("1590754455747.png")
click("1590754455747.png")
click("1590754492629.png")
wheel(Location(300,300), WHEEL_DOWN, 2)
find("1590778979588.png")
wheel(Location(300,300), WHEEL_UP, 20)
find("1590779020260.png")