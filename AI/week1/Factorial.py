def Factorial(n):
    fact = 1

    for i in range(2, n + 1):
        fact *= i
    
    return fact

num = int(input("Enter the Value to Find the Factorial: "))
result = Factorial(num)
print(f"Factorial of the Number is: {result}")