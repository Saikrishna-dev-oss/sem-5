def fibonacci_sequence(n):
    f1, f2 = 0, 1
    f3 = f1 + f2
    print("Fibonacci Series: ")
    for i in range(n):
        print(f1, end=" ")
        f1, f2 = f2, f3
        f3 = f1 + f2


n = int(input("Enter the number of terms for the Fibonacci sequence: "))
fibonacci_sequence(n)
