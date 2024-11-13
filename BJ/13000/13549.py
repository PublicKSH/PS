from collections import deque
n, k = map(int, input().split())
dp = [-1 for i in range(200000)]
q = deque()
