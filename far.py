import random 

#Displaying context
def display():
    print("#"*25)
    print("   FAR -O- METER    ")
    print("#"*25)
    print(">> Welcome to the far-o-meter. My Co-partner will explain rest!")
    print(">> [Co-Partner] : Hello there player!\nIn this game you need to guess numbers from 1 - 100 the closer you guess the better if you wander too far the meter shall punish you!")

#Proximity function to check how close the guess is to number and giving points accordingly
def proximity(lim,inp,thresh):
    if inp >= thresh and inp <= lim:
        print(">> Close! Going good! ")
        return 1
    elif inp == lim:
        print(">> Damn !!")
        return 0  
    else:
        print(">> Calm down! ")
        return lim - inp
        

def main():
    display()
    meter = 0
    maxTries = 10
    i=1
    #User has 10 tries to keep meter safe!
    while i < maxTries:
        #Getting random value
        randval = random.randint(1,101)
        #Calculating safety threshold
        threshold = (randval * 6)//7
        try:
            #taking input
            guess = int(input(">> What do you think the number is ? : "))
        except Exception as e:
            print(">> The meter has crashed :/")
        else:
            #Game ending conditions
            meter += proximity(randval,guess,threshold)
            print(">> Number was",randval)
            print(">> Meter is at",meter,"!")
            i+=1
            1
            if meter > 100 or meter < -100:
                print(">> GAME OVER")
                exit()

    print(">> GOOD ONE BOY! YOU WON!")

main()