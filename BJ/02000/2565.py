n = int(input())
setList = []
# listB = [0] * 501
d = [1] * 501
for i in range(n):
    x, y = map(int, input().split())
    setList.append((x,y))
    # listB[y] = x

def setting(data):
    return data[0]

setList = sorted(setList, key=setting)
for i in range(len(setList)):
    for j in range(i):
        if setList[j][1] < setList[i][1]:
            d[i] = max(d[i], d[j] + 1)

print(n - max(d))