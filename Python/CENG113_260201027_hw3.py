260201027

# # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # # #
# Ball Crush

from random import randint
import time

def display_board(board): #Displays the board with newlines
    for i in range(5):   
        print(board[i],"\n")
def display_ball_positions(ball_positions): #prints ball positions
    print(ball_positions)
def choose_ball(board):
    ball_positions_read_from_board=[] # since we cant use balls_position, it reads the balls' position from board.It does so by finding "1"s and adding their index to a new list
    for col in range(len(board)):
        for row in range(len(board[col])):
            if board[col][row]==1:
                ball_positions_read_from_board.append((col,row))
    while True:
        chosen_position=input("Which ball?")
        if len(chosen_position)==3:
            try: #this try except block controls if input values are valid.It first checks if there is integers in ball position tuple as it should be(int,int) then it checks the "," in the middle.
                int(chosen_position[0])
                int(chosen_position[2])
                if int(chosen_position[0]) in range(5) and int(chosen_position[2]) in range(5) and chosen_position[1]==",":
                     chosen_position_list=[]
                     chosen_position_list.append(int(chosen_position[0]))
                     chosen_position_list.append(int(chosen_position[2]))
                     chosen_position_tuple=tuple(chosen_position_list) 
                     if chosen_position_tuple in ball_positions_read_from_board:
                         return chosen_position_tuple
                     print("There is no ball there")
                     continue
                else:
                    print("It is not a ball position.")
                    continue
            except:
                print("It is not a ball position.")
                continue
        else:
            print("It is not a ball position.")

def get_valid_moves(ball_pos, len_board):
    Valid_moves=['w', 'a', 's', 'd'] #it gets valid moves by removing invalid ones.For example if the ball is in the left most side it cant go in "a" direction and so on.
    if int(ball_pos[0])==0:
        Valid_moves.remove("w")
    if int(ball_pos[0])==4:
        Valid_moves.remove("s")
    if int(ball_pos[1])==0:
        Valid_moves.remove("a")
    if int(ball_pos[1])==4:
        Valid_moves.remove("d")
    return Valid_moves

   
def  make_move(board, ball_pos, valid_moves, ball_positions):
    while True:
        move=input("What's your move?")
        if move in valid_moves:#it controls whether the move is valid or not
            break
    x=ball_pos[0]
    y=ball_pos[1]
    if move=="w": #It moves the ball according to given x-y coordinate system.For example if theball is in position (1,0) and if "w" direction is given, then the ball moves to (0,0)
        board[int(x)-1][int(y)]=1
        ball_positions.append(tuple([x-1,y]))#It moves the ball into its new position
        if check_collision(board, ball_positions)==True:
            ball_positions.remove(tuple([x-1,y])) #if there is a collision, that means there is two balls in that position.This line removes the repetation
    if move=="s":
        board[int(x)+1][int(y)]=1
        ball_positions.append(tuple([x+1,y]))
        if check_collision(board, ball_positions)==True:
            ball_positions.remove(tuple([x+1,y]))
    if move=="a":
        board[int(x)][int(y)-1]=1
        ball_positions.append(tuple([x,y-1]))
        if check_collision(board, ball_positions)==True:
            ball_positions.remove(tuple([x,y-1]))
    if move=="d":
        board[int(x)][int(y)+1]=1
        ball_positions.append(tuple([x,y+1]))
        if check_collision(board, ball_positions)==True:
            ball_positions.remove(tuple([x,y+1]))
        
    delete_ball(board, ball_pos, ball_positions)
    print(valid_moves)
    
def delete_ball(board, pos, ball_positions): #It deletes the ball in given position from both board and ball_positions
    board[int(pos[0])][int(pos[1])]=0  
    ball_positions.remove(pos)
    
def check_collision(board, pos): #It detects the collision by looking for repetation in ball_positions because if there is a ball in that position and the player moves another ball to that position there is two of them.
    if len(set(pos))==len(pos):
        return False
    else:
        return True



         

def main():
    len_board = 5
    board = [[0 for col in range(len_board)] for row in range(len_board)]  
 
    while True:
        ball_positions = [(randint(0, len_board-1), randint(0, len_board-1)) for i in range(3)]
        if len(ball_positions) == len(set(ball_positions)):
            break
    
    for pos in ball_positions:
        board[pos[0]][pos[1]] = 1

    start_time = time.time()
    
    while True:
        display_ball_positions(ball_positions)
        display_board(board)
        
        if len(ball_positions) == 1:
            break
        
        ball_pos = choose_ball(board)
        
        valid_moves = get_valid_moves(ball_pos, len(board))
        print("Valid moves:", valid_moves)
        
        make_move(board, ball_pos, valid_moves, ball_positions)
        
    end_time = time.time()

    minutes, seconds = divmod(end_time-start_time, 60)
    hours, minutes = divmod(minutes, 60)
    print("Game Over!")
    print("Passed time= {:02d}:{:02d}:{:02d}".format(int(hours), int(minutes),int(seconds)))
    
main()

