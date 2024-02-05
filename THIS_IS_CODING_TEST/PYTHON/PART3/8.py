s = input()

sList = [char for char in s if char.isalpha()]
intList = [int(char) for char in s if not char.isalpha()]

sList.sort()
intList.sort()

for i in range(len(sList)):
    print(sList[i], end='')
print(sum(intList), end='')