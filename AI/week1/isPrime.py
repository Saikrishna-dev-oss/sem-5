import math as m

def isPrime(n):

    flag = False
    for i in range(2, int(m.sqrt(n))):
        if(n % i == 0):
            flag = True
            break
        
    result = "Not Prime" if flag else "Prime"
    print(result)


n = int(input("Enter the Number: "))
isPrime(n)
