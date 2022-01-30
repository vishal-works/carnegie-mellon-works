import sys

# openFile(filename)
# Parameters: filename - str
# Opens a text file named 'filename' for reading.
# Catches an exception if the file does not open and exits.
# Returns: f - file
def openFile(filename):
    try:
        f = open(filename, "r")
    except:
        print("ERROR: {} could not be opened".format(filename))
        sys.exit(0)
    else:
        print("{} open".format(filename))
        return f

# makeMovieList(f)
# Parameters: f - file
# Parses a file line by line and makes a list.
# Returns: bigList - list
def makeMovieList(f):
    bigList = []
    lines = f.readlines()
    for i in lines:
        i = i.strip()
        bigList.append(i.split("\t"))
    f.close()
    return bigList

# makeMovieDictionary(someList)
# Parameters: someList - list
# Parses a list and makes a dictionary.
# Returns: movieDictionary - dictionary
def makeMovieDictionary(someList):
    movieDictionary = dict()
    for i in someList:
        movieDictionary[i[1].upper()] = i
    return movieDictionary

# search(movieName, movieDictionary)
# Parameters: movieName - str, movieDictionary - dict
# Searches for a movie from a movie dictionary.
# Returns: TRUE if found, FALSE if not.
def search(movieName, movieDictionary):
    if movieName.upper() in movieDictionary:
        movie = movieDictionary[movieName.upper()]
        print("Found: {}\nID: {}\nYear: {}\nCountry: {}\nGenres: {}".format(movie[1],movie[0],movie[2],movie[3].strip('"')," ".join(movie[4:])))
        return True
    else:
        print("{} not found".format(movieName))
        return False

# displayHeader(name)
# Parameters: name - str
# Displays an introduction/header with input name.
# Returns: N/A
def displayHeader(name):
    print("A Cool Movie Search Application")
    print("Created by: " + name)
    print("Powered by Python")

# main()
# Parameters: N/A
# Main function of the program.
# Returns: N/A
def main():
    displayHeader("Vishal")
    file = openFile("MoviesDB.tsv")
    movies = makeMovieList(file)
    dictionary = makeMovieDictionary(movies)
    numberFound, numberNotFound = 0, 0
    choice = input("Enter movie title to search or 'quit' to exit: ")
    while(choice != 'quit'):
        found = search(choice,dictionary)
        if found: numberFound += 1
        else: numberNotFound += 1
        choice = input("Enter movie title to search or 'quit' to exit: ")
    print("Number of titles found: " + str(numberFound))
    print("Number of titles not found: " + str(numberNotFound))
    print("Number of titles searched: " + str(numberFound + numberNotFound))

if __name__ == '__main__':
    main()