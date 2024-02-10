# 틀린 이유 1e9 는 10억이 아니다

import sys
from itertools import permutations
input = sys.stdin.readline
n = int(input())
numList = list(map(int, input().split()))
add, sub, mul, div = map(int, input().split())
minResult = 2e9
maxResult = -2e9
addList = ['add'] * add
subList = ['sub'] * sub
mulList = ['mul'] * mul
divList = ['div'] * div
opeartionList = permutations(addList + subList + mulList + divList)

def caculate(numList, opeartions):
    result = numList[0]
    for i in range(1, len(numList)):
        if opeartions[i-1] == 'add':
            result += numList[i]
        if opeartions[i-1] == 'sub':
            result -= numList[i]
        if opeartions[i-1] == 'mul':
            result *= numList[i]
        if opeartions[i-1] == 'div':
            result = int(result / numList[i])
    return result
for opeartions in opeartionList:
    caculatedNum = caculate(numList, opeartions)
    if caculatedNum < minResult:
        minResult = caculatedNum
    if caculatedNum > maxResult:
        maxResult = caculatedNum


print(maxResult)
print(minResult)