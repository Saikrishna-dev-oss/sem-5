
def csp():
    s = "SAVEMORNY"
    for S in range(1, 10):
        for A in range(10):
            for V in range(10):
                for E in range(10):

                    for M in range(1, 10):
                        for O in range(10):
                            for R in range(10):
                                for N in range(10):
                                    for Y in range(10):

                                        if len({S, A, V, E, M, O, R, N, Y}) == 9:

                                            SAVE = S * 1000 + A * 100 + V * 10 + E
                                            MORE = M * 1000 + O * 100 + R * 10 + E
                                            MONEY = M * 10000 + O * 1000 + N * 100 + E * 10 + Y

                                            if SAVE + MORE == MONEY:
                                                for ele in s:
                                                    print(f"{ele} = ", eval(ele))
                                                print("-"*10)
                                                # print("S = ", S)
                                                # print("A = ", A)
                                                # print("V = ", V)
                                                # print("E = ", E)
                                                # print("M = ", M)
                                                # print("O = ", O)
                                                # print("R = ", R)
                                                # print("N = ", N)
                                                # print("Y = ", Y)
                                            

# csp()                           

def csp2():
    v = "ONETW"
    for O in range(1, 10):
        for N in range(10):
            for E in range(10):
                for T in range(10):
                    for W in range(1, 10):

                        if len({O, N, E, T, W}) == 5:

                            ONE = O * 100 + N * 10 + E
                            TWO = T * 100 + W * 10 + O

                            if ONE + ONE == TWO:
                                for ele in v:
                                    print(f"{ele} = ", eval(ele))
                                print("-"*10)

csp2()