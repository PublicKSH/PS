import heapq
n,k = map(int, input().split())

q = []
visited = [False] * 200002
heapq.heappush(q, (0, n))
visited[n] = True
while q:
    time, num = heapq.heappop(q)
    if num == k:
        print(time)
        break
    else:
        if time <= abs(k-n):
            if num-1 >= 0 and not visited[num-1]:
                q.append((time+1, num-1))
                visited[num-1] = True
            if num+1 <= 200001 and not visited[num+1]:
                q.append((time+1, num+1))
                visited[num+1] = True
            if num*2 <= 200001 and not visited[num*2]:  
                q.append((time+1, num*2))
                visited[num*2] = True