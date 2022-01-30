#Problem 0
#Name: Vishal Vaidhyanathan
#AndrewID: vvaidhya
print('\n--------------------------------------------------------------\n')
#Problem 1
person1 = 'Bob,1,200.1'
person2 = 'Mary,2,350.75'
person3 = 'Larry,12,3215.0'
print(person1)
print(person2)
print(person3)
print(person1.upper())
print(person2.lower())
print(len(person3))
print('\n--------------------------------------------------------------\n')
#Problem 2
name1, pets1, cost1 = person1.split(',', 2)
print(name1)
print(pets1)
print(cost1)
name2, pets2, cost2 = person2.split(',', 2)
print(name2)
print(pets2)
print(cost2)
name3, pets3, cost3 = person3.split(',', 2)
print(name3)
print(pets3)
print(cost3)
print('\n--------------------------------------------------------------\n')
#Problem 3
cost1 = float(cost1)
cost2 = float(cost2)
cost3 = float(cost3)
pets1 = int(pets1)
pets2 = int(pets2)
pets3 = int(pets3)
print("cost1 =${0:8.2f} cost2 =${1:8.2f} cost3 =${2:8.2f}".format(cost1,cost2,cost3))
print("pets1 ={0:5} pets2 ={1:5} pets3 ={2:5}".format(pets1,pets2,pets3))
print('\n--------------------------------------------------------------\n')
#problem 4
total = cost1 + cost2 + cost3
numPets = pets1 + pets2 + pets3
averageCost = total/numPets
print("Number of pets : {0:5}".format(numPets))
print("Total vet cost : {0:8.2f}".format(total))
print("Average cost : {0:8.2f}".format(averageCost))
print('\n--------------------------------------------------------------\n')
#problem 5
print("{0:>10}{1:>10}{2:>10}".format("Name","Cost","# Pets"))
print("{0:>10} ${1:>8.2f}{2:>10}".format(name1,cost1,pets1))
print("{0:>10} ${1:>8.2f}{2:>10}".format(name2,cost2,pets2))
print("{0:>10} ${1:>8.2f}{2:>10}".format(name3,cost3,pets3))
print("{0:>10} ${1:>8.2f}".format("Total : ",total))
print('\n--------------------------------------------------------------\n')
#Problem 6
dollars = float(input("Enter an amount in US dollars: "))
bahts = 32.71 * dollars
print("{0:8.2f} US Dollars = {1:8.2f} Thai Baht".format(dollars, bahts))
bahts = float(input("Enter an amount in Thai Baht: "))
dollars = bahts / 32.71
print("{0:8.2f} Thai Baht = {1:8.2f} Dollars".format(bahts, dollars))
print('\n--------------------------------------------------------------\n')
#Problem 7
if bahts > 10000: print("That's a lot of Baht")
else: print("Not so much")
if dollars < 100: print("That's not many Dollars")
else: print("You're rich!")
print('\n--------------------------------------------------------------\n')
#Problem 8
monthName = input("Enter the name of the Month : ")
day = input("Enter the day of the month : ")
monthKey = {'January': 1,
            'February': 2,
            'March': 3,
            'April': 4,
            'May': 5,
            'June': 6,
            'July': 7,
            'August': 8,
            'September': 9,
            'October': 10,
            'November': 11,
            'December': 12}
month = monthKey[monthName]
print("{0:10} {1:02}, 2019".format(monthName, int(day)))
print("{0:02}/{1:02}/2019".format(int(month),int(day)))
print('\n--------------------------------------------------------------\n')
#Problem 9
x, y, z = 2.45, 3, 10
print((x + y) / 2.0)
print((2 * z * y) // 7)
print((2 * z * y) % 7)
print((x + y + z) / 3)
print(z * ((100 - x ** 4) / ((10 * y) ** 0.5)))
s = 'Poptarts'
t = 'are' 
u = 'tasty'
print(s.index('a'))
print(t.index('a'))
print(u.index('a'))
v = s + " " + t + " " + u
print(v)
print(s*3)
print('z' in u)
print(len(s) + len(t) + len(u))
print('\n--------------------------------------------------------------\n')
#Problem 10
print((x>5) and (x<5))
print((x>5) or (x<5))
print(not (x == 5))
print(len(u) >= 5)
print(t == u)
print((z > 0) and ('P' in u))
print(x >= 0)
print(len(s) >= x)
print(x/y > 0)
print(u.find('st') > 1 and u.find('st') < 3)