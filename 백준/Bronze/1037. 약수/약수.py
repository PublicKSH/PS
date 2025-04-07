
def GCD(x,y):
    newY = y
    newX = x
    while(newY):
        newX,newY = newY,newY%newX
    return x
def LCM(x,y):
    result = (x*y//GCD(x,y))
    return result

m = int(input())
list = list(map(int, input().split()))

result = list[0]
for i in range(1, len(list)):
    result = LCM(min((result, list[i])), max(result, list[i]))

if (result in list):
    result *= min(list)

print(result)
