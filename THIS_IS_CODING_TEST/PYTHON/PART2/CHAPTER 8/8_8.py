import sys
sys.stdin = open("TEST_TXT/8_8_1.txt", "r")

n, m = map(int, input().split())
d = [10001] * (m + 1)
money = []
for i in range(n):
    money.append(int(input()))
money = sorted(money)

d[0] = 0
for i in range(n):
    for j in range(money[i], m+1):
        if d[j - money[i]] != 10001:
            d[j] = min(d[j], d[j - money[i]] + 1)
    

print(d[m])


