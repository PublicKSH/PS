# 3 => 3 + 2*2
n = int(input())
threeArray = [0] * n
twoArray = [0] * n

a = 1
b = 0
for i in range(1,n):
    tempA = a
    tempB = b
    a = tempA+tempB
    b = 2*tempA+tempB

print((a*3 + b*2) % 9901)
