#admin alread logged in and current location is http://localhost:8080/admin
#we suppose that only one gas station already exists with only LPG enabled.
while(not exists("1590778296290.png", 0.01)):
    wheel(Location(300,300), WHEEL_DOWN, 2)
click("1590778341452.png")
type("via roma")
wait("1590754455747.png")
click("1590754455747.png")
click("1590754492629.png")
while(not exists("1590778135235.png", 0.01)):
    wheel(Location(300,300), WHEEL_DOWN, 2)
wheel(Location(300,300), WHEEL_DOWN, 2)
wait("1590841963737.png")
click("1590841963737.png")
wheel(Location(300,300), WHEEL_DOWN, 2)
click("1590779654237.png")
type("2.1")
click("1590779676861.png")