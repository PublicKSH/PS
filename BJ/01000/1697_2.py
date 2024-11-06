# solved problem by using bfs
from collections import deque
n,k = map(int, input().split())
dist = [-1 for _ in range(100001)]
q = deque()
q.append(n)
dist[n] = 0
while dist[k] == -1:
    num = q.popleft()
    for next in [num -1, num +1, num * 2]:
        if 0<=next<=100000 and dist[next] == -1:
            dist[next] = dist[num] +1
            q.append(next)

print(dist[k])