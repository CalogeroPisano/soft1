#admin alread logged in and current location is http://localhost:8080/admin
#we suppose that only one gas station already exists and it has "hasgasoline" to false.
while(not exists("1590777001180.png", 0.01)):
    wheel(Location(300,300), WHEEL_DOWN, 2)
while(not exists("1590777046051.png", 0.01)):
    wheel(Location(300,300), WHEEL_DOWN, 2)
click("1590777082787.png")
while(not exists("1590777404685.png", 0.01)):
    wheel(Location(300,300), WHEEL_UP, 2)
click("1590777404685.png")
click("1590777418411.png")
wait("1590777441875.png")
while(not exists("1590777046051.png", 0.01)):
    wheel(Location(300,300), WHEEL_DOWN, 2)
find("1590777490764.png")