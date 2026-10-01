
def displayBoard(board):

    print("--- WELCOME TO TIC TAC TOE ---")
    print("-----------------")
    print(f"    {board[1]} | {board[2]} | {board[3]} ")
    print("   ---|---|---")
    print(f"    {board[4]} | {board[5]} | {board[6]} ")
    print("   ---|---|---")
    print(f"    {board[7]} | {board[8]} | {board[9]} ")
    print("-----------------")


def checkWin(board):
    return (board[1] == board[2] == board[3] != " ") or (board[4] == board[5] == board[6] != " ") or  (board[7] == board[8] == board[9] != " ") or  (board[1] == board[4] == board[7] != " ") or  (board[2] == board[5] == board[8] != " ") or (board[3] == board[6] == board[9] != " ") or (board[1] == board[5] == board[9] != " ") or (board[3] == board[5] == board[7] != " ")
    

# board = ['0','1', '2', '3', '4', '5', '6', '7', '8', '9']
board = [' ',' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ']


player = 'X'
moves = 0
while moves < 9:
    displayBoard(board)
    position = int(input(f"Enter {player} Position (1 - 9): "))
    if board[position] == " ":
        board[position] = player
        moves += 1
    else:
        print("Position Already Occupied !!")
        continue

    if checkWin(board):
        displayBoard(board)
        print(f"Player {player} Wins")
        break
    if player == 'X':
        player = 'O'
    else:
        player = 'X'
else:

    print("GAME DRAW !!")


