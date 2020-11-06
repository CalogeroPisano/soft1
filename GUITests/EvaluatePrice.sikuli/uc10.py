#UC10 - Evaluate price
#Precondition: Gas station G exists and user U is registered
#so we are going to use the user created in uc1.sikuli
#and the gas station created in un4.sikuli
#and the price report created in uc8.sikuli
#Starting from homepage, not logged in
#Registered on a 1920x1080 monitor, fullscreen Mozilla Firefox

click("1590747986945.png")
type("1590748002184.png", "admin@ezgas.com" + Key.TAB + "admin")
click("1590748035864.png")
wait(1)
wheel(WHEEL_DOWN, 5)
wait(1)
type("1590748161464.png", "Via Roma Arzano Campania")
wait(2)
type(Key.DOWN + Key.ENTER) #we take the first autocompletion suggestion
click("1590748213039.png")
click(Pattern("1590749946357.png").targetOffset(989,1)) #we say it is good
click(Pattern("1590749946357.png").targetOffset(1043,-2)) #we say it is bad