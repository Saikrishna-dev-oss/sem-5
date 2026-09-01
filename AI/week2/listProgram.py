def AppendElement(l):
    ele = int(input("Enter the Element to Add: "))
    l.append(ele)
    print("List after Appending Element: ", l)

def InsertElement(l):
    pos = int(input("Enter the Position and Element to update: "))
    ele = int(input("Enter the Position and Element to update: "))
    l.insert(pos, ele)
    print("List after Inserting Element: ",l)

def access(l):
    idx = int(input("Enter the index to Access: "))
    print("Element at Index is: ",l[idx])

def update(l):
    pos = int(input("Enter the Position and Element to update: "))
    ele = int(input("Enter the Position and Element to update: "))
    l[pos] = ele
    print("List after Updating: ", l)

def delete(l):
    pos = int(input("Enter the Position(i - 1) / Index to Delete: "))
    del l[pos]
    print("List after Deleting is: ", l)

def repeat(l):
    n = int(input("Enter the Number to Repeat the List: "))
    print("List After Repeating is: ", l * n)

def mergee(l):
    m = [5, 10, 15, 20]
    print("List after Merged: ", l + m)

def extendd(l):
    l1 = [5, 10, 15, 20]
    l.extend(l1)
    print("List after Extended Array: ", l)

def sortAsc(l):
    l.sort()
    print("List After Sorting is: ", l)

def sortDes(l):
    l.sort(reverse = True)
    print("List After Descending Sorting is: ", l)

def slicing(l):
    left_idx = int(input("Enter the Left Index for Slicing: "))
    right_idx = int(input("Enter the right index for Slicing: "))
    print("Slicing with left index : ", l[left_idx:])
    print("Slicing with right index: ", l[:right_idx])
    print("Slicing with left and right index: ", l[left_idx:right_idx])

def search(l):
    ele = int(input("Enter the Element to Search : "))
    if ele in l:
        print(f"Element {ele} Found")
    else:
        print(f"Element {ele} Not Found")

def nestedList(l):
    fruits = ["apple", "mango", "banana"]
    l.append(fruits)
    print("List After Append Fruits: ", l)

l = [30, 40, 50]
print("List is:", l)

while(True):
    print("\n ----- Choose the Operation to perform: -----\n ")
    print("1. Append    2. Insert   3. Access   4. Update ")
    print("5. Delete    6. Repeat   7. Min      8. Max    ")
    print("9. Length    10. Merge   11. Extend  12.Sort Ascending")
    print("13. Sort Descending      14. Slicing     15. Search     16. Nested List")
    print("17. Display   18. Exit")
    ch = int(input("\nEnter the Choice: \n"))
    try:
        match (ch):
            case 1: AppendElement(l)
            case 2: InsertElement(l)
            case 3: access(l)
            case 4: update(l)
            case 5: delete(l)
            case 6: repeat(l)
            case 7: print("\nMinimum Of List is: ", min(l))
            case 8: print("\nMaximum Of List is: ", max(l))
            case 9: print("\nLength Of List is: ", len(l))
            case 10: mergee(l)
            case 11: extendd(l)
            case 12: sortAsc(l)
            case 13: sortDes(l)
            case 14: slicing(l)
            case 15: search(l)
            case 16: nestedList(l)
            case 17: print("\nElements are : ", l)
            case 18: 
                print("Exiting program. Goodbye!")
                break
            case _: print("Choose a Valid Operation !!")
    except :
        print(Exception)
