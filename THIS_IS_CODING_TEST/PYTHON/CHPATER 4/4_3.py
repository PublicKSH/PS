inputData = input()
row = int(inputData[1])
column = int(ord(inputData[0])) - int(ord('a')) + 1

print("row",row)
print("column",column)

# ord() 함수 습득

steps = [(-2, -1), (-2, 1), (-1, 2), (-1, -2), (1, 2), (1, -2), (2, 1), (2, -1)]

count = 0
for step in steps:
    nextRow = row + step[0]
    nextColumn = column + step[1]
    if (nextRow > 0 and nextColumn > 0 and nextRow < 9 and  nextColumn < 9):
        count += 1

print(count)
