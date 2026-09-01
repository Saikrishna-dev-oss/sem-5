# WEEK-3
# WATER JUG

max_j1 = 4
max_j2 = 3

j1 = 0
j2 = 0


def j2_fill():
    global j2
    j2 = max_j2


def j1_empty():
    global j1
    j1 = 0

def j2j1_pour():
    global j1, j2

    if j1 + j2 <= max_j1:
        j1 = j1 + j2
        j2 = 0
    else:
        j2 = j2 - (max_j1 - j1)
        j1 = max_j1


print("j1\tj2")

print(j1, "\t", j2)

j2_fill()
print(j1, "\t", j2)

j2j1_pour()
print(j1, "\t", j2)

j2_fill()
print(j1, "\t", j2)

j2j1_pour()
print(j1, "\t", j2)

j1_empty()
print(j1, "\t", j2)

j2j1_pour()
print(j1, "\t", j2)