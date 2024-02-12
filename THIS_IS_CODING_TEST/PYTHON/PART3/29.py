# todo: 다시풀기
# start 는 1  부터 시작

import sys
input = sys.stdin.readline
n, c = map(int, input().split())
array = []
for i in range(n):
    array.append(int(input()))
array.sort()

start=1
end=array[-1] - array[0]
result = 0
while (start <= end):
    mid = (start + end) // 2
    value = array[0]
    count = 1
    for i in range(1, n):
        if array[i] >= value + mid:
            value = array[i]
            count += 1
    if count >= c:
        result = mid
        start = mid + 1
    else:
        end = mid - 1

print(result)   
