#admin alread logged in and current location is http://localhost:8080/admin
#we suppose that only one gas station already exists.
while(not exists("1590777001180.png", 0.01)):
    wheel(Location(300,300), WHEEL_DOWN, 2)
while(not exists("1590777046051.png", 0.01)):
    wheel(Location(300,300), WHEEL_DOWN, 2)
click("1590777864621.png")
find("1590777918720.png")