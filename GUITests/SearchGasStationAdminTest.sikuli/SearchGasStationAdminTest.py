#admin alread logged in and current location is http://localhost:8080/admin
#we suppose that only one gas station already exists.
while(not exists("1590778296290.png", 0.01)):
    wheel(Location(300,300), WHEEL_DOWN, 2)
click("1590778341452.png")
type("via roma")
wait("1590754455747.png")
click("1590754455747.png")
click("1590778665484.png")
click("1590778476084.png")
click("1590778678772.png")
click("1590767707801.png")
click("1590778524259.png")
while(not exists("1590778135235.png", 0.01)):
    wheel(Location(300,300), WHEEL_DOWN, 2)
wheel(Location(300,300), WHEEL_DOWN, 2)
find("1590778276509.png")