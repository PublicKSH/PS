import sys
input = sys.stdin.readline
t = int(input())
result = 0
def dfs(number):
    global result
    if number == n:
        result += 1
        return

    for i in range(1,4):
        if (i + number <= n):
            dfs(number+i)

for i in range(t):
    n = int(input())
    result = 0
    dfs(0)
    print(result)