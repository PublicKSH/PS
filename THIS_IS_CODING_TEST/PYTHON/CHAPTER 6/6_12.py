import sys
sys.stdin = open("TEST_TXT/6_12.txt", "r")

n, k = map(int, input().split())
listA = list(map(int, input().split()))
listB = list(map(int, input().split()))
listA = sorted(listA)
listB = sorted(listB, reverse=True)

for i in range(k):
    if listA[i] < listB[i]:
        listA[i], listB[i] = listB[i], listA[i]

print(listA)