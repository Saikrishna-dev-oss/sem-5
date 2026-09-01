# l1 = [10, "hi", 9.11]
# print(l1)
# l2 = [10, 20]
# print(l2)

# print(l1+l2)
# l1.append(l2)
# print(l1[3])
# print(l1[-1])

# Append
print("\nAppend")
l = []
l.append(10)
l.append(100)
l.append(1000)
print(l)

## Insert
print("\nInsert")
l.insert(1, 69)
print(l)

## update
print("\nUpdate")
l[0] = 5
print(l)

## del
print("\n Delete")
del l[3]
print(l)

## access
print("\nAccess")
print(l[0])
print(l[::])
print("Length:",len(l))

#  Min(), max()
print("\nMin Max")
print(min(l))
print(max(l))


# Merge
print("\nMerge")
A = [500, 600, 700, 800]
print(l + A)
print(l, A)

# Extend
print("\nExtend")
l.extend(A)
print(l)
print(A)

# Sorting
l.sort
print(l)
l.sort(reverse=True)
print(l)

# Slicing
print("\nSlicing")
print(l[:3])
print(l[:-1])
print(l[::])
print(l[1:6:2])

# Nested Lists
print("\nNested Lists")
B = [10, 20 , [30, 40], 50]
print(B[2])
print(B[2][1])

# Repeat
print(B * 3)
print(B)