def removeDuplicate(l):
    l1 = []
    for ele in l:
        if ele not in l1:
            l1.append(ele)
    print(l1)

l = [10, 5, 5, 15, 16]
removeDuplicate(l)