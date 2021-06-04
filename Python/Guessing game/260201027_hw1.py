


print("Welcome to the guessing game.To play this game, i need you to enter two numbers.This two numbers will be your range and you will try to guess a number which is between them.")

#Following loop is there to just make sure input values are valid for playing the game.

while True:
    begin=input("Enter first number,please.")
    end=input("Enter second number,please.")
    if begin.isnumeric()==False or end.isnumeric()==False:
        print("Please only enter numeric values.")
        continue
    begin=int(begin)
    end=int(end)
    if begin>end:
        print("Second number must be greater than the first one.")
        continue
    if end-begin<5:
        print("Second number must be at least 4 numbers bigger then the first one")
        continue
    break

#This part is for the game itself.
    
import random #Importing random module to use it later.

S=100

target=random.randint(begin,end) # Creating a random number

#Outer loop is for sets the new range and checks if the game should be countinued or not
#And the inner loop checks if the player entered a valid guess and whether they guessed the target correctly or not

while True:
    N=round((end-begin)/5) 
    print("The target is in [",begin,",",end,"]. You have",N,"guesses...")
    if N==0 and end-begin<5: # If these conditions are met,there can't be another round so it breaks the loop
        print("You lost! The target was",target,)
        break
    while True:
        if N==0: #I make the new range half of the old one by increasing begin value and decreasing end value by quarter of the old range.
            x=round((end-begin)/4)#quarter of the old range
            if target in range(begin,begin+x+1) or target in range(end,end-x+1):
                target=random.randint(begin+x,end-x)#This is for setting a new random target value if old one isn't in new range inteval.The player won't know this and it won't matter in terms of statictics.
            #New begin and end values for possible another round
            begin=begin+x
            end=end-x
            break
        guess=input("Try to guess the target.")
        if guess.isnumeric()==False:
            print("Please only enter numeric values.")
            continue
        guess=int(guess)
        if guess-begin<0 or guess-end>0:
            print("Your guess must be in [",begin,",",end,"] interval.")
            continue
        if guess==target:#Guess is correct and loop should be ended
            print("Right guess! Score:",S)
            break
        if guess!=target:#Guess is wrong and it decreases the score by 5 and number of guesses by 1
            S=S-5
            N=N-1
            print("Wrong guess!")
            print("You have",N,"guesses left")
        if S==0:
            print("You lost! The target was",target,)
            break  
        
    if N==0 and S!=0:#Even though the round is finished,if the score isn't 0,there can still be more guess rights left so it goes back beginning of the loop.
        continue
    if guess==target: #If the guess is correct outer loop should end,too
        break
    if S<=0:
        print("You lost! The target was",target,)
        break
        
    

        




