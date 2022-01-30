#Problem 0
#Name: Vishal Vaidhyanathan
#AndrewID: vvaidhya
print('\n--------------------------------------------------------------\n')
#Problem 1
A = set([e for e in range(-5,11,1)])
print(A)
B = set([e for e in range(5,16,1)])
print(B)
print(A.union(B))
print(A.intersection(B))
print(A-B)
print(B-A)
print((A-B).union(B-A))
print('\n--------------------------------------------------------------\n')
#Problem 2
first = ("A","begin",1,"start",1.0)
last = ("Z","end",26,"omega",26.0)
print(first)
print(last)
print(first[0])
print(first[2])
print(last[0])
print(last[2])
print(type(first))
print(type(last))
for i in first: print(i)
for i in last: print(i)
firstList = [e for e in first]
print(firstList)
print(type(firstList))
lastList = [e for e in last]
print(lastList)
print(type(lastList))
numbers = [e for e in range(65,91,1)]
print(numbers)
letters = [chr(e) for e in numbers]
print(letters)
for i in range(len(numbers)) : print("{}{}".format(letters[i],numbers[i]))
letterToNumber = dict(zip(letters,numbers))
word = input("Enter any word : ")
for i in word:
    print("{}   {}".format(i.upper(),letterToNumber[i.upper()]))
print('\n--------------------------------------------------------------\n')
#Problem 3
names = dict(zip(["Bob", "Sally", "Moe"], [100,200,150]))
print(names)
names["Curly"] = 75
names["Shemp"] = 300
names["Larry"] = 28
print(names)
for i in names: print(i)
for i in names: print(names[i])
for i in names.items(): print(i)
name = input("Enter a Name or quit : ")
while(name != 'quit'):
    if(name in names): print(names[name])
    else: print("not found")
    name = input("Enter a Name or quit : ")
print('\n--------------------------------------------------------------\n')
#Problem 4
quotes = dict()
f = open("quotes.txt","r")
lines = f.readlines()
for i in lines:
    a,b = i.split(",")
    quotes[a] = b.strip()
print(quotes)
names = [e for e in quotes]
names.sort()
print(names)
for i in names: print(i, end = ' ')
person = input("Enter a person or Enter done : ")
while(person != 'done'):
    if(person in quotes): print("'{}' - {}.".format(quotes[person],person))
    else: print("Name not found, try again!")
    person = input("Enter a person or Enter done : ")
genius = [e for e in names if e[0]=='M' or e[0]=='B']
print(genius)
for i in genius:
    print("{} - {}".format(i,quotes[i]))
