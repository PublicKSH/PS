import sys
read = sys.stdin.readline

stringOne, stringTwo = read().strip(), read().strip()

d = [0] * (len(stringTwo) + 1)
for i in range(len(stringOne)):
    count = 0
    for j in range(len(stringTwo)):
        if count < d[j]:
            count = d[j]
        elif stringOne[i] == stringTwo[j]:
            d[j] = count + 1
    

print(max(d))