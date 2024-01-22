# 에라토스테네스의 체
import sys

MAX = 1000000
decimalArr = [True] * (MAX + 1)
decimalArr[0] = False
decimalArr[1] = False
primeArr = []
# for i in range(2, int(math.sqrt(MAX)) + 1):
#     if decimalArr[i] == True:
#         j = 2
#         while (i * j) <= MAX:
#             decimalArr[i*j] = False
#             j += 1
for i in range(2, 1001):
        if (decimalArr[i] == True):
            for k in range(i + i, 1000001, i):
                decimalArr[k] = False

for i in range(1, MAX + 1):
    if i == 2:
        continue
    if decimalArr[i]:
        primeArr.append(i)

while True:
    n = int(sys.stdin.readline())
    if (n == 0):
        break
    
    isFailed = True
    for i in range(3, n, 2):
       if (decimalArr[i] and decimalArr[n - i]):
           print(n, "=", i, "+", n - i)
           isFailed = False
           break
    
    if isFailed:
        print("Goldbach's conjecture is wrong.")