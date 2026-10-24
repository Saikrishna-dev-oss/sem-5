# WEEK-5
## 8-Puzzle Program

start = [1, 2, 3, 4, 0, 6, 7, 5, 8]
goal = [1, 2, 3, 4, 5, 6, 7, 8, 0]

print("Initial State:")
print(start[0:3])
print(start[3:6])
print(start[6:9])

while start != goal:
    for i in range(9):
        if start[i] != goal[i] and start[i] != 0:
            blank = start.index(0)

            if abs(i - blank) == 3 or (abs(i - blank) == 1 and i // 3 == blank // 3):
                start[i], start[blank] = start[blank], start[i]
                break

    print("\nNext State:")
    print(start[0:3])
    print(start[3:6])
    print(start[6:9])

print("\nGoal Reached!")
