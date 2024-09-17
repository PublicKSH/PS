import sys
input = sys.stdin.readline

n,m = map(int, input().split())
arr = list(map(int, input().split()))
visited = [False for i in range(n)]
result = [0 for i in range(m)]
arr.sort()

def dfs(depth):
    if depth == m:
        for num in result:
            print(num, end=' ')
        print()
        return
    
    # 이 temp 변수가 핵심이다. 
    # temp 변수는 depth 마다 다르게 관리되기 때문에 잘써야한다.
    temp = 0 
    for i in range(n):
        if visited[i] == False and temp != arr[i]:
            result[depth] = arr[i]
            temp = arr[i]
            visited[i] = True
            dfs(depth + 1)
            visited[i] = False


dfs(0)
    
