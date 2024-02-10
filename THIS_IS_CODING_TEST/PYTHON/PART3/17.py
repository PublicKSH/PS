n, k = map(int, input().split())
borad = [[] for _ in range(n)]
for i in range(n):
    borad[i] = list(map(int, input().split()))

s, x, y = map(int, input().split())

print(borad)
# heapq 에 (1, 위치) 이런 식으로 넣어서 heappop하면서 전염