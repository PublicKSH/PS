import sys
sys.stdin = open("TEST_TXT/5_10_1.txt", "r")

n, m = map(int, input().split())

array = []
for i in range(n):
    array.append(list(map(int, input())))

print(array)