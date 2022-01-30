#Problem 0
#Name: Vishal Vaidhyanathan
#AndrewID: vvaidhya
print('\n--------------------------------------------------------------\n')
#Problem 1
exponents = []
for i in range(1,11,1):
    exponents.append(2**i)
print("{:<10} {:>10}".format("Value","2^Value"))
for j in range(len(exponents)):
    print("{:<10} {:>10}".format(j+1,exponents[j]))
print('\n--------------------------------------------------------------\n')
#Problem 2
ogString = ' log, fog, bog, dog, hog, cog, nog, jog'
print(ogString)
ogWords = ogString.split(',')
for words in ogWords:
    print(words)
ogWords.sort()
for words in ogWords:
    print("{:<4}{:>4}".format(words,words.upper()))
print('\n--------------------------------------------------------------\n')
#Problem 3
weight = float(input("Enter your weight in pounds : "))
print("Enter your weight as feets and inches")
feet = float(input("Feet: "))
inch = float(input("Inches: "))
bmi = 703 * weight/((feet*12 + inch)**2)
print("Your BMI is {:3.1f}".format(bmi))
waist = float(input("Enter your waist size in inches: "))
hip = float(input("Enter your hip size in inches: "))
gender = input("Enter your gender, male or female: ")
ratio = waist/hip
print("Your waist-to-hip ratio is: {:4.2f}".format(ratio))
if bmi<15:
    category = "Very severely underweight"
elif 15 <= bmi < 16:
    category = "Severely underweight"
elif 16 <= bmi < 18.5:
    category = "Underweight"
elif 18.5 <= bmi < 25:
    category = "Normal"
elif 25 <= bmi < 30:
    category = "Overweight"
elif 30 <= bmi < 35:
    category = "Moderately obese"
elif 35 <= bmi < 40:
    category = "Severely obese"
elif bmi >= 40:
    category = "Very severely obese"
print("Your BMI category is:\n" + category)
if gender == "male":
    if ratio < 0.9:
        wcategory = "Normal Weight"
    elif 0.9 <= ratio < 1:
        wcategory = "Overweight"
    elif ratio > 1:
        wcategory = "Obese"
elif gender == "female":
    if ratio < 0.8:
        wcategory = "Normal Weight"
    elif 0.8 <= ratio < 0.85:
        wcategory = "Overweight"
    elif ratio > 0.85:
        wcategory = "Obese"
print("Your Waist-To-Hip category is:\n" + wcategory)
print('\n--------------------------------------------------------------\n')
#Problem 4
file = open('shoppingList.csv', 'r') 
lines = file.readlines()
total = []
print("{:>15}{:>15}{:>15}{:>10}{:>10}".format("Item","#Needed","Unit to buy", "Price","Amount"))
print("--------------------------------------------------------------------")
total = 0
for i in range(len(lines)):
    variables = lines[i].split(",")
    amount = float(variables[1])*float(variables[3])
    
    #if there is a need to calculate per unit(eg. 1 roll of toilet paper)
    """
    count = variables[2].split(" ")
    if(count[0].isnumeric()):
        amount = float(variables[1])*float(variables[3])/float(count[0])
    else:
        amount = float(variables[1])*float(variables[3])
    """
    
    total += amount
    print("{:>15}{:>15}{:>15}  ${:>8.2f}  ${:>8.2f}".format(variables[0],int(variables[1]),variables[2],float(variables[3]),amount))
print("--------------------------------------------------------------------")
print("Grand Total: ${:6.2f}".format(total))
file.close()
print('\n--------------------------------------------------------------\n')   
#Problem 5
groceryList = []
file = open('shoppingList.csv', 'r') 
lines = file.readlines()
for i in range(len(lines)):
    variables = lines[i].split(",")
    groceryList.append(variables)
search = input("Enter an item or 'quit': ")
while(search != 'quit'):
    found = False
    for i in groceryList:
        if i[0] == search:
            found = True
            item = i
    if found == False: print("Item not found!")
    elif found == True:
        print("Item: {}\nNeeded: {}\nUnit: {}\nPrice: {}".format(item[0],item[1],item[2],item[3]))
    search = input("Enter an item or 'quit': ")
file.close()
print('\n--------------------------------------------------------------\n')
#Problem 6
data = [5, -10, 17, 90, -3, 44, 5, 5, -3, 50, 5, 100]
#(a)
data[data.index(17)] = 27
print(data)
#(b)
print(data.pop(-1))
print(data)
#(c)
data.append(20)
print(data)
#(d)
data[0] += 10
data[-1] += 20
print(data)
#(e)
data = list(set(data))
print(data)
#(f)
data.sort()
print(data)
#(g)
subdata = data[2:7]
print(subdata)
