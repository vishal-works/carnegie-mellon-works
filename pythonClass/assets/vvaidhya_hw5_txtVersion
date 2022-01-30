#Name: Vishal Vaidhyanathan
#AndrewID: vvaidhya

import sys
#--------------------------------------------------------------

# createDictionary(filename)
# Parameters: filename - str
# Opens a text file named 'filename' to make a dictionary.
# Catches an exception if the file does not open and exits.
# Returns: d - dictionary
def createDictionary(filename):
    d = dict()
    try:
        f = open(filename, "r")
    except:
        print("ERROR: {} could not be opened".format(filename))
        sys.exit(0)
        
    #Parsing the file to make dictionary
    
    lines = f.readlines()
    for i in range(len(lines)):
            pointer = lines[i].find('(')
            word = lines[i][:pointer].strip()
            definition = lines[i][pointer:].strip()
            if word.upper() not in d:
                d[word.upper()] = [definition]
            else:
                d[word.upper()].append(definition)
    f.close()
    return d
#--------------------------------------------------------------

# displayDefnintions(word, definition)
# Parameters: word, definition - str,str
# Displays the word's multiple definitions
# Returns: None
def displayDefinitions(word,definition):
    print("{}: ".format(word))
    for i in range(len(definition)):
        print("{}: {}".format(i+1,definition[i]))
#--------------------------------------------------------------

# fileToList(f)
# Parameters: f - file object
# Converts lines in a file to a list.
# Returns: lines - list containing the lines in the file.
def fileToList(f):
    lines = []
    while True:
        line = f.readline()
        if not line: break
        elif not line.strip(): continue #to prevent blank lines
        lines.append(line.strip())
    f.close()
    return lines
#--------------------------------------------------------------

# header()
# Parameters: None
# Prints the header of the program.
# Returns: None
def header():
    print("\n\n------------------------------------------------------------------------------------------------------------------------")
    print(" __     __  _         _               _   _           ____    _          _     _                                        ")
    print(" \ \   / / (_)  ___  | |__     __ _  | | ( )  ___    |  _ \  (_)   ___  | |_  (_)   ___    _ __     __ _   _ __   _   _ ")
    print("  \ \ / /  | | / __| | '_ \   / _` | | | |/  / __|   | | | | | |  / __| | __| | |  / _ \  | '_ \   / _` | | '__| | | | |")
    print("   \ V /   | | \__ \ | | | | | (_| | | |     \__ \   | |_| | | | | (__  | |_  | | | (_) | | | | | | (_| | | |    | |_| |")
    print("    \_/    |_| |___/ |_| |_|  \__,_| |_|     |___/   |____/  |_|  \___|  \__| |_|  \___/  |_| |_|  \__,_| |_|     \__, |")
    print("                                                                                                                  |___/ ")
    print("------------------------------------------------------------------------------------------------------------------------\n\n")
    input("Enter return to continue  ")
#--------------------------------------------------------------

# main()
# Parameters: None
# Main funciton of the program.
# Returns: None
def main():
    header()
    d = createDictionary("dictionary.txt")
    file = input("\nEnter the name of the file: ")
    try:
        f = open(file, "r")
    except:
        print("ERROR: {} could not be opened".format(file))
        sys.exit(0)
    lines = fileToList(f)
    words = 0
    wordsFound = 0
    for i in range(len(lines)):
        print("\n({}) {}".format(i+1,lines[i]))
        word = input("\nLook up a word : ")
        while word != "":
            words += 1
            if word.upper() not in d: print("{} not found".format(word))
            else:
                displayDefinitions(word, d[word.upper()])
                wordsFound += 1
            word = input("\nLook up a word : ")
    
    print("\nTotal number of words searched : {}\nNumber of words in dictionary: {}\nNumber of words not in Dictionary: {}".format(words,wordsFound,words-wordsFound))
#--------------------------------------------------------------

if __name__ == "__main__":
    main()
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    