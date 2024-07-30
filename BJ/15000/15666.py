import sys
input = sys.stdin.readline


n, m = map(int, input().split())
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
    # 같은 depth에서만 중복 수가 안나오도록 처리하면 됨
    temp = 0    
    for i in range(n):
        if (temp != arr[i]):
            if (depth >=1 and result[depth-1] <= arr[i]):
                temp = arr[i]
                result[depth] = arr[i]
                dfs(depth + 1)
            elif (depth ==0):
                temp = arr[i]
                result[depth] = arr[i]
                dfs(depth + 1)
            

dfs(0)