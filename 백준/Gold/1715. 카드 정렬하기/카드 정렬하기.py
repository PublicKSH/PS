import sys
import heapq
input = sys.stdin.readline

n = int(input())
p = []
result = 0
for i in range(n):
    heapq.heappush(p, int(input()))
if n == 1:
    print(0)
if n != 1:
    while len(p) >= 2:
        a = heapq.heappop(p)
        b = heapq.heappop(p)
        result += (a+b)
        heapq.heappush(p, a + b)
    # if len(p) == 1:
        # result += p[0]
    print(result)