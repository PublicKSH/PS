import sys
input = sys.stdin.readline

n,m = map(int, input().split())
arr = [0] + list(map(int, input().split()))
sum = [0] + [0 for _ in range(0,n)]
for i in range(1,n+1):
    sum[i] = sum[i-1] + arr[i]

for i in range(0,m):
    a,b = map(int, input().split())
    print(sum[b] - sum[a-1])