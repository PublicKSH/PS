def GCD(x,y):
    newX = x
    newY = y
    while (newY):
        newX, newY = newY, newX%newY
    return newX

a, b = map(int, input().split())
print(GCD(a, b))
print(int(a*b/GCD(a, b)))